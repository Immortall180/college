
-- Создание таблицы faculty
CREATE TABLE faculty (
    id BIGSERIAL PRIMARY KEY,
    speciality VARCHAR(255) NOT NULL,
    qualification VARCHAR(255) NOT NULL,
    speciality_code VARCHAR(20) NOT NULL
);

-- Создание таблицы semester
CREATE TABLE semester (
    id BIGSERIAL PRIMARY KEY,
    number INTEGER NOT NULL CHECK (number BETWEEN 1 AND 12)
);

-- Создание таблицы student_group (не group, т.к. это зарезервированное слово)
CREATE TABLE student_group (
    id BIGSERIAL PRIMARY KEY,
    group_name VARCHAR(20) NOT NULL,
    faculty_id BIGINT REFERENCES faculty(id)
);

-- Создание таблицы student
CREATE TABLE student (
    id BIGSERIAL PRIMARY KEY,
    surname VARCHAR(150) NOT NULL,
    firstname VARCHAR(150) NOT NULL,
    lastname VARCHAR(150),
    group_id BIGINT REFERENCES student_group(id)
);

-- Создание таблицы teacher
CREATE TABLE teacher (
    id BIGSERIAL PRIMARY KEY,
    surname VARCHAR(150) NOT NULL,
    firstname VARCHAR(150) NOT NULL,
    lastname VARCHAR(150)
);

-- Создание таблицы certification
CREATE TABLE certification (
    id BIGSERIAL PRIMARY KEY,
    certification_type VARCHAR(150) NOT NULL
);

-- Создание таблицы subject
CREATE TABLE subject (
    id BIGSERIAL PRIMARY KEY,
    index VARCHAR(20) NOT NULL,
    subject VARCHAR(400) NOT NULL,
    hours INTEGER NOT NULL,
    semester_id BIGINT REFERENCES semester(id),
    faculty_id BIGINT REFERENCES faculty(id)
);

-- Создание таблицы record_book
CREATE TABLE record_book (
    id BIGSERIAL PRIMARY KEY,
    grade VARCHAR(20) NOT NULL,
    id_certification BIGINT REFERENCES certification(id),
    id_group BIGINT REFERENCES student_group(id),
    id_semester BIGINT REFERENCES semester(id),
    id_student BIGINT REFERENCES student(id),
    id_subject BIGINT REFERENCES subject(id),
    id_teacher BIGINT REFERENCES teacher(id)
);

-- Создание индексов для улучшения производительности
CREATE INDEX idx_record_book_student ON record_book(id_student);
CREATE INDEX idx_record_book_subject ON record_book(id_subject);
CREATE INDEX idx_record_book_semester ON record_book(id_semester);
CREATE INDEX idx_student_group ON student(group_id);
CREATE INDEX idx_subject_faculty ON subject(faculty_id);