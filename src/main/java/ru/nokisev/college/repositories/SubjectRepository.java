package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nokisev.college.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
