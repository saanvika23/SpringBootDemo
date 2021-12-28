package com.mindmajix.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmajix.demo.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long>{

}
