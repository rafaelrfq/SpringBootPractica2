package edu.pucmm.eict.alquiler.services;

import edu.pucmm.eict.alquiler.entities.security.MyUserDetails;
import edu.pucmm.eict.alquiler.entities.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServices implements UserDetailsService {

    @Autowired
    private UserServices userServices;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServices.findUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Not found: " + username);
        }

        return new MyUserDetails(user);
    }
}
