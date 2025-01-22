package com.example.database_application.service;  // Paket deklarasyonu, uygulamanın hizmet katmanında olduğunu belirtir

import com.example.database_application.User;  // User sınıfını içe aktarır (kullanıcı objesi)
import com.example.database_application.UserRepository;  // Veritabanı işlemleri için UserRepository'yi içe aktarır
import org.springframework.beans.factory.annotation.Autowired;  // Spring'in bağımlılıkları otomatik olarak enjekte etmesini sağlar
import org.springframework.stereotype.Service;  // Bu sınıfın bir servis olduğunu belirtir (Spring'e bu sınıfın işlevi hakkında bilgi verir)

import java.util.List;  // List koleksiyonu kullanabilmek için içe aktarılır (kullanıcıları listelemek için)

@Service  // Spring'e bu sınıfın bir servis olduğunu ve iş mantığını barındırdığını belirtir
public class UserService {

    private final UserRepository userRepository;  // UserRepository nesnesi, veritabanı işlemleri için kullanılan arayüz

    // Constructor enjekte edilerek, UserRepository sınıfı UserService'e aktarılır
    @Autowired  // Spring'in bu sınıfı oluştururken UserRepository'yi otomatik olarak enjekte etmesini sağlar
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;  // Enjekte edilen UserRepository nesnesi sınıfın üye değişkenine atanır
    }

    // Tüm kullanıcıları veritabanından getiren metod
    public List<User> getAllUsers() {
        // userRepository üzerinden findAll metodunu çağırarak, veritabanındaki tüm kullanıcıları alır
        return userRepository.findAll();  // Kullanıcılar listesi döndürülür
    }

    // Yeni bir kullanıcıyı veritabanına kaydeden metod
    public User saveUser(User user) {
        // userRepository'nin save metoduyla, gelen kullanıcıyı veritabanına kaydeder
        return userRepository.save(user);  // Kaydedilen kullanıcıyı geri döndürür
    }
}
