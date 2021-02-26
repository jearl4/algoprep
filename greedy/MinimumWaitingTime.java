package greedy;

import java.util.Arrays;

public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] waitingTimes){
        Arrays.sort(waitingTimes);
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < waitingTimes.length; i++) {
            if(i==0){
                continue;
            }
            temp += waitingTimes[i-1];
            sum += temp;
        }
        return sum;
    }
}
