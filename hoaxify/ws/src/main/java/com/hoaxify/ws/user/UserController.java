package com.hoaxify.ws.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericMessage;

@RestController // Bu sınıfın bir Spring MVC Controller olduğunu belirtir.
public class UserController {

    @Autowired // UserService nesnesinin bağımlılık enjeksiyonu yoluyla sağlanmasını sağlar.
    UserService userService;
 
    @PostMapping("/api/v1/users")  // Bu metodu, /api/v1/users URL'sine POST isteği geldiğinde çalıştırır.
    ResponseEntity<?> createUser(@RequestBody User user){ // HTTP POST isteğinde gelen veriyi User objesine dönüştürür.
        ApiError apiError = new ApiError(); // API hatalarını temsil etmek için bir ApiError nesnesi oluşturur.
        apiError.setPath("/api/v1/users"); // Hata durumunda hangi yolda olduğumuzu belirler.
        apiError.setMessage("Validation error"); // Hata mesajını ayarlar.
        apiError.setStatus(400); // HTTP 400 Bad Request durumu ayarlanır.

        Map<String,String> validationErrors = new HashMap<>(); // Validasyon hatalarını saklamak için bir HashMap oluşturur.
        
        if(user.getUsername()==null || user.getUsername().isEmpty()){ // Kullanıcı adı boş veya null ise hata ekler.
            validationErrors.put("username","Username cannot be null");
        }

        if(user.getEmail() == null || user.getEmail().isEmpty()){ // E-posta boş veya null ise hata ekler.
            validationErrors.put("email","Email cannot be null");

        }

        if(validationErrors.size() > 0){ // Eğer validasyon hataları varsa:
            apiError.setValidationErrors(validationErrors); // ApiError nesnesine hataları ekler.
            return ResponseEntity.badRequest().body(apiError); // Hataları içeren 400 Bad Request yanıtı döner.
        }
        
        userService.save(user); // Validasyon hatası yoksa kullanıcıyı kaydeder.
        return ResponseEntity.ok(new GenericMessage("User is created")); // Başarılı işlem mesajı döner.
    }
}