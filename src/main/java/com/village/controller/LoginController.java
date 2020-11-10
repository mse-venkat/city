package com.village.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.village.entity.Users;
import com.village.service.SecurityService;
import com.village.service.UsersService;
import com.village.validator.UserValidator;

@RestController
public class LoginController {

	
	@Autowired
    private UsersService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

//    @GetMapping("/registration")
//    public String registration(Model model) {
//        //model.addAttribute("userForm", new Users());
//    	System.out.println("venkat");
//        return "registration";
//    }

    @PostMapping("/registration")
    public String registration(@RequestBody Users userForm, BindingResult bindingResult) {
    	System.out.println("venkat"+"..."+userForm);
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        /***
        securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
	***/
        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "loginssss....";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    
    
}
