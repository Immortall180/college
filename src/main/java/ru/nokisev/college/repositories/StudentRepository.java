package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nokisev.college.models.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByGroupIdOrderBySurname(Long groupId);

    @Query("SELECT s FROM Student s JOIN s.group g WHERE g.groupName = :groupName")
    List<Student> findByGroupName(@Param("groupName") String groupName);
}
