package online.aldomar.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScpApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

        @Test
        void contextLoads() {
        }

        @Test
        void testeEndpointReturnsOk() {
                ResponseEntity<String> response = restTemplate.getForEntity("/teste", String.class);
                assertEquals("OK", response.getBody());
        }

}
