package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class bankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;



    public void createAcc(Customer customer){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fn", customer.getFirstName());
        paramMap.put("ln", customer.getLastName());
        String sql2 = "INSERT INTO customers (first_name,last_name ) VALUES(:fn, :ln)";

        jdbcTemplate.update(sql2, paramMap);
    }

    // TODO SQL COUNT
    public boolean checkForCustomer(Customer customer) {
        String sql = "SELECT id FROM customers WHERE first_name = :fn AND last_name = :ln";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fn",customer.getFirstName());
        paramMap.put("ln",customer.getLastName());
        try {
            Integer userId = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }


        return true;
    }


    public  Integer  getCustomerId(Customer customer) {

        String sql = "SELECT id FROM customers WHERE first_name = :fn AND last_name = :ln";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fn", customer.getFirstName());
        paramMap.put("ln", customer.getLastName());

        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void insertNewAccount(Customer customer, Integer id) {


        String sql2 = "INSERT INTO accounts (balance, owner) VALUES (:bal, :own)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("bal", 0.0);
        paramMap.put("own", id);
        jdbcTemplate.update(sql2, paramMap);

    }

    public BigDecimal getBalance(Action action){

        String sql = "SELECT balance FROM accounts WHERE id= :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", action.getAccount());
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }


    public void updateBalance(Action action, BigDecimal newBalance) {
        String sql2 = "UPDATE  accounts SET balance= :bal2  WHERE id= :id2";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id2", action.getAccount());
        paramMap.put("bal2", newBalance);
        jdbcTemplate.update(sql2, paramMap);
    }

    public void updateHistory(Action action){

        String sql ="INSERT INTO history (from_acc, to_acc, sum_tr, date_tr, time_tr) VALUES (:fr, :t, :sm, :da, :ti)";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fr", action.getAccount() );
        paramMap.put("t",  action.getAccountTo() );
        paramMap.put("sm", action.getSum() );
        paramMap.put("da", LocalDate.now().toString());
        paramMap.put("ti", LocalTime.now().toString());
        jdbcTemplate.update(sql, paramMap);


    }



}
