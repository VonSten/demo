package ee.bcs.valiit.tasks;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepo extends JpaRepository<AccountsEntity,Integer> {

List<AccountsEntity> findAccountsEntityById(Integer id);


}
