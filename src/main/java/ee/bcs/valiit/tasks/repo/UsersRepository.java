package ee.bcs.valiit.tasks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    UsersEntity findUsersEntityByUserName(String name);

}
