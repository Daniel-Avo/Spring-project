package Application.Services;

import Application.Model.Users;
import Application.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> listUsers(){
        return usersRepository.findAll();
    }

    public void postUser(Users users) {
        usersRepository.save(users);
    }
}
