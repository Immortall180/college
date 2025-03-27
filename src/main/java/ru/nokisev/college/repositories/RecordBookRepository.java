package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nokisev.college.models.RecordBook;

import java.util.List;

public interface RecordBookRepository extends JpaRepository<RecordBook, Long> {
    List<RecordBook> findByStudentIdAndGroupIdOrderBySemesterNumber(Long studentId, Long groupId);
}
