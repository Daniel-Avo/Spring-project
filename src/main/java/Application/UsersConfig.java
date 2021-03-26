package Application;

import Application.Model.Users;
import Application.Repositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersConfig {

    @Bean
    CommandLineRunner commandLineRunner( UsersRepository repository ){
        return args -> {
            Users users = new Users(
                    1L,
                    "Maria",
                    "maria@123",
                    "password"
            );

            repository.save(users);
        };
    }

}
