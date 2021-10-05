package com.ethosa.ktc_app.objects;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Day {
    public String day;
    public List<Lesson> lessons;

    public static Day parse(Element dayElement) {
        Day result = new Day();
        result.lessons = new ArrayList<>();
        result.day = dayElement.getElementsByClass("dayHeader")
                .get(0).getElementsByTag("span").get(0).text();

        Elements lessons = dayElement.getElementsByClass("lessonBlock");
        for (Element lessonElement : lessons) {
            Lesson lesson = Lesson.parse(lessonElement);
            result.lessons.add(lesson);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Day{" +
                "day='" + day + '\'' +
                ", lessons=" + lessons +
                '}';
    }
}
