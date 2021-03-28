package Application.Controllers;

import Application.Model.Role;
import Application.Model.Users;
import Application.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public String listRoles(Model model){
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("newRole", new Role());
        return "role/list";
    }

    @PostMapping("/add")
    public String addRole(@ModelAttribute Role role){
        roleService.addRole(role);
        System.out.println(role);
        return "redirect:/roles/list";
    }
}
