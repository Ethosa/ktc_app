package com.ethosa.ktc_app.callbacks;

import com.ethosa.ktc_app.APIInterface;
import com.ethosa.ktc_app.objects.Courses;

public class CoursesCallback implements APIInterface<Courses> {
    @Override
    public void onResult(Courses courses) {
        System.out.println(courses);
    }
}
