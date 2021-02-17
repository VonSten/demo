package ee.bcs.valiit.tasks;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class coopTest {


    public static void main(String[] args) throws HttpClientErrorException {
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36";


        RestTemplate template = new RestTemplate();
        String url = "https://api.ecoop.ee/supermarket/products?&category=93&page=1&language=et";

        CoopResponse response = template.getForObject(url, CoopResponse.class);

        for (CoopResponse.CoopProduct data : response.getData()) {
            System.out.println(data.getName());
        }

    }


}


