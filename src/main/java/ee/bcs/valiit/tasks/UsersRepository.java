package ee.bcs.valiit.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    UsersEntity findUsersEntityByUserName(String name);

}
