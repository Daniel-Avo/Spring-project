package Application.Services;

import Application.Model.Role;
import Application.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> listRoles(){
        return roleRepository.findAll();
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }
}
