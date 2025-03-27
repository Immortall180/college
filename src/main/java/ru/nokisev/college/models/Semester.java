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
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @OneToMany(mappedBy = "semester")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "semester")
    private List<RecordBook> records;
}
