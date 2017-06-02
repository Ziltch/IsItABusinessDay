package main.Holidays;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 * @Author Ole K. Olsen
 * 17.05.2017.
 */
public class NorwayHolidays {

    /**
     *
     * @param inputDay Input of the day one wants to to check the type of
     * @param dateOfEaster Day of easter for the year of the day getting checked
     * @return boolean true if the day corresponds with a holiday, false if not
     */
    public boolean isItAHolidayInNorway(LocalDateTime inputDay, LocalDateTime dateOfEaster){

        TemporalField tf = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int inputWeekOfYear = inputDay.get(tf);
        int easterWeekOfYear = dateOfEaster.get(tf);

        //Første nyttårsdag
        if (inputDay.getMonth() == Month.JANUARY && inputDay.getDayOfMonth() == 1) {
            return true;
        }

        //Palmesøndag
        if (inputDay.getDayOfWeek() == DayOfWeek.SUNDAY && inputWeekOfYear == easterWeekOfYear-1){
            return true;
        }

        //Skjærtorsdag
        if (inputDay.getDayOfWeek() == DayOfWeek.THURSDAY && inputWeekOfYear == easterWeekOfYear){
            return true;
        }

        //Langfredag
        if (inputDay.getDayOfWeek() == DayOfWeek.FRIDAY && inputWeekOfYear == easterWeekOfYear){
            return true;
        }

        //Påske
        if(inputDay.getYear() == dateOfEaster.getYear() && inputDay.getMonth() == dateOfEaster.getMonth() && inputDay.getDayOfMonth() == dateOfEaster.getDayOfMonth()){
            return true;
        }

        //Andre påskedag
        if (inputDay.getDayOfWeek() == DayOfWeek.MONDAY && inputWeekOfYear-1 == easterWeekOfYear){
            return true;
        }

        //1 Mai
        if (inputDay.getMonth() == Month.MAY && inputDay.getDayOfMonth() == 1){
            return true;
        }

        //Nasjonaldagen
        if (inputDay.getMonth() == Month.MAY && inputDay.getDayOfMonth() == 17){
            return true;
        }

        //Kristi himmelfart
        if (inputDay.getDayOfYear() == dateOfEaster.getDayOfYear()+39){
            return true;
        }

        //Pinse
        if (inputDay.getDayOfYear() == dateOfEaster.plusDays(49).getDayOfYear()){
            return true;
        }

        //Andre pinsedag
        if (inputDay.getDayOfYear() == dateOfEaster.plusDays(50).getDayOfYear()){
            return true;
        }

        //Første juledag
        if (inputDay.getMonth() == Month.DECEMBER && inputDay.getDayOfMonth() == 25){
            return true;
        }

        //Andre juledag
        if (inputDay.getMonth() == Month.DECEMBER && inputDay.getDayOfMonth() == 26){
            return true;
        }

        return false;
    }
}
