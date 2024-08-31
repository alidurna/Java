package com.hoaxify.ws.user;

import java.lang.reflect.Method; // Java Reflection API'sinden Method sınıfını içe aktarır.
import java.util.stream.Collector;
import java.util.stream.Collectors; // Stream API'si için gerekli olan sınıfları içe aktarır.

import org.springframework.beans.factory.annotation.Autowired; // Spring'in bağımlılık enjeksiyonu için kullanılan anotasyonu.
import org.springframework.http.ResponseEntity; // HTTP yanıtlarını temsil eden sınıf.
import org.springframework.validation.FieldError; // Validasyon hatası durumunda alan hatalarını temsil eder.
import org.springframework.web.bind.MethodArgumentNotValidException; // Geçersiz metod argümanları için kullanılan istisna sınıfı.
import org.springframework.web.bind.annotation.ExceptionHandler; // Bir istisna oluştuğunda çağrılan metodları belirler.
import org.springframework.web.bind.annotation.PostMapping; // HTTP POST isteklerini işlemek için kullanılan anotasyon.
import org.springframework.web.bind.annotation.RequestBody; // HTTP istek gövdesini işlemek için kullanılan anotasyon.
import org.springframework.web.bind.annotation.ResponseBody; // Bir metodun dönüş değerinin HTTP yanıt gövdesine yazılacağını belirtir.
import org.springframework.web.bind.annotation.RestController; // Bu sınıfın bir RESTful web servisi kontrolcüsü olduğunu belirtir.
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.MethodArgumentBuilder; // URI oluşturma işlemlerinde kullanılan sınıf.

import com.hoaxify.ws.error.ApiError; // Özel hata sınıfı, API hatalarını temsil eder.
import com.hoaxify.ws.shared.GenericMessage; // Genel mesaj sınıfı, basit yanıt mesajları için kullanılır.

import jakarta.validation.Valid; // Veri validasyonu için kullanılan anotasyon.

@RestController // Bu sınıfın bir Spring MVC Controller olduğunu belirtir.
public class UserController {

    @Autowired // UserService nesnesinin bağımlılık enjeksiyonu yoluyla sağlanmasını sağlar.
    UserService userService; // Kullanıcı hizmetlerini gerçekleştiren sınıfın bir örneği.

    @PostMapping("/api/v1/users") // Bu metodu, /api/v1/users URL'sine POST isteği geldiğinde çalıştırır.
    GenericMessage createUser(@Valid @RequestBody User user){ 
        // @Valid: Gönderilen User objesinin validasyonunu sağlar.
        // @RequestBody: HTTP POST isteğinde gelen veriyi User objesine dönüştürür.

        userService.save(user); // Validasyon hatası yoksa kullanıcıyı kaydeder.
        return new GenericMessage("User is created"); // Kullanıcı başarılı bir şekilde oluşturulursa geri dönüş mesajı verir.
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // MethodArgumentNotValidException istisnasını yakalar.
    ResponseEntity<ApiError> handleMethodArgNotValidEx(MethodArgumentNotValidException exception){
        // MethodArgumentNotValidException oluştuğunda bu metot çalışır.
        ApiError apiError = new ApiError(); // Yeni bir API hata nesnesi oluşturur.
        apiError.setPath("/api/v1/users"); // Hata meydana gelen yolu belirtir.
        apiError.setMessage("Validation error"); // Hata mesajını belirtir.
        apiError.setStatus(400); // HTTP 400 Bad Request statüsünü ayarlar.

        // Tüm alan hatalarını toplayarak bir haritaya dönüştürür.
        var validationErrors = exception.getBindingResult().getFieldErrors().stream()
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        apiError.setValidationErrors(validationErrors); // Validasyon hatalarını API hata nesnesine ekler.
        
        // 400 Bad Request yanıtı ile birlikte API hatasını döner.
        return ResponseEntity.badRequest().body(apiError);
    }
}