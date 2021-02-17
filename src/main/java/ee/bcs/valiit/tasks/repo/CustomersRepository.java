package ee.bcs.valiit.tasks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer> {

    List <CustomersEntity>  findCustomersEntityByFirstNameAndLastName(String firstn, String lastn);

}


