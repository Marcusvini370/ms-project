package com.mslearningattendance.domain.repository;

import com.mslearningattendance.domain.model.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AttendanceRepository extends CrudRepository<Attendance, UUID> {
}