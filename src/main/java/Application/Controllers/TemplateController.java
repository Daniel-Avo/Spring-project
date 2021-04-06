package Application.Controllers;

import Application.Model.Users;
import Application.Services.RoleService;
import Application.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class TemplateController {

    private final RoleService roleService;
    private final UsersService usersService;

    @Autowired
    public TemplateController(RoleService roleService, UsersService usersService) {
        this.roleService = roleService;
        this.usersService = usersService;
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("register")
    public String registerUser(Model model){
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("newUser", new Users());
        return "/register";
    }

    @PostMapping("register")
    public String addUser(@Valid @ModelAttribute("newUser") Users user, BindingResult bindingResult){

        Optional<Users> optionalUser = usersService.findByUsername(user.getUserName());

        if(bindingResult.hasErrors()){

            return "/register";

        }else if (optionalUser.isPresent()){
            bindingResult.rejectValue("userName", "error.userName", "This user name is used");

            return "/register";

        }
        usersService.addUser(user);
        System.out.println(user);
        return "redirect:/login";
    }
}
