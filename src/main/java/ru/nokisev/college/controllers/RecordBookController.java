package ru.nokisev.college.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nokisev.college.models.Group;
import ru.nokisev.college.models.RecordBook;
import ru.nokisev.college.models.Semester;
import ru.nokisev.college.models.Student;
import ru.nokisev.college.services.RecordBookService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class RecordBookController {
    private final RecordBookService recordBookService;

    @GetMapping("/")
    public String showFaculties(Model model) {
        model.addAttribute("faculties", recordBookService.getAllFaculties());
        return "faculties";
    }

    @GetMapping("/groups")
    public String showGroups(@RequestParam Long facultyId, Model model) {
        model.addAttribute("groups", recordBookService.getGroupsByFaculty(facultyId));
        model.addAttribute("facultyId", facultyId);
        return "groups";
    }

    @GetMapping("/students")
    public String showStudents(@RequestParam Long groupId, Model model) {
        Optional<Group> group = recordBookService.getGroupById(groupId);
        if (group.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("students", recordBookService.getStudentsByGroup(groupId));
        model.addAttribute("group", group.get());
        return "students";
    }

    @GetMapping("/record-book")
    public String showRecordBook(@RequestParam Long studentId,
                                 @RequestParam Long groupId,
                                 Model model) {

        // Получаем студента
        Student student = recordBookService.getStudentById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        // Получаем и группируем записи
        Map<Integer, List<RecordBook>> recordsBySemester = recordBookService
                .getRecordsByStudentAndGroup(studentId, groupId)
                .stream()
                .collect(Collectors.groupingBy(
                        r -> r.getSemester().getNumber(),
                        TreeMap::new, // Сортируем по номеру семестра
                        Collectors.toList()
                ));

        model.addAttribute("student", student);
        model.addAttribute("recordsBySemester", recordsBySemester);

        return "record-book";
    }
}
