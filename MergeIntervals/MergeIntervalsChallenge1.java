package MergeIntervals;

import java.util.*;

import MergeIntervals.DTO.Interval;

public class MergeIntervalsChallenge1 {
    public static int meetingRoomsRequired(List<Interval> meetings) {
        int roomsRequired = 0;

        if (meetings == null || meetings.size() == 0) {
            return roomsRequired;
        }

        Collections.sort(meetings, (a,b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Interval> minHeap = new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));

        for (Interval meeting : meetings) {
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            minHeap.offer(meeting);
            roomsRequired = Math.max(roomsRequired, minHeap.size());
        }

        return roomsRequired;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>() {
            {
              add(new Interval(4, 5));
              add(new Interval(2, 3));
              add(new Interval(2, 4));
              add(new Interval(3, 5));
            }
          };
          int result = meetingRoomsRequired(input);
          System.out.println("Minimum Interval rooms required: " + result);
      
          input = new ArrayList<Interval>() {
            {
              add(new Interval(1, 4));
              add(new Interval(2, 5));
              add(new Interval(7, 9));
            }
          };
          result = meetingRoomsRequired(input);
          System.out.println("Minimum Interval rooms required: " + result);
      
          input = new ArrayList<Interval>() {
            {
              add(new Interval(6, 7));
              add(new Interval(2, 4));
              add(new Interval(8, 12));
            }
          };
          result = meetingRoomsRequired(input);
          System.out.println("Minimum Interval rooms required: " + result);
      
          input = new ArrayList<Interval>() {
            {
              add(new Interval(1, 4));
              add(new Interval(2, 3));
              add(new Interval(3, 6));
            }
          };
          result = meetingRoomsRequired(input);
          System.out.println("Minimum Interval rooms required: " + result);
      
          input = new ArrayList<Interval>() {
            {
              add(new Interval(4, 5));
              add(new Interval(2, 3));
              add(new Interval(2, 4));
              add(new Interval(3, 5));
            }
          };
          result = meetingRoomsRequired(input);
          System.out.println("Minimum Interval rooms required: " + result);
    }
}
