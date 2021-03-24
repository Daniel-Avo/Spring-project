package Application.Controllers;

import Application.Model.Users;
import Application.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> listUsers(){
        return usersService.listUsers();
    }

    @PostMapping
    public void postUser(@RequestBody Users users){
        usersService.postUser(users);
    }
}
