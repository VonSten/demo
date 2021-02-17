package ee.bcs.valiit.tasks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepo  extends JpaRepository<HistoryEntity, Integer> {

    List<HistoryEntity> findHistoryEntityByFromAccountOrToAccount(Integer i, Integer j);

}
