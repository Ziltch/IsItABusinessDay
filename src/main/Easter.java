package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author Ole K. Olsen
 * 17.05.2017.
 */
public class Easter {

    /**
     *
     * @param year The year that the easter date is getting calculated from
     * @return The date of easter for that year
     */
    public LocalDateTime whenIsEaster(int year) {
        int Y = year;
        int a = Y % 19;
        int b = Y / 100;
        int c = Y % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int L = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * L) / 451;
        int month = (h + L - 7 * m + 114) / 31;
        int day = ((h + L - 7 * m + 114) % 31) + 1;

        LocalDate result = LocalDate.of(year, month, day);
        LocalDateTime easter = LocalDateTime.of(result, LocalTime.of(0,0));

        return easter;
    }
}