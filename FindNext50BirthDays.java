package onlineExams;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Mahsa
 * Date: 2/11/19
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindNext50BirthDays {
    public static void main(String[] args) {
        System.out.print(run("29-02"));
    }

    public static String run(String birthday_date) {

        String[] split = birthday_date.split("-");
        int day = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]) + 1;
        int year;

        String future_dates = "";
        Calendar cal = Calendar.getInstance();
        StringBuilder sj = new StringBuilder("");
        for (year = 2016; year < 2066; year++) {
            cal.set(year, month, day);

            int time = cal.get(Calendar.DAY_OF_WEEK);
            if (time == 4 || time == 5 || time == 6) {
                sj.append(getDayName(time)).append("-").append(year);
                sj.append(" ");
            }
            int length = sj.toString().length();
            if (length>0)
                future_dates = sj.toString().substring(0, sj.toString().length() - 1);
            else
                future_dates=sj.toString();
        }
        return future_dates;
    }

    private static String getDayName(int day) {
        String result = "";
        switch (day) {
            case 4:
                result = "Fri";
                break;
            case 5:
                result = "Sat";
                break;
            case 6:
                result = "Sun";
                break;
        }
        return result;
    }
}