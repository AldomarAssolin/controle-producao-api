package online.aldomar.api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
  public static void main(String[] args) {
    var encoder = new BCryptPasswordEncoder();
    // Troque a string abaixo pela senha que quiser hashear
    String raw = "319Manex!";
    String hash = encoder.encode(raw);
    System.out.println("BCrypt hash: " + hash);
  }
}
