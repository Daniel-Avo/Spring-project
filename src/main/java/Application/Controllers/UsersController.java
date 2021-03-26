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
        return "users/list";
    }

    @PostMapping
    public void postUser(@RequestBody Users users){
        usersService.postUser(users);
    }
}
