package com.eb.service;

import com.eb.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TeacherService
{
    @Autowired
    private TeacherRepository repository;
}
