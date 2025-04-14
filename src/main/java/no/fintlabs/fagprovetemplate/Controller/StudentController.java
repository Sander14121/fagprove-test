package no.fintlabs.fagprovetemplate.Controller;

import no.fintlabs.fagprovetemplate.Service.StudentService;
import no.fintlabs.fagprovetemplate.model.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

}
