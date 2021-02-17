package ee.bcs.valiit.tasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.bcs.valiit.tasks.dto.Customer;
import ee.bcs.valiit.tasks.dto.Withdraw;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)


@AutoConfigureMockMvc
public class SpringTest {

    @Autowired
    private MockMvc mockMvc;
    private Object EmptyResultDataAccessException;

//    @Test
//
//    void getBalance() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        Balance balance = new Balance(1);
//        balance.setAccount(1);
//
//        http://localhost:8081/bank/balance
//        mockMvc.perform(MockMvcRequestBuilders.get("/bank/balance")
//                .contentType("application/json")
//                .content(mapper.writeValueAsString(balance))).andExpect(MockMvcResultMatchers.content().string("165"));
//
//    }

    @Test
void testCreateCustomer() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setFirstName("Juri");
        customer.setLastname("Ustimenko");
        customer.setId(null);
    http://localhost:8081/bank/createcustomer
        mockMvc.perform(MockMvcRequestBuilders.post("/bank/createcustomer")
                .contentType("application/json")
                .content(mapper.writeValueAsString(customer))).andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Customer exists\"}"));

    }

    @Test

    void testWithdraw() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Withdraw withdraw = new Withdraw(2222,BigDecimal.valueOf(2));

        http://localhost:8081/bank/withdraw
        mockMvc.perform(MockMvcRequestBuilders.put("/bank/withdraw")
                .contentType("application/json")
                .content(mapper.writeValueAsString(withdraw))).andExpect(MockMvcResultMatchers.status().isInternalServerError());


    }



}
