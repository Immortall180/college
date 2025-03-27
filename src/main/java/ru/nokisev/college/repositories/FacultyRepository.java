package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nokisev.college.models.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByOrderBySpeciality();
}
