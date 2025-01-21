//Temel try-catch Bloğu

public class ExceptionExample {
    public static void main(String[] args){
        try{
            int result = 10 / 0; //Sıfıra bölme hatası
        }catch (ArithmeticException e){
            System.out.println("Hata : Sıfıra bölme yapılmaz!");
        }
    }
}

//Hata: Sıfıra bölme yapılmaz!



public class FinallyExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Hata: Dizi sınırlarının dışına çıkıldı!");
        } finally {
            System.out.println("Bu blok her zaman çalışır.");
        }
    }
}

Hata: Dizi sınırlarının dışına çıkıldı!
Bu blok her zaman çalışır.



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThrowsExample {
    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }

    public static void readFile() throws FileNotFoundException {
        File file = new File("example.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}

Eğer dosya bulunmazsa, FileNotFoundException fırlatılır.

public class ThrowExample {
    public static void main(String[] args) {
        int age = 15;
        try {
            validateAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Yaş 18'den küçük olamaz!");
        }
    }
}