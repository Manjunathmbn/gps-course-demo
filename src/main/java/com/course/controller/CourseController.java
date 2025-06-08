package com.course.controller;

import com.course.model.Course;
import com.course.model.Audit;
import com.course.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = { "newcourse/{organizationId}/{productModelRegionId}" })
    public Course createCourse(
    		@PathVariable String organizationId,
    		@PathVariable String productModelRegionId,
    		@RequestBody Course course) {

    	course.setId(CourseService.generateUrnWithPrefix("urn:pearson:gps:course:"));
    	
    	course.setOrganizationId(organizationId);
    	course.setProductModelRegionId(productModelRegionId);
		
    	Audit audit = new Audit();
    	audit.setDateCreated(java.time.LocalDateTime.now().toString());
    	audit.setCreatedBy("b9a6170b462a49a4b5d8023b0aa0a637"); 
    	audit.setDateModified(java.time.LocalDateTime.now().toString());
    	audit.setModifiedBy("b9a6170b462a49a4b5d8023b0aa0a637");
    	
    	course.setAudit(audit);
		
    	System.out.println("Creating course: " + course);
    	
    	
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }
}
