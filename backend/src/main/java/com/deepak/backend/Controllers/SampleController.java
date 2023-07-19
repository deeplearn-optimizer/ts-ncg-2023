package com.deepak.backend.Controllers;

import com.deepak.backend.Beans.Course;
import com.deepak.backend.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SampleController {

    private final CourseService service;
    @Autowired
    public SampleController(CourseService service) {
        this.service = service;
    }
    @GetMapping("/home")
    public String home() {
        return "This is a home page!";
    }


    @GetMapping("/courses")
    @ResponseBody
    public List<Course> getCourses() {
        return service.getCourses();
    }


    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId){
        return service.getCourseById(courseId);
    }


    @PostMapping(path = "/courses/add",consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
