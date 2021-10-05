package com.ethosa.ktc_app.objects;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Timetable {
    public List<Day> week;

    public static Timetable parse(Document doc) {
        Timetable result = new Timetable();
        result.week = new ArrayList<>();

        Elements days = doc.getElementsByTag("td");
        for (Element dayElement : days) {
            Day day = Day.parse(dayElement);
            result.week.add(day);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "week=" + week +
                '}';
    }
}
