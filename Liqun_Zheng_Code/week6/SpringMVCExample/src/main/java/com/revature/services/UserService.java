package com.revature.services;

import org.springframework.stereotype.Component;

import com.revature.beans.User;

@Component
public class UserService {
    
    public User auth(User user){
        
        User authUser = null;
        
        if("john".equals(user.getUsername()) && "123".equals(user.getPassword())){
            authUser = user;
        }else {
            authUser = null;
        }
        
        return authUser;
        
    }
    
    
}