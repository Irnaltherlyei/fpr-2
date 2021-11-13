import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TimeZone timeZone = TimeZone.getDefault();
        GregorianCalendar calendar = new GregorianCalendar(timeZone);

        int maxDaysInCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDateOfMonth = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        int daysInWeek = calendar.getMaximum(Calendar.DAY_OF_WEEK);
        int weeksInMonth = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);

        // cal represents a calender month
        int[][] cal = new int[weeksInMonth][daysInWeek];
        int off = firstDateOfMonth - 1;
        int day = 1;
        for (int i = 0; i < cal.length; i++) {
            for (int j = off; j < cal[i].length && day < maxDaysInCurrentMonth + 1; j++) {
                cal[i][j] = day;
                day++;
                off = 0;
            }
        }

        // Print to console
        System.out.println(new SimpleDateFormat("YYYY MMMM dd - EEEE HH:mm:ss").format(calendar.getTime()));
        for (int[] x:cal) {
            for (int i: x) {
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                System.out.print(String.format("%4s", ((i == currentDay) ? "*":"") + i + " "));
            }
            System.out.println("");
        }

        // Instant calculation and output to console; Array is better solution because it can be used modular.
        // int offSet = 0;
        // for (int j = 1; j < firstDateOfMonth; j++) {
        //     System.out.print("  ");
        //     offSet++;
        // }
        // for (int i = 1; i < maxDaysInCurrentMonth + 1; i++) {
        //     System.out.print(i + " ");
        //     offSet++;
        //     if(offSet % daysInWeek == 0){
        //         System.out.println("");
        //     }
        // }
    }
}
