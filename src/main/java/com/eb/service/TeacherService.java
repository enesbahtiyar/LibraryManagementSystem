package com.eb.service;

import com.eb.domain.Teacher;
import com.eb.exception.ConflictException;
import com.eb.exception.ResourceNotFoundException;
import com.eb.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService
{
    @Autowired
    private TeacherRepository repository;

    public Teacher saveTeacher(Teacher teacher)
    {
        Teacher existTeacher = repository.findByEmail(teacher.getEmail());

        if(existTeacher != null)
        {
            throw new ConflictException("Teacher with the same email already exists");
        }
        return repository.save(teacher);
    }

    public List<Teacher> getAllTeachers()
    {
        List<Teacher> teachers = repository.findAll();

        if(teachers.isEmpty())
        {
            throw new ResourceNotFoundException("teacher list is empty");
        }

        return teachers;
    }

    public Teacher findTeacherById(Long id)
    {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("the teacher couldn't find with the given id"));
    }

    public void deleteTeacherById(Long id)
    {
        Teacher teacher = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("this id does not exist"));

        repository.delete(teacher);
    }
}
