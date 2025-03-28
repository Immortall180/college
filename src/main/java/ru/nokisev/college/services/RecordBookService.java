package ru.nokisev.college.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nokisev.college.models.Faculty;
import ru.nokisev.college.models.Group;
import ru.nokisev.college.models.RecordBook;
import ru.nokisev.college.models.Student;
import ru.nokisev.college.repositories.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordBookService {
    private final FacultyRepository facultyRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final RecordBookRepository recordBookRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final SemesterRepository semesterRepository;
    public final CertificationRepository certificationRepository;

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAllByOrderBySpeciality();
    }

    public List<Group> getGroupsByFaculty(Long facultyId) {
        return groupRepository.findByFacultyIdOrderByGroupName(facultyId);
    }

    public List<Student> getStudentsByGroup(Long groupId) {
        return studentRepository.findByGroupIdOrderBySurname(groupId);
    }

    public List<RecordBook> getStudentRecords(Long studentId, Long groupId) {
        return recordBookRepository.findByStudentIdAndGroupIdOrderBySemesterNumber(studentId, groupId);
    }

    public List<RecordBook> getRecordsByStudentAndGroup(Long studentId, Long groupId) {
        return recordBookRepository.findByStudentIdAndGroupIdOrderBySemesterNumber(studentId, groupId);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    public void addRecord(Long teacherId, Long subjectId, Long studentId,
                          Long semesterId, Long groupId, Long certificationId,
                          String grade) {

        RecordBook record = new RecordBook();

        record.setTeacher(teacherRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found")));

        record.setSubject(subjectRepository.findById(subjectId)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found")));

        record.setStudent(studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found")));

        record.setSemester(semesterRepository.findById(semesterId)
                .orElseThrow(() -> new EntityNotFoundException("Semester not found")));

        record.setGroup(groupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("Group not found")));

        record.setCertification(certificationRepository.findById(certificationId)
                .orElseThrow(() -> new EntityNotFoundException("Certification not found")));

        record.setGrade(grade);

        recordBookRepository.save(record);
    }
}
