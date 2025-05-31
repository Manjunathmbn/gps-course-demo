package com.course.controller;

import com.course.model.Course;
import com.course.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }
}
