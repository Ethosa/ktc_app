package com.ethosa.ktc_app.objects;

import org.jsoup.nodes.Element;

public class Course {
    public String id;
    public String title;

    public static Course parse(Element elem) {
        Course course = new Course();
        course.id = elem.attr("group_id");
        course.title = elem.getElementsByTag("a").get(0).text();
        return course;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
