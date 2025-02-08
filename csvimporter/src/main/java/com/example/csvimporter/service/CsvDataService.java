package com.example.csvimporter.service;

import com.example.csvimporter.model.CsvData;
import com.example.csvimporter.repository.CsvDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvDataService {

    @Autowired
    private CsvDataRepository csvDataRepository;  // Doğru enjekte edilmelidir

    public void saveCsvDataFromDownloads() throws IOException {
        // CSV dosyasının dosya yolu
        String path = System.getProperty("user.home") + "/Downloads/BankCustomerData.csv";  // Dosya adını doğru yazdığınızdan emin olun

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        List<CsvData> csvDataList = new ArrayList<>(); // Verileri toplamak için liste

        boolean isFirstLine = true;

        // CSV dosyasındaki her satırı oku
        while ((line = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }

            String[] data = line.split(",");

            if (data.length != 10) {
                System.out.println("Eksik veya hatalı veri tespit edildi: " + line);
                continue;
            }

            try {
                CsvData csvData = new CsvData();
                csvData.setAge(Integer.parseInt(data[0]));
                csvData.setJob(data[1]);
                csvData.setMarital(data[2]);
                csvData.setEducation(data[3]);
                csvData.setDefaultStatus(data[4]);
                csvData.setBalance(Integer.parseInt(data[5]));
                csvData.setHousing(data[6]);
                csvData.setLoan(data[7]);
                csvData.setContact(data[8]);
                csvData.setDay(Integer.parseInt(data[9]));

                csvDataList.add(csvData);
            } catch (NumberFormatException e) {
                System.out.println("Veri dönüştürme hatası: " + e.getMessage());
            }
        }

        if (!csvDataList.isEmpty()) {
            csvDataRepository.saveAll(csvDataList);  // Veritabanına toplu kaydetme işlemi
        }

        br.close();
    }

    public List<CsvData> getAllCsvData() {
        return csvDataRepository.findAll();  // Veritabanındaki tüm verileri al
    }
}