package com.mslearningattendance.domain.repository;

import com.mslearningattendance.domain.model.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, UUID> {

    List<Attendance> findAllByStudentId(UUID studentId);
}
