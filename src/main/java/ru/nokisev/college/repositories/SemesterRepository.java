package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nokisev.college.models.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
