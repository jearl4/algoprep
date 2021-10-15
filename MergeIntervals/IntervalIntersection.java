package MergeIntervals;

import java.util.*;
import MergeIntervals.DTO.Interval;

public class IntervalIntersection {
    public static Interval[] findIntersections(Interval[] intervalsA, Interval[] intervalsB) {
        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0, j = 0;
        while (i < intervalsA.length && j < intervalsB.length) {
            if ((intervalsA[i].start >= intervalsB[j].start && intervalsA[i].start <= intervalsB[j].end)
                || (intervalsB[j].start >= intervalsA[i].start && intervalsB[j].start <= intervalsA[i].end)) {
                mergedIntervals.add(new Interval(
                    Math.max(intervalsA[i].start, intervalsB[j].start), 
                    Math.min(intervalsA[i].end, intervalsB[j].end)
                    )
                );
            }
            if (intervalsA[i].end < intervalsB[j].end) {
                i++;
            }else{
                j++;
            }
        }


        return mergedIntervals.toArray(new Interval[mergedIntervals.size()]);
    }
    
    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = findIntersections(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = findIntersections(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
