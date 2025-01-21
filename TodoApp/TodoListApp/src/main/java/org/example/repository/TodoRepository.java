package org.example.repository;

import org.example.model.Todo;  // Todo sınıfını kullanmak için import edilir.
import java.util.ArrayList;  // List için ArrayList sınıfı kullanılır.
import java.util.List;  // List arayüzü kullanılır.

public class TodoRepository {

    // Todo nesnelerini saklayacak liste. Burada Todo'lar bir ArrayList içinde tutuluyor.
    private List<Todo> todos = new ArrayList<>();

    // Tüm Todo'ları getir
    // Bu metod, tüm Todo öğelerini liste olarak döndürür.
    public List<Todo> getAllTodos() {
        return todos;  // todos listesini döndürür.
    }

    // Yeni bir Todo ekle
    // Bu metod, parametre olarak verilen Todo nesnesini todos listesine ekler.
    public void addTodo(Todo todo) {
        todos.add(todo);  // verilen Todo öğesini listeye ekler.
    }

    // ID'ye göre bir Todo getir
    // Bu metod, ID'si verilen Todo öğesini döndürür. Eğer bulunamazsa null döner.
    public Todo getTodoById(int id) {
        // Java 8'deki stream API kullanılarak verilen id'ye sahip Todo öğesi aranır.
        return todos.stream()  // todos listesi üzerinde işlem yapılır.
                .filter(todo -> todo.getId() == id)  // id'yi eşleştirerek filtreleme yapılır.
                .findFirst()  // ilk bulunan öğe döndürülür.
                .orElse(null);  // Eğer hiçbir öğe bulunmazsa, null döndürülür.
    }

    // Bir Todo'yu sil
    // Bu metod, ID'si verilen Todo öğesini todos listesinden siler.
    public void deleteTodoById(int id) {
        // removeIf metodu, id'ye eşit olan Todo öğesini listeden kaldırır.
        todos.removeIf(todo -> todo.getId() == id);
    }

    // Bir Todo'yu güncelle
    // Bu metod, verilen güncellenmiş Todo öğesini todos listesinde bulur ve günceller.
    public void updateTodo(Todo updatedTodo) {
        // Todos listesinde iterasyon yaparak, id'ye göre eşleşen Todo öğesi bulunur.
        for (int i = 0; i < todos.size(); i++) {
            // Eğer verilen updatedTodo'nun id'si, mevcut öğenin id'si ile eşleşiyorsa
            if (todos.get(i).getId() == updatedTodo.getId()) {
                todos.set(i, updatedTodo);  // Güncellenmiş Todo öğesi, listede mevcut öğe ile değiştirilir.
                break;  // Güncelleme yapıldıktan sonra döngüden çıkılır.
            }
        }
    }
}
