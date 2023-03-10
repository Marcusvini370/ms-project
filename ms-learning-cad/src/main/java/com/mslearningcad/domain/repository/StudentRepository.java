package com.mslearningcad.domain.repository;

import com.mslearningcad.domain.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends MongoRepository<Student, UUID> {
    Optional<Student> findByStudentId(UUID studentId);

}