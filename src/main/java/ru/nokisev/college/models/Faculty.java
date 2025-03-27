package ru.nokisev.college.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String speciality;
    private String qualification;
    private String specialityCode;

    @OneToMany(mappedBy = "faculty")
    private List<Group> groups;

    @OneToMany(mappedBy = "faculty")
    private List<Subject> subjects;
}
