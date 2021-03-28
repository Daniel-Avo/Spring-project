package Application.Controllers;

import Application.Model.Users;
import Application.Services.RoleService;
import Application.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UsersController {

    private final UsersService usersService;
    private final RoleService roleService;

    @Autowired
    public UsersController(UsersService usersService, RoleService roleService) {
        this.usersService = usersService;
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public String listUsers(Model model){
        model.addAttribute("users", usersService.listUsers());
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("newUser", new Users());
        return "users/list";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute Users user){
        usersService.addUser(user);
        System.out.println(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        model.addAttribute("message", usersService.deleteUser(id));
        return "redirect:/users/list";
    }


}
