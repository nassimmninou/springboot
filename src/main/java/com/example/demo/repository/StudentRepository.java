package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT YEAR(s.dateNaissance) AS year, COUNT(s) AS count FROM Student s GROUP BY YEAR(s.dateNaissance) ORDER BY year")
    List<Object[]> findNbrStudentByYear();

    Student findById(int id); // This method is not needed, as JpaRepository provides it.
}
