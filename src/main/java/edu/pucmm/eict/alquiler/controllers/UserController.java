package edu.pucmm.eict.alquiler.controllers;

import edu.pucmm.eict.alquiler.entities.security.User;
import edu.pucmm.eict.alquiler.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("create")
    public String userCreate(){
        return "/users/create";
    }

    @PostMapping("create")
    public String userCreated(@ModelAttribute("user") User user, @RequestParam(name = "role") String role){
        user.setRoles(role);
        user.setActive(true);
        userServices.createUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("list")
    public String userList(Model model){
        model.addAttribute("users", userServices.usersAll());
        return "/users/list";
    }

    @GetMapping("toggle")
    public String toggleUserState(@PathParam("username") String username){
        User user = userServices.findUserByUsername(username);
        System.out.println("User is active: " + user.isActive());
        if(user.isActive()){
            userServices.deactivateUser(username);
        } else userServices.activateUser(username);
        return "redirect:/users/list";
    }

}
