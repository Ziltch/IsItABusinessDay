package main;

import main.Holidays.NorwayHolidays;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ole K. Olsen
 * 17.05.2017.
 */
public class ItIsABusinessDay{

    private Easter easter = new Easter();
    private NorwayHolidays norway = new NorwayHolidays();
    private ArrayList<DayOfWeek> notWorkingDaysInWeek = new ArrayList<>();

    public TypeOfDay itIsABusinessDay(LocalDateTime thisDayInput, List<DayOfWeek> notWorkingDaysInWeekInput) {

        LocalDateTime thisDay = thisDayInput.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime dayBefore = thisDay.minusDays(1);
        LocalDateTime dayAfter = thisDay.plusDays(1);

        boolean isThisDayBusinessDay = isDayBusinessDay(thisDay, notWorkingDaysInWeekInput);
        boolean isDayBeforeBusinessDay = isDayBusinessDay(dayBefore, notWorkingDaysInWeekInput);
        boolean isDayAfterBusinessDay = isDayBusinessDay(dayAfter, notWorkingDaysInWeekInput);

        if (isThisDayBusinessDay) {
            if(!isDayBeforeBusinessDay && !isDayAfterBusinessDay){
                System.out.println("Squeezed");
                return TypeOfDay.SQUEEZEDINDAY;
            } else {
                System.out.println("Business");
                return TypeOfDay.BUSINESSDAY;
            }
        } else {
            System.out.println("Free");
            return TypeOfDay.DAYOFF;
        }
    }

    private boolean isDayBusinessDay(LocalDateTime dayInput,
                                     List<DayOfWeek> notWorkingDaysInWeekInput){
        notWorkingDaysInWeek.clear();
        notWorkingDaysInWeek.addAll(notWorkingDaysInWeekInput);
        boolean isBusinessDay = true;
        LocalDateTime dateOfEaster = easter.whenIsEaster(dayInput.getYear());

        //Dagene i uken det er fri
        if (!(notWorkingDaysInWeek.isEmpty())) {
            for (int i = 0; i < notWorkingDaysInWeek.size(); i++) {
                System.out.println(notWorkingDaysInWeek.get(i));
                if (dayInput.getDayOfWeek() == notWorkingDaysInWeek.get(i)) {
                    isBusinessDay = false;
                }
            }
        }

        if (norway.itIsAHolidayInNorway(dayInput, dateOfEaster)) {
            isBusinessDay = false;
        }
        return isBusinessDay;
    }
}
