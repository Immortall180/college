package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nokisev.college.models.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByFacultyIdOrderByGroupName(Long facultyId);
}
