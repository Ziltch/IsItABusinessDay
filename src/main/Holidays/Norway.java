package main.Holidays;

import java.util.Calendar;

/**
 * @Author Ole K. Olsen
 * 17.05.2017.
 */
public class Norway {

    public boolean itIsAHolidayInNorway(Calendar thisDay, Calendar dateOfEaster){;

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
