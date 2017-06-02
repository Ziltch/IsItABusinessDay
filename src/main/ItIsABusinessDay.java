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

    /**
     *
     * @param inputDay Input of the day one wants to to check the type of
     * @param daysOffInWeek Weekdays that are off each week
     * @return TypeOfDay What type of day it is
     */
    public TypeOfDay itIsABusinessDay(LocalDateTime inputDay, List<DayOfWeek> daysOffInWeek) {

        LocalDateTime day = inputDay.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime dayBefore = day.minusDays(1);
        LocalDateTime dayAfter = day.plusDays(1);

        boolean isThisDayBusinessDay = isDayBusinessDay(day, daysOffInWeek);
        boolean wasPreviousDayBusinessDay = isDayBusinessDay(dayBefore, daysOffInWeek);
        boolean isNextDayBusinessDay = isDayBusinessDay(dayAfter, daysOffInWeek);

        if (isThisDayBusinessDay) {
            if(!wasPreviousDayBusinessDay && !isNextDayBusinessDay){
                return TypeOfDay.SQUEEZEDINDAY;
            } else {
                return TypeOfDay.BUSINESSDAY;
            }
        } else {
            return TypeOfDay.DAYOFF;
        }
    }

    /**
     *
     * @param day Input of the day one wants to to check the type of
     * @param daysOffInWeek Weekdays that are off each week
     * @return boolean of whether the day is a business day or not
     */
    private boolean isDayBusinessDay(LocalDateTime day, List<DayOfWeek> daysOffInWeek){
        notWorkingDaysInWeek.clear();
        notWorkingDaysInWeek.addAll(daysOffInWeek);
        boolean isBusinessDay = true;

        LocalDateTime dateOfEaster = easter.whenIsEaster(day.getYear());

        //Days off a week
        if (!(notWorkingDaysInWeek.isEmpty())) {
            for (int i = 0; i < notWorkingDaysInWeek.size(); i++) {
                System.out.println(notWorkingDaysInWeek.get(i));
                if (day.getDayOfWeek() == notWorkingDaysInWeek.get(i)) {
                    isBusinessDay = false;
                }
            }
        }

        if (norway.isItAHolidayInNorway(day, dateOfEaster)) {
            isBusinessDay = false;
        }
        return isBusinessDay;
    }
}
