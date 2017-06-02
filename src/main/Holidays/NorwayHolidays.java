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

    public boolean itIsAHolidayInNorway(LocalDateTime inputTime, LocalDateTime dateOfEaster){

        TemporalField tf = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int inputWeekOfYear = inputTime.get(tf);
        int easterWeekOfYear = dateOfEaster.get(tf);

        //Første nyttårsdag
        if (inputTime.getMonth() == Month.JANUARY && inputTime.getDayOfMonth() == 1) {
            return true;
        }

        //Palmesøndag
        if (inputTime.getDayOfWeek() == DayOfWeek.SUNDAY && inputWeekOfYear == easterWeekOfYear-1){
            return true;
        }

        //Skjærtorsdag
        if (inputTime.getDayOfWeek() == DayOfWeek.THURSDAY && inputWeekOfYear == easterWeekOfYear){
            return true;
        }

        //Langfredag
        if (inputTime.getDayOfWeek() == DayOfWeek.FRIDAY && inputWeekOfYear == easterWeekOfYear){
            return true;
        }

        //Påske
        if(inputTime.getYear() == dateOfEaster.getYear() && inputTime.getMonth() == dateOfEaster.getMonth() && inputTime.getDayOfMonth() == dateOfEaster.getDayOfMonth()){
            return true;
        }

        //Andre påskedag
        if (inputTime.getDayOfWeek() == DayOfWeek.MONDAY && inputWeekOfYear-1 == easterWeekOfYear){
            return true;
        }

        //1 Mai
        if (inputTime.getMonth() == Month.MAY && inputTime.getDayOfMonth() == 1){
            return true;
        }

        //Nasjonaldagen
        if (inputTime.getMonth() == Month.MAY && inputTime.getDayOfMonth() == 17){
            return true;
        }

        //Kristi himmelfart
        if (inputTime.getDayOfYear() == dateOfEaster.getDayOfYear()+39){
            return true;
        }

        //Pinse
        if (inputTime.getDayOfYear() == dateOfEaster.plusDays(49).getDayOfYear()){
            return true;
        }

        //Andre pinsedag
        if (inputTime.getDayOfYear() == dateOfEaster.plusDays(50).getDayOfYear()){
            return true;
        }

        //Første juledag
        if (inputTime.getMonth() == Month.DECEMBER && inputTime.getDayOfMonth() == 25){
            return true;
        }

        //Andre juledag
        if (inputTime.getMonth() == Month.DECEMBER && inputTime.getDayOfMonth() == 26){
            return true;
        }

        return false;
    }
}
