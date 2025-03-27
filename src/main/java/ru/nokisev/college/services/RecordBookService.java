package ru.nokisev.college.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nokisev.college.models.Faculty;
import ru.nokisev.college.models.Group;
import ru.nokisev.college.models.RecordBook;
import ru.nokisev.college.models.Student;
import ru.nokisev.college.repositories.FacultyRepository;
import ru.nokisev.college.repositories.GroupRepository;
import ru.nokisev.college.repositories.RecordBookRepository;
import ru.nokisev.college.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordBookService {
    private final FacultyRepository facultyRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final RecordBookRepository recordBookRepository;

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
}
