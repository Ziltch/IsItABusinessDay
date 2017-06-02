package test;

import main.ItIsABusinessDay;
import main.TypeOfDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Ole K. Olsen
 * 17.05.2017.
 */
class isABusinessDayTest {
    private ItIsABusinessDay itIsABusinessDayInNorway = null;

    @BeforeEach
    void setUp() {
        itIsABusinessDayInNorway = new ItIsABusinessDay();

    }

    @Test
    void isSaturdayAndSundayWorkDays() {
        LocalDateTime currentDay = LocalDateTime.now();

        ArrayList<DayOfWeek> notWorkingDaysInWeek = new ArrayList<>();
        notWorkingDaysInWeek.add(DayOfWeek.SATURDAY);
        notWorkingDaysInWeek.add(DayOfWeek.SUNDAY);


        LocalDateTime testDate = currentDay.withMonth(1).withYear(2017);

        //Monday
        assertEquals(TypeOfDay.BUSINESSDAY, itIsABusinessDayInNorway.itIsABusinessDay(testDate.withDayOfMonth(2), notWorkingDaysInWeek));

        //Tuesday
        assertEquals(TypeOfDay.BUSINESSDAY, itIsABusinessDayInNorway.itIsABusinessDay(testDate.withDayOfMonth(3), notWorkingDaysInWeek));

        //Wednesday
        assertEquals(TypeOfDay.BUSINESSDAY, itIsABusinessDayInNorway.itIsABusinessDay(testDate.withDayOfMonth(4), notWorkingDaysInWeek));

        //Thursday
        assertEquals(TypeOfDay.BUSINESSDAY, itIsABusinessDayInNorway.itIsABusinessDay(testDate.withDayOfMonth(5), notWorkingDaysInWeek));

        //Friday
        assertEquals(TypeOfDay.BUSINESSDAY, itIsABusinessDayInNorway.itIsABusinessDay(testDate.withDayOfMonth(6), notWorkingDaysInWeek));

        //Saturday
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(testDate.withDayOfMonth(7), notWorkingDaysInWeek));

        //Sunday
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(testDate.withDayOfMonth(8), notWorkingDaysInWeek));
    }

    @Test
    void is17thOfMayAHoliday() {
        LocalDateTime currentDay = LocalDateTime.now();

        //17th of May
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentDay.withMonth(5).withDayOfMonth(17), Collections.emptyList()));
    }

    @Test
    void testAllDaysOfJanuary() {
        LocalDateTime currentTime = LocalDateTime.now();
        int daysInJan = 31;
        for (int i = 0; i < daysInJan; i++) {
            LocalDateTime testDate = currentTime.withMonth(1).withDayOfMonth(i + 1);

            Month month = testDate.getMonth();
            DayOfWeek dayOfWeek = testDate.getDayOfWeek();

            if (testDate.getDayOfMonth() == 1) {
                System.out.println(month + " " + dayOfWeek + " " + testDate.getDayOfMonth() + " " + "Fridag");
                assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(testDate, Collections.emptyList()));
            } else {
                System.out.println(month + " " + dayOfWeek + " " + testDate.getDayOfMonth() + " " + "Arbeidsdag");
                assertEquals(TypeOfDay.BUSINESSDAY, itIsABusinessDayInNorway.itIsABusinessDay(testDate, Collections.emptyList()));
            }

        }
    }

    @Test
    void testAllDaysOfFebruary() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate localDate = currentTime.toLocalDate();
        int daysInFeb = 0;
        daysInFeb = localDate.isLeapYear() ? 29 : 28;
        for (int i = 0; i < daysInFeb; i++) {
            LocalDateTime testDate = currentTime.withYear(2017).withMonth(2).withDayOfMonth(i + 1);

            Month month = testDate.getMonth();
            DayOfWeek dayOfWeek = testDate.getDayOfWeek();

            assertEquals(TypeOfDay.BUSINESSDAY, itIsABusinessDayInNorway.itIsABusinessDay(testDate, Collections.emptyList()));
            System.out.println(month + " " + dayOfWeek + " " + testDate.getDayOfMonth() + " " + "Arbeidsdag");
        }
    }

    @Test
    void testAllDaysOfFebruaryInLeapYear() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate localDate = currentTime.withYear(2016).toLocalDate();

        ArrayList<DayOfWeek> notWorkingDaysInWeek = new ArrayList<>();
        notWorkingDaysInWeek.add(DayOfWeek.SUNDAY);

        int daysInFeb;
        daysInFeb = localDate.isLeapYear() ? 29 : 28;
        for (int i = 0; i < daysInFeb; i++) {
            LocalDateTime testDate = currentTime.withYear(2016).withMonth(2).withDayOfMonth(i + 1);

            Month month = testDate.getMonth();
            DayOfWeek dayOfWeek = testDate.getDayOfWeek();

            if (testDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                System.out.println(month + " " + dayOfWeek + " " + testDate.getDayOfMonth() + " " + "Fridag");
                assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(testDate, notWorkingDaysInWeek));
            } else {
                System.out.println(month + " " + dayOfWeek + " " + testDate.getDayOfMonth() + " " + "Arbeidsdag");
                assertEquals(TypeOfDay.BUSINESSDAY, itIsABusinessDayInNorway.itIsABusinessDay(testDate, notWorkingDaysInWeek));
            }
        }
    }

    @Test
    void is15thOfAprilASqueezedDay() {
        LocalDateTime currentTime = LocalDateTime.now();

        //15th of April 2017 (Squeezed in day)
        assertEquals(TypeOfDay.SQUEEZEDINDAY, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(4).withDayOfMonth(15), Collections.emptyList()));
    }

    @Test
    void testAllEasterHolidaysFor2017(){
        LocalDateTime currentTime = LocalDateTime.now();

        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(4).withDayOfMonth(9), Collections.emptyList()));
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(4).withDayOfMonth(13), Collections.emptyList()));
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(4).withDayOfMonth(14), Collections.emptyList()));
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(4).withDayOfMonth(16), Collections.emptyList()));
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(4).withDayOfMonth(17), Collections.emptyList()));
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(5).withDayOfMonth(25), Collections.emptyList()));
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(6).withDayOfMonth(4), Collections.emptyList()));
        assertEquals(TypeOfDay.DAYOFF, itIsABusinessDayInNorway.itIsABusinessDay(currentTime.withMonth(6).withDayOfMonth(5), Collections.emptyList()));
    }
}