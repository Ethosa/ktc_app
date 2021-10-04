package com.ethosa.ktc_app.objects;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    public List<List<Course>> data;

    public static Courses parse(Document doc) {
        Courses result = new Courses();
        result.data = new ArrayList<>();
        Elements courses_blocks = doc.
                getElementsByClass("spec-year-block-container").get(9).
                getElementsByClass("spec-year-block");

        for (Element block : courses_blocks) {
            Elements courses = block.getElementsByClass("group-block gray-gradient");
            result.data.add(new ArrayList<>());
            for (Element elem : courses) {
                Course course = Course.parse(elem);
                result.data.get(result.data.size()-1).add(course);
            }
        }
        return result;
    }

    public Course findById(String id) {
        for (List<Course> year : data) {
            for (Course course : year) {
                if (course.id.equals(id)) {
                    return course;
                }
            }
        }
        return null;
    }

    public Course findByTitle(String title) {
        for (List<Course> year : data) {
            for (Course course : year) {
                if (course.title.equals(title)) {
                    return course;
                }
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
