import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import DTO.Interval;

public class OverlappingInterval {
    public static boolean isOverlappingInterval(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval currentInterval = intervalIterator.next();
        int end = currentInterval.end;

        while (intervalIterator.hasNext()) {
            currentInterval = intervalIterator.next();
            if(currentInterval.start < end){
                return true;
            }else{
                end = currentInterval.end;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print(isOverlappingInterval(input));
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print(isOverlappingInterval(input));
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print(isOverlappingInterval(input));
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 2));
        input.add(new Interval(3, 3));
        input.add(new Interval(4, 5));
        System.out.print(isOverlappingInterval(input));
        System.out.println();
    }
}
