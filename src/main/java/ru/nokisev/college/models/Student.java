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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;
    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id") // ссылка на student_group
    private Group group;

    @OneToMany(mappedBy = "student")
    private List<RecordBook> records;
}
