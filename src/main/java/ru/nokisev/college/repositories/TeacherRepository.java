package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nokisev.college.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
