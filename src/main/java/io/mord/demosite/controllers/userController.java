package io.mord.demosite.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController class userController {

    private final Boolean IS_VERIFIED = true; 
    private final Boolean IS_NOT_VERIFIED = false;
    
    private User user = new User("Michael", "Parker", "mike@gmail.com", "mike", 0); 

    private HashMap<String, User> verifiedUsers = new HashMap(); 

    private void loadVerifiedUsers(User UserObject) {
        //Load every new user object into the HashMap upon call
        verifiedUsers.put(UserObject.getEmailAddr(), UserObject);
    }

    private User findUser(String emailAddr) {

        return verifiedUsers.get(emailAddr);
    }

    @GetMapping("/verifyEmail")
    private Boolean isVerified(@RequestParam String requestedEmail) {

        if(user.getEmailAddr().equals(requestedEmail)) {
            return IS_VERIFIED;
        } 

        return IS_NOT_VERIFIED;
    }

    @GetMapping("/userDetails")
    private User userDetails(@RequestParam String requestedEmail) {

        loadVerifiedUsers(user);

        return findUser(requestedEmail);

    }

    
}
