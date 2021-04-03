package Application.Services;

import Application.Model.Users;
import Application.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addUser(Users user) {
        usersRepository.save(user);
    }

    public String deleteUser(Long id) {
        usersRepository.deleteById(id);
        return "User deleted successfully";
    }

    public Optional<Users> findByUsername(String user){
        return usersRepository.findByUsername(user);
    }
}
