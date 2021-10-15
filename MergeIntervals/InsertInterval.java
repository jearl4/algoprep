package MergeIntervals;

import java.util.*;
import MergeIntervals.DTO.Interval;
public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervalList, Interval insertedInterval) {
        if(intervalList == null || intervalList.isEmpty()){
            return Arrays.asList(insertedInterval);
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;
        while (i < intervalList.size() && intervalList.get(i).end < insertedInterval.start) {
            mergedIntervals.add(intervalList.get(i++));
        }

        while (i < intervalList.size() && intervalList.get(i).start <= insertedInterval.end) {
            insertedInterval.start = Math.min(intervalList.get(i).start, insertedInterval.start);
            insertedInterval.end = Math.max(intervalList.get(i).end, insertedInterval.end);
            i++;
        }

        mergedIntervals.add(insertedInterval);

        while (i < intervalList.size()) {
            mergedIntervals.add(intervalList.get(i++));
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
