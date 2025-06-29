package online.aldomar.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import static org.junit.jupiter.api.Assertions.*;
import online.aldomar.api.dto.AuthResponse;
import online.aldomar.api.dto.LoginRequest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
class ScpApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    private String token;

    @BeforeEach
    void authenticate() {
        // 1) efetua login para obter o JWT
        LoginRequest login = new LoginRequest("aldomar@online.com", "$2a$10$CgVZOrC.4eXT2rt8X7PNhu4YDAJ/6pQ4R5LZbnUTsNKfhGvZYIWIu");
        ResponseEntity<AuthResponse> authResponse =
            restTemplate.postForEntity("/api/auth/login", login, AuthResponse.class);

        assertEquals(HttpStatus.OK, authResponse.getStatusCode());
        assertNotNull(authResponse.getBody());
        token = authResponse.getBody().getToken();
        assertNotNull(token, "JWT deve vir não-nulo");
    }

    @Test
    void getRootShouldReturnWelcomeMessage() {
        // 2) prepara headers com o Bearer token
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);              // seta "Authorization: Bearer <token>"
        HttpEntity<Void> request = new HttpEntity<>(headers);

        // 3) chama o endpoint protegido passando os headers
        ResponseEntity<String> response = restTemplate.exchange(
            "/", HttpMethod.GET, request, String.class);

        assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
            () -> assertEquals("Welcome to the Scp API", response.getBody())
        );
    }

    @Test
    void getTesteShouldReturnOk() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
            "/teste", HttpMethod.GET, request, String.class);

        assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
            () -> assertEquals("OK", response.getBody())
        );
    }
}

