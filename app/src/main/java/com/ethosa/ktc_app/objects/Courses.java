package com.ethosa.ktc_app.objects;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    public List<Course> data;

    public static Courses parse(Document doc) {
        Courses result = new Courses();
        result.data = new ArrayList<>();
        Elements spans = doc.getElementsByClass("group-block");

        for (Element elem : spans) {
            Course course = Course.parse(elem);
            result.data.add(course);
        }
        return result;
    }

    public Course findById(String id) {
        for (Course course : data) {
            if (course.id.equals(id)) {
                return course;
            }
        }
        return null;
    }

    public Course findByTitle(String title) {
        for (Course course : data) {
            if (course.title.equals(title)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "data=" + data +
                '}';
    }
}
