package com.eb.controller;

import com.eb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;
}