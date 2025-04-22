package no.fintlabs.fagproveOving.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.fintlabs.fagproveOving.Service.StudentService;
import no.fintlabs.fagproveOving.model.dto.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student, HttpServletRequest request) {
        if (studentService.exists(student.getId())) return new ResponseEntity<>(HttpStatus.CONFLICT);
        Student savedStudent = (Student) studentService.addStudent(student);
        URI location = URI.create(String.format("%s/%s", request.getRequestURL(), savedStudent.getId()));
        return ResponseEntity.created(location).body(savedStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable String id) {
        if (studentService.exists(id)) {
            return ResponseEntity.ok(Optional.ofNullable(studentService.getById(id)));
        } else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        if (studentService.exists(id)) {
            String result = studentService.deleteStudent(id);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
