package org.example.controller;

import org.example.model.Todo;  // Todo sınıfını kullanmak için import edilir.
import org.example.repository.TodoRepository;  // TodoRepository sınıfını kullanmak için import edilir.
import org.example.service.TodoService;  // TodoService sınıfını kullanmak için import edilir.

import java.util.Scanner;  // Kullanıcıdan giriş almak için Scanner sınıfı kullanılır.

public class TodoListApp {
    public static void main(String[] args) {
        // TodoRepository nesnesi oluşturuluyor, bu nesne veritabanı işlemlerini yönetir.
        TodoRepository todoRepository = new TodoRepository();

        // TodoService nesnesi oluşturuluyor ve TodoRepository ile bağlanıyor.
        TodoService todoService = new TodoService(todoRepository);

        // Kullanıcıdan giriş almak için Scanner nesnesi oluşturuluyor.
        Scanner scanner = new Scanner(System.in);

        // Ana uygulama döngüsü (sürekli olarak kullanıcıdan seçim alınır)
        while (true) {
            // Ana menü ekranı yazdırılır.
            System.out.println("\n--- Todo List Uygulaması ---");
            System.out.println("1. Tüm Todo'ları Görüntüle");
            System.out.println("2. Yeni Todo Ekle");
            System.out.println("3. Todo'yu Güncelle");
            System.out.println("4. Todo'yu Sil");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminiz: ");

            // Kullanıcıdan seçim alınır.
            int choice = scanner.nextInt();
            scanner.nextLine(); // Satır sonu karakteri temizlenir (scanner.nextInt() sonrasında satır sonu karakteri kalır).

            // Kullanıcının seçimine göre işlem yapılır.
            switch (choice) {
                // Tüm Todo'ları listeleme
                case 1:
                    // TodoService üzerinden tüm Todo'lar alınır ve yazdırılır.
                    todoService.getAllTodos().forEach(System.out::println);
                    break;

                // Yeni Todo ekleme
                case 2:
                    // Kullanıcıdan başlık ve açıklama bilgileri alınır.
                    System.out.print("Başlık: ");
                    String title = scanner.nextLine();
                    System.out.print("Açıklama: ");
                    String description = scanner.nextLine();

                    // Yeni bir Todo nesnesi oluşturulur (id, başlık, açıklama, başlangıçta tamamlanmamış).
                    Todo newTodo = new Todo(todoService.getAllTodos().size() + 1, title, description, false);

                    // TodoService'e eklenmesi için yeni Todo nesnesi iletilir.
                    todoService.addTodo(newTodo);
                    System.out.println("Todo eklendi!");
                    break;

                // Todo güncelleme
                case 3:
                    // Kullanıcıdan güncellemek istediği Todo'nun ID'si alınır.
                    System.out.print("Güncellemek istediğiniz Todo ID'si: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Satır sonu temizlenir

                    // TodoService üzerinden ID'ye göre Todo bulunur.
                    Todo existingTodo = todoService.getTodoById(updateId);

                    // Eğer Todo bulunursa, başlık ve açıklama güncellenir.
                    if (existingTodo != null) {
                        System.out.print("Yeni Başlık: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Yeni Açıklama: ");
                        String newDescription = scanner.nextLine();

                        // Güncellenmiş veriler, mevcut Todo nesnesine set edilir.
                        existingTodo.setTitle(newTitle);
                        existingTodo.setDescription(newDescription);

                        // Güncellenmiş Todo nesnesi, TodoService'e iletilir ve güncellenir.
                        todoService.updateTodo(existingTodo);
                        System.out.println("Todo güncellendi!");
                    } else {
                        System.out.println("Todo bulunamadı.");
                    }
                    break;

                // Todo silme
                case 4:
                    // Kullanıcıdan silmek istediği Todo'nun ID'si alınır.
                    System.out.print("Silmek istediğiniz Todo ID'si: ");
                    int deleteId = scanner.nextInt();

                    // TodoService üzerinden Todo, ID'sine göre silinir.
                    todoService.deleteTodoById(deleteId);
                    System.out.println("Todo silindi!");
                    break;

                // Çıkış
                case 5:
                    System.out.println("Çıkış yapılıyor...");
                    return;  // Program sonlandırılır.

                // Geçersiz seçim yapılırsa
                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}
