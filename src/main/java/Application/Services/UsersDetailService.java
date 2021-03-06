package Application.Services;

import Application.Model.Users;
import Application.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UsersDetailService implements UserDetailsService {

    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersDetailService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findByUsername(username);

        if(user==null) {
            throw new UsernameNotFoundException("User " + username +" not found");
        }
        return new org.springframework.security.core.userdetails.User(user.get().getUserName(), passwordEncoder.encode(user.get().getPassword()), getGrantedAuthorities(user.get()));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Users user){
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if(user.getRole().getUserRole().equals("admin")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return grantedAuthorities;

    }
}
