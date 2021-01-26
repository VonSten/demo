package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class bankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void createCustomer(Customer customer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fn", customer.getFirstName());
        paramMap.put("ln", customer.getLastName());
        String sql = "INSERT INTO customers (first_name,last_name ) VALUES(:fn, :ln)";

        jdbcTemplate.update(sql, paramMap);
    }

    public boolean checkForCustomer(Customer customer) {
        String sql = "SELECT COUNT (id) FROM customers WHERE first_name = :fn AND last_name = :ln";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fn", customer.getFirstName());
        paramMap.put("ln", customer.getLastName());

        return !jdbcTemplate.queryForObject(sql, paramMap, Integer.class).equals(0);
    }


    public Integer getCustomerId(Customer customer) {

        String sql = "SELECT id FROM customers WHERE first_name = :fn AND last_name = :ln";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fn", customer.getFirstName());
        paramMap.put("ln", customer.getLastName());

        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void insertNewAccount(Integer id) {


        String sql = "INSERT INTO accounts (balance, owner) VALUES (:bal, :own)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("bal", 0.0);
        paramMap.put("own", id);
        jdbcTemplate.update(sql, paramMap);

    }

    public BigDecimal getBalance(Integer id) {

        String sql = "SELECT balance FROM accounts WHERE id= :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }


    public void updateBalance(Integer account, BigDecimal newBalance) {
        String sql2 = "UPDATE  accounts SET balance= :bal2  WHERE id= :id2";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id2", account);
        paramMap.put("bal2", newBalance);
        jdbcTemplate.update(sql2, paramMap);
    }

    public void updateHistory(Integer accFrom, Integer accTo, BigDecimal sum) {

        String sql = "INSERT INTO history (from_acc, to_acc, sum_tr, date_tr, time_tr) VALUES (:fr, :t, :sm, :da, :ti)";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fr", accFrom);
        paramMap.put("t", accTo);
        paramMap.put("sm", sum);
        paramMap.put("da", LocalDate.now().toString());
        paramMap.put("ti", LocalTime.now().toString());
        jdbcTemplate.update(sql, paramMap);


    }


    public List<History> accountHistory(Integer account) {
        String sql = "SELECT from_acc, to_acc, date_tr, time_tr, sum_tr, first_name, last_name, CASE WHEN to_acc = from_acc AND sum_tr >0 " +
                "THEN 'deposit' WHEN to_acc = from_acc AND sum_tr < 0 THEN 'withdraw' WHEN to_acc != from_acc THEN 'transfer'" +
                " END AS transferType" +
                " FROM history JOIN accounts ON history.to_acc = accounts.id " +
                "JOIN customers ON accounts.owner = customers.id WHERE from_acc =:acc OR to_acc =:acc " +
                ";";


                  HashMap<String, Object> paramMap = new HashMap<>();
                  paramMap.put("acc", account);

        List<History> result = jdbcTemplate.query(sql, paramMap, new HistoryRowMapper());


        return result;

    }


    private class HistoryRowMapper implements RowMapper<History> {
        @Override
        public History mapRow(ResultSet resultSet, int i) throws SQLException {
            History history = new History();
            history.setFrom_acc(resultSet.getInt("from_acc"));
            history.setTo_acc(resultSet.getInt("to_acc"));
            history.setDate_tr(resultSet.getString("date_tr"));
            history.setName(resultSet.getString("first_name")+" " + resultSet.getString("last_name"));
            history.setTime_tr(resultSet.getString("time_tr"));
            history.setTransferType(resultSet.getString("transferType"));
            if(resultSet.getString("transferType").equals("transfer")){
                history.setSum_tr(resultSet.getBigDecimal("sum_tr").negate());
            }
            else{
                history.setSum_tr(resultSet.getBigDecimal("sum_tr"));

            }

            return history;
        }

    }
}
