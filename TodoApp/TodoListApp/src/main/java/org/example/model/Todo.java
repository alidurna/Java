package org.example.model;
// Todo sınıfı, bir yapılacak iş (todo) öğesini temsil eder.
public class Todo {

    // Todo öğesinin benzersiz kimliği
    private int id;

    // Todo öğesinin başlığı (kısa açıklama)
    private String title;

    // Todo öğesinin daha detaylı açıklaması
    private String description;

    // Todo öğesinin tamamlanıp tamamlanmadığını belirtir
    private boolean isCompleted;

    // Constructor (Yapıcı metod)
    // Bu metod, yeni bir Todo nesnesi oluştururken gerekli tüm değerleri başlatır.
    public Todo(int id, String title, String description, boolean isCompleted) {
        this.id = id;  // id parametresi, sınıfın id alanına atanır.
        this.title = title;  // title parametresi, sınıfın title alanına atanır.
        this.description = description;  // description parametresi, sınıfın description alanına atanır.
        this.isCompleted = isCompleted;  // isCompleted parametresi, sınıfın isCompleted alanına atanır.
    }

    // id alanı için getter metodu
    // Todo öğesinin id'sini döndürür.
    public int getId() {
        return id;
    }

    // id alanı için setter metodu
    // Todo öğesinin id'sini dışarıdan değiştirmek için kullanılır.
    public void setId(int id) {
        this.id = id;
    }

    // title alanı için getter metodu
    // Todo öğesinin başlığını döndürür.
    public String getTitle() {
        return title;
    }

    // title alanı için setter metodu
    // Todo öğesinin başlığını dışarıdan değiştirmek için kullanılır.
    public void setTitle(String title) {
        this.title = title;
    }

    // description alanı için getter metodu
    // Todo öğesinin açıklamasını döndürür.
    public String getDescription() {
        return description;
    }

    // description alanı için setter metodu
    // Todo öğesinin açıklamasını dışarıdan değiştirmek için kullanılır.
    public void setDescription(String description) {
        this.description = description;
    }

    // isCompleted alanı için getter metodu
    // Todo öğesinin tamamlanıp tamamlanmadığını döndürür.
    public boolean isCompleted() {
        return isCompleted;
    }

    // isCompleted alanı için setter metodu
    // Todo öğesinin tamamlanma durumunu dışarıdan değiştirmek için kullanılır.
    public void setCompleted(boolean completed) {
        isCompleted = completed;  // Bu setter, "isCompleted" alanını günceller.
    }

    // toString metodunun override edilmesi
    // Todo nesnesinin metin temsili döndürülür. Nesnenin tüm alanlarını gösteren bir string oluşturur.
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +  // id alanının değeri
                ", title='" + title + '\'' +  // title alanının değeri
                ", description='" + description + '\'' +  // description alanının değeri
                ", isCompleted=" + isCompleted +  // isCompleted alanının değeri
                '}';  // string temsili bitirir
    }
}