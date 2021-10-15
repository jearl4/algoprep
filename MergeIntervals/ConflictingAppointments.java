package MergeIntervals;

import java.util.*;

import MergeIntervals.DTO.Interval;

public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] array) {
        boolean canAttend = true;
        int i = 1; 

        Arrays.sort(array, (a,b) -> Integer.compare(a.start, b.start));

        while (i < array.length) {
            if (array[i - 1].end > array[i].start) {
                canAttend = false;
            }
            i++;
        }

        return canAttend;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
