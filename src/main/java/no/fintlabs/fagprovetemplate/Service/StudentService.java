package no.fintlabs.fagprovetemplate.Service;

import lombok.extern.slf4j.Slf4j;
import no.fintlabs.fagprovetemplate.Repository.StudentRepository;
import no.fintlabs.fagprovetemplate.model.dto.Student;
import no.fintlabs.fagprovetemplate.model.entity.StudentEntity;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentService {

    private final MappingService mapper;
    private final StudentRepository studentRepository;

    public StudentService(MappingService mapper, StudentRepository studentRepository) {
        this.mapper = mapper;
        this.studentRepository = studentRepository;
    }

    public String addStudent(Student student) {
        try {
            StudentEntity studentEntity = mapper.mapStudent(student);
            studentRepository.save(studentEntity);
            return "Saved student with id " + studentEntity.getId();
        } catch (Exception e) {
            return "Error saving student with id " + student.getId() + " with cause " + e.getMessage();
        }
    }

    public List<Student> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(entity -> mapper.mapToStudentDto(entity)).collect(Collectors.toList());
    }

    public Student getById(String id) {
        if (exists(id)) {
            StudentEntity byId = studentRepository.getById(Long.parseLong(id));
            return mapper.mapToStudentDto(byId);
        } else {
            throw new RuntimeException("Student with id " + id + " not found");

        }
    }

    public String deleteStudent(String id) {
        studentRepository.deleteById(Long.parseLong(id));
        return "Deleted student with id " + id;
    }


    private boolean exists(String id) {
        return studentRepository.existsById(Long.parseLong(id));
    }
}
