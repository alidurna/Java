package org.example.service;

import org.example.model.Todo;  // Todo sınıfını kullanmak için import edilir.
import org.example.repository.TodoRepository;  // TodoRepository sınıfını kullanmak için import edilir.

import java.util.List;  // List arayüzü kullanılır.

public class TodoService {

    // TodoRepository nesnesi, Todo öğeleri ile ilgili veri işlemlerini yapacak.
    private TodoRepository todoRepository;

    // Constructor (Yapıcı metod)
    // TodoRepository nesnesi dışarıdan parametre olarak alınır ve sınıfın todoRepository alanına atanır.
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;  // Bağımlılık enjeksiyonu ile repository atanır.
    }

    // Tüm Todo'ları getir
    // Bu metod, TodoRepository üzerinden tüm Todo öğelerini getirir.
    public List<Todo> getAllTodos() {
        return todoRepository.getAllTodos();  // Repository'nin getAllTodos metodunu çağırır.
    }

    // Yeni bir Todo ekle
    // Bu metod, parametre olarak gelen Todo öğesini repository'ye ekler.
    public void addTodo(Todo todo) {
        todoRepository.addTodo(todo);  // Repository'nin addTodo metodunu çağırır.
    }

    // ID'ye göre Todo getir
    // Bu metod, verilen ID'ye sahip Todo öğesini repository'den alır.
    public Todo getTodoById(int id) {
        return todoRepository.getTodoById(id);  // Repository'nin getTodoById metodunu çağırır.
    }

    // Todo'yu sil
    // Bu metod, verilen ID'ye sahip Todo öğesini repository'den siler.
    public void deleteTodoById(int id) {
        todoRepository.deleteTodoById(id);  // Repository'nin deleteTodoById metodunu çağırır.
    }

    // Todo'yu güncelle
    // Bu metod, verilen Todo öğesini repository'de günceller.
    public void updateTodo(Todo todo) {
        todoRepository.updateTodo(todo);  // Repository'nin updateTodo metodunu çağırır.
    }
}
