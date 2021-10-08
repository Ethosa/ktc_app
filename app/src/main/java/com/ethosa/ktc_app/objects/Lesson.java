package com.ethosa.ktc_app.objects;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Lesson {
    public String title;
    public String teacher;
    public String from;
    public String to;
    public String lessonNumber;
    public String classroom;
    public String weekDayHeader;
    public int weekDay;

    public static Lesson parse(Element lessonElement) {
        Lesson result = new Lesson();

        Elements time = lessonElement.getElementsByClass("lessonTimeBlock").get(0).children();
        result.lessonNumber = time.get(0).text();
        result.from = time.get(1).text();
        result.to = time.get(2).text();
        result.weekDay = 0;
        result.weekDayHeader = "";
        result.title = "";
        result.teacher = "";
        result.classroom = "";

        Elements lessons_blocks = lessonElement.getElementsByClass("discBlock");
        Element lesson_info = lessons_blocks.get(lessons_blocks.size()-1);
        if (lesson_info.attr("class").contains("cancelled")) {
            return result;
        }

        Elements spans = lesson_info.getElementsByTag("span");
        if (spans.size() > 0) {
            result.title = spans.get(0).text();
            result.teacher = spans.get(1).text();
            result.classroom = spans.get(2).text();
        }

        return result;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", lessonNumber='" + lessonNumber + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
