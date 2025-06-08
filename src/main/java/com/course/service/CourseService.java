package com.course.service;

import com.course.model.Course;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CourseService {
    private final Map<String, Course> courseMap = new ConcurrentHashMap<>();

    public Course createCourse(Course course) {
        courseMap.put(course.getId(), course);
        return course;
    }

    public Course getCourse(String id) {
        return courseMap.get(id);
    }
    
    public static String generateUrnWithPrefix(String prefix) {
        return prefix + UUID.randomUUID().toString();
    }
}
