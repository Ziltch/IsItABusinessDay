package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Author Ole K. Olsen
 * 17.05.2017.
 */
public class ItIsABusinessDayInNorway {
    private Easter easter = new Easter();
    private ArrayList<Integer> notWorkingDaysInWeek = new ArrayList<Integer>();

    public boolean itIsABusinessDay(Calendar thisDayInput, List<Integer> notWorkingDaysInWeekInput) {
        notWorkingDaysInWeek.clear();
        notWorkingDaysInWeek.addAll(notWorkingDaysInWeekInput);

        Calendar thisDay = thisDayInput;
        Calendar dateOfEaster = easter.whenIsEaster(thisDay.get(Calendar.YEAR));
        thisDay.set(Calendar.HOUR_OF_DAY, 0);
        thisDay.set(Calendar.MINUTE, 0);
        thisDay.set(Calendar.SECOND, 0);

        //Dagene i uken det er fri
        if (!(notWorkingDaysInWeek.isEmpty())) {
            for (int i = 0; i < notWorkingDaysInWeek.size(); i++) {
                System.out.println(thisDay.get(Calendar.DAY_OF_WEEK) + " DAY OF WEEK");
                System.out.println(notWorkingDaysInWeek.get(i));
                if (thisDay.get(Calendar.DAY_OF_WEEK) == notWorkingDaysInWeek.get(i)) {
                    return false;
                }
            }
        }
        if(itIsAHoliday(thisDay, dateOfEaster)){
            return false;
        }
        return true;
    }

    private boolean itIsAHoliday(Calendar thisDay, Calendar dateOfEaster){;

        //Første nyttårsdag
        if (thisDay.get(Calendar.MONTH) == Calendar.JANUARY && thisDay.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }

        //Palmesøndag
        if (thisDay.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && thisDay.get(Calendar.WEEK_OF_YEAR) == dateOfEaster.get(Calendar.WEEK_OF_YEAR)-1){
            System.out.println(thisDay.get(Calendar.WEEK_OF_YEAR) + " " + (dateOfEaster.get(Calendar.WEEK_OF_YEAR)-1));
            System.out.println(dateOfEaster.get(Calendar.WEEK_OF_YEAR));
            return true;
        }

        //Skjærtorsdag
        if (thisDay.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY && thisDay.get(Calendar.WEEK_OF_YEAR)-1 == dateOfEaster.get(Calendar.WEEK_OF_YEAR)){
            return true;
        }

        //Langfredag
        if (thisDay.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && thisDay.get(Calendar.WEEK_OF_YEAR)-1 == dateOfEaster.get(Calendar.WEEK_OF_YEAR)){
            return true;
        }

        //Påske
        if(thisDay == dateOfEaster){
            return true;
        }

        //Andre påskedag
        if (thisDay.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && thisDay.get(Calendar.WEEK_OF_YEAR) == dateOfEaster.get(Calendar.WEEK_OF_YEAR)){
            return true;
        }

        //1 Mai
        if (thisDay.get(Calendar.MONTH) == Calendar.MAY && thisDay.get(Calendar.DAY_OF_MONTH) == 1){
            return true;
        }

        //Nasjonaldagen
        if (thisDay.get(Calendar.MONTH) == Calendar.MAY && thisDay.get(Calendar.DAY_OF_MONTH) == 17){
            return true;
        }

        //Kristi himmelfart
        if (thisDay.get(Calendar.DAY_OF_YEAR) == dateOfEaster.get(Calendar.DAY_OF_YEAR)+39){
            return true;
        }

        //Pinse
        if (thisDay.get(Calendar.DAY_OF_YEAR) == dateOfEaster.get(Calendar.DAY_OF_YEAR)+50){
            return true;
        }

        //Andre pinsedag
        if (thisDay.get(Calendar.DAY_OF_YEAR) == dateOfEaster.get(Calendar.DAY_OF_YEAR)+51){
            return true;
        }

        //Første juledag
        if (thisDay.get(Calendar.MONTH) == Calendar.DECEMBER && thisDay.get(Calendar.DAY_OF_MONTH) == 25){
            return true;
        }

        //Andre juledag
        if (thisDay.get(Calendar.MONTH) == Calendar.DECEMBER && thisDay.get(Calendar.DAY_OF_MONTH) == 26){
            return true;
        }
        return false;
    }
}
