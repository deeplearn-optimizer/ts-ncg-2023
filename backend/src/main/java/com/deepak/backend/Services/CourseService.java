package com.deepak.backend.Services;

import com.deepak.backend.Beans.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private final List<Course> courses = new ArrayList<>(List.of(new Course[]{new Course(1, "deepak", " deepak course")}));
    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourseById(String courseId) {
        return courses.stream().
                filter((course) -> course.getId() == Long.parseLong(courseId))
                .findAny()
                .orElse(null);
    }
}
