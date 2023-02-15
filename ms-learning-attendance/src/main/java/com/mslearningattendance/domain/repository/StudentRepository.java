package com.mslearningattendance.domain.repository;

import com.mslearningattendance.domain.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {

    Optional<Student> findById(UUID studentId);
}