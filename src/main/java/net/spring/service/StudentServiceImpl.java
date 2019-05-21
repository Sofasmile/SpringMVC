package net.spring.service;

import lombok.RequiredArgsConstructor;
import net.spring.entity.Student;
import net.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        repository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
