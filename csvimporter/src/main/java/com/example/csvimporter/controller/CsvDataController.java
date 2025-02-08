package com.example.csvimporter.controller;

import com.example.csvimporter.model.CsvData;
import com.example.csvimporter.service.CsvDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/csvdata") // Bu /csvdata path'ini controller'a ekliyoruz
public class CsvDataController {

    @Autowired
    private CsvDataService csvDataService;

    // CSV dosyasını okuma ve veritabanına kaydetme API uç noktası
    @GetMapping("/import") // Burada "/import" endpoint'i tanımlıyoruz
    public String importCsvData() {
        try {
            csvDataService.saveCsvDataFromDownloads();  // CSV dosyasını okuma ve kaydetme işlemi
            return "CSV verileri başarıyla import edildi!";
        } catch (IOException e) {
            return "Bir hata oluştu: " + e.getMessage();
        }
    }

    // Veritabanındaki tüm verileri getiren API uç noktası
    @GetMapping("/all") // Bu da "/all" endpoint'idir
    public List<CsvData> getAllCsvData() {
        return csvDataService.getAllCsvData();  // Veritabanındaki veriler JSON formatında dönecek
    }
}