package com.eb.repository;

import com.eb.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>
{
    Teacher findByEmail(String email);
}
