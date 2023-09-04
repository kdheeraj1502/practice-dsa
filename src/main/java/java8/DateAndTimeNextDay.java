package java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateAndTimeNextDay {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate nextWednesday = today.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(nextWednesday);
    }
}
