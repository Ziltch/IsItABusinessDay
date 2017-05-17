package test;

import main.Easter;
import main.ItIsABusinessDayInNorway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Ole K. Olsen
 * 17.05.2017.
 */
class isABusinessDayTest {
    private ItIsABusinessDayInNorway itIsABusinessDayInNorway = null;

    @BeforeEach
    void setUp() {
        itIsABusinessDayInNorway = new ItIsABusinessDayInNorway();

    }

    @Test
    void isSaturdayAndSundayWorkDays() {
        Calendar thisDayIn = Calendar.getInstance();
        ArrayList<Integer> notWorkingDaysInWeekIn = new ArrayList<Integer>();
        notWorkingDaysInWeekIn.add(Calendar.SATURDAY);
        notWorkingDaysInWeekIn.add(Calendar.SUNDAY);


        thisDayIn.set(Calendar.YEAR, 2017);
        thisDayIn.set(Calendar.MONTH, 1);

        thisDayIn.set(Calendar.DAY_OF_MONTH, 5);//Sunday
        assertFalse(itIsABusinessDayInNorway.itIsABusinessDay(thisDayIn, notWorkingDaysInWeekIn));

        thisDayIn.set(Calendar.DAY_OF_MONTH, 6);//Monday
        assertTrue(itIsABusinessDayInNorway.itIsABusinessDay(thisDayIn, notWorkingDaysInWeekIn));

        thisDayIn.set(Calendar.DAY_OF_MONTH, 7);//Tuesday
        assertTrue(itIsABusinessDayInNorway.itIsABusinessDay(thisDayIn, notWorkingDaysInWeekIn));

        thisDayIn.set(Calendar.DAY_OF_MONTH, 8);//Wednesday
        assertTrue(itIsABusinessDayInNorway.itIsABusinessDay(thisDayIn, notWorkingDaysInWeekIn));

        thisDayIn.set(Calendar.DAY_OF_MONTH, 9);//Thursday
        assertTrue(itIsABusinessDayInNorway.itIsABusinessDay(thisDayIn, notWorkingDaysInWeekIn));

        thisDayIn.set(Calendar.DAY_OF_MONTH, 10);//Friday
        assertTrue(itIsABusinessDayInNorway.itIsABusinessDay(thisDayIn, notWorkingDaysInWeekIn));

        thisDayIn.set(Calendar.DAY_OF_MONTH, 11);//Saturday
        assertFalse(itIsABusinessDayInNorway.itIsABusinessDay(thisDayIn, notWorkingDaysInWeekIn));
    }

    @Test
    void is17thOfMayAHoliday() {
        Calendar thisDayIn = Calendar.getInstance();
        thisDayIn.set(Calendar.MONTH, 4);//May
        thisDayIn.set(Calendar.DAY_OF_MONTH, 17);//17th

        assertFalse(itIsABusinessDayInNorway.itIsABusinessDay(thisDayIn, Collections.emptyList()));
    }

    @Test
    void testAllDaysOfJanuary(){
        Calendar day = Calendar.getInstance();
        int daysInJan = 31;
        for(int i = 0; i < daysInJan; i++){
            day.set(Calendar.MONTH, 0);
            day.set(Calendar.DAY_OF_MONTH, i+1);

            String monthForTest = day.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            String dayForTest = day.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());

            if(day.get(Calendar.DAY_OF_MONTH) == 1){
                assertFalse(itIsABusinessDayInNorway.itIsABusinessDay(day, Collections.emptyList()));
                System.out.println(monthForTest + " " + dayForTest + " " + day.get(Calendar.DAY_OF_MONTH) + " " + "Fridag");
            }else{
                assertTrue(itIsABusinessDayInNorway.itIsABusinessDay(day, Collections.emptyList()));
                System.out.println(monthForTest + " " + dayForTest + " " + day.get(Calendar.DAY_OF_MONTH) + " " + "Arbeidsdag");
            }

        }
    }

    @Test
    void testAllDaysOfFebruary(){
        GregorianCalendar cal = new GregorianCalendar();
        Calendar day = Calendar.getInstance();
        int daysInFeb = 0;
        daysInFeb = cal.isLeapYear(day.get(Calendar.YEAR)) ?  29 : 28;
        for(int i = 0; i < daysInFeb; i++){
            day.set(Calendar.MONTH, 1);
            day.set(Calendar.DAY_OF_MONTH, i+1);

            String monthForTest = day.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            String dayForTest = day.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());

            assertTrue(itIsABusinessDayInNorway.itIsABusinessDay(day, Collections.emptyList()));
            System.out.println(monthForTest + " " + dayForTest + " " + day.get(Calendar.DAY_OF_MONTH) + " " + "Arbeidsdag");
        }
    }

    @Test
    void testAllEasterHolidays(){
        Calendar cal = Calendar.getInstance();
        Easter easter = new Easter();
        Calendar easterDay = easter.whenIsEaster(cal.get(Calendar.YEAR));
        Calendar years = cal;
    }
}