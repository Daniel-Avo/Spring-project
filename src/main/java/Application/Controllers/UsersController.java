package Application.Controllers;

import Application.Model.Users;
import Application.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/list")
    public String listUsers(Model model){
        model.addAttribute("users", usersService.listUsers());
        model.addAttribute("newUser", new Users());
        return "users/list";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute Users user){
        usersService.addUser(user);
        System.out.println(user);
        return "redirect:/users/list";
    }
}
