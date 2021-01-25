package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class History {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private Integer id;
    private Integer from;
    private Integer to;
    private BigDecimal sum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

//    public void setHistory() {
//        BigDecimal sum = new BigDecimal(99);
//        String sql = "INSERT INTO history (from_acc, to_acc, sum_tr) VALUES(:from, :to, :sum)";
//
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("from", 1);
//        paramMap.put("to", 1);
//      paramMap.put("sum", sum);
//
//
//        jdbcTemplate.update(sql, paramMap);
//
//    }
}
