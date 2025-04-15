package no.fintlabs.fagprovetemplate.Service;

import no.fintlabs.fagprovetemplate.Repository.StudentRepository;
import no.fintlabs.fagprovetemplate.model.dto.Student;
import no.fintlabs.fagprovetemplate.model.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final MappingService mapper;
    private final StudentRepository studentRepository;

    public StudentService(MappingService mapper, StudentRepository studentRepository) {
        this.mapper = mapper;
        this.studentRepository = studentRepository;
    }

    public String addStudent(Student student) {
        StudentEntity studentEntity = mapper.mapStudent(student);
        studentRepository.save(studentEntity);
        return "Saved student with id " + studentEntity.getId();
    }

    public List<Student> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(entity -> mapper.mapToStudentDto(entity)).collect(Collectors.toList());
    }
}
