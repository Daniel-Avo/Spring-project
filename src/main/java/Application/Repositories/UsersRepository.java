package Application.Repositories;

import Application.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("FROM Users WHERE userName=:username")
    Users findByUsername(@Param("username") String username);
}
