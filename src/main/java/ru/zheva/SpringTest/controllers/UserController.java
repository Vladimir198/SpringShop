package ru.zheva.SpringTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.zheva.SpringTest.dto.UserDTO;
import ru.zheva.SpringTest.service.UserService;

/**
 *
 * @author vladimir
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
   @GetMapping("/new") 
   public String newUser(Model model) {
       model.addAttribute("user", new UserDTO());
       return "user";
   }
   
   @PostMapping("/new")
   public String saveUser(UserDTO dto, Model model) {
       if (userService.equals(dto)) {
           return "redirect:/";
       } else {
           model.addAttribute("user", dto);
           return "user";
       }
       
   }
    
}
