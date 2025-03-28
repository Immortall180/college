package ru.nokisev.college.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nokisev.college.models.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {

}
