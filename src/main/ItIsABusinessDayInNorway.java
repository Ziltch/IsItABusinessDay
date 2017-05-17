package main;

import main.Holidays.Norway;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Author Ole K. Olsen
 * 17.05.2017.
 */
public class ItIsABusinessDay{
    private Easter easter = new Easter();
    private Norway norway = new Norway();
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
        //If other countries are added later, a switch could be used to alter between them, todo later?
//        if(Country = "NORWAY"){
//            Norway norway = new Norway();
//            if(norway.itIsAHolidayInNorway(thisDay, dateOfEaster)){
//                return false;
//            }
//        }
        if(norway.itIsAHolidayInNorway(thisDay, dateOfEaster)){
            return false;
        }
        return true;
    }
}
