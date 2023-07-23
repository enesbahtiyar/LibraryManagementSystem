package com.eb.controller;

import com.eb.domain.Teacher;
import com.eb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.PushBuilder;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/teachers") //http://localhost:8080/teachers
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    @PostMapping //http://localhost:8080/teachers
    public ResponseEntity<Map<String, String>> saveTeacher(@Valid @RequestBody Teacher teacher)
    {
        teacherService.saveTeacher(teacher);

        Map<String, String> map = new HashMap<>();
        map.put("message", "teacher is successfully saved");
        map.put("success", "true");

        return new ResponseEntity<>(map, HttpStatus.CREATED); //201
    }

    @GetMapping //http://localhost:8080/teachers
    public ResponseEntity<List<Teacher>> getAllTeachers()
    {
        List<Teacher> teachers = teacherService.getAllTeachers();

        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable Long id)
    {
        Teacher teacher = teacherService.findTeacherById(id);

        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable Long id)
    {

        teacherService.deleteTeacherById(id);

        return new ResponseEntity<>("deleted teachers id: " + id, HttpStatus.OK);
    }
}
