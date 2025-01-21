// Paket tanımı, bu sınıfın dosya hiyerarşisinde nereye ait olduğunu belirtir.
package com.example.first_spring_boot_app.controller;

// Spring Web kütüphanesinden @GetMapping anotasyonunu içe aktarır. Bu, HTTP GET isteklerini eşleştirmek için kullanılır.
import org.springframework.web.bind.annotation.GetMapping;
// Spring Web kütüphanesinden @RestController anotasyonunu içe aktarır. Bu, bu sınıfın bir REST denetleyicisi olduğunu belirtir.
import org.springframework.web.bind.annotation.RestController;

// @RestController, bu sınıfın bir RESTful API denetleyicisi olduğunu belirtir.
// Bu anotasyon, sınıftaki metodların HTTP yanıtı döndürmek için kullanıldığını ifade eder.
@RestController
public class HelloController {

    // @GetMapping, bu metodun HTTP GET isteklerini işleyeceğini belirtir.
    // "/hello" endpoint'ine yapılan GET isteği bu metoda yönlendirilir.
    @GetMapping("/hello")
    public String sayHello() {
        // Bu metot, "/hello" endpoint'ine yapılan GET isteğine karşılık olarak
        // "Merhaba, Spring Boot!" metnini döndürür.
        return "Merhaba, Spring Boot!";
    }
}
