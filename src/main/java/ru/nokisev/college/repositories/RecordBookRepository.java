package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nokisev.college.models.RecordBook;

import java.util.List;

@Repository
public interface RecordBookRepository extends JpaRepository<RecordBook, Long> {
    List<RecordBook> findByStudentIdAndGroupIdOrderBySemesterNumber(Long studentId, Long groupId);
}
