package com.example.csvimporter.repository;

import com.example.csvimporter.model.CsvData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvDataRepository extends JpaRepository<CsvData, Long> {

    List<CsvData> findByAge(int age);

    List<CsvData> findByEducation(String education);

    List<CsvData> findByDefaultStatus(String defaultStatus);

    List<CsvData> findAllByOrderByBalanceAsc();

    List<CsvData> findAllByOrderByBalanceDesc();

    List<CsvData> findByAgeGreaterThanOrderByAgeDesc(int age);

    void deleteByAge(int age);

    void deleteByDefaultStatus(String defaultStatus);

    List<CsvData> findByAgeAndEducation(int age, String education);
}