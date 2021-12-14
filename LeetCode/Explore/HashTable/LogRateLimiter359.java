package LeetCode.Explore.HashTable;

import java.util.HashMap;
import java.util.Map;

public class LogRateLimiter359 {
    LogRateLimiter359 logger;
    Map<String, Integer> map;
    public LogRateLimiter359() {
        logger = new LogRateLimiter359();
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean shouldPrintMessage = true;
        if(map.containsKey(message)){
            int oldTime = map.get(message);
            if(oldTime + 10 > timestamp){
                shouldPrintMessage = false;
            }else{
                map.put(message, timestamp);
            }
        }else{
            map.put(message, timestamp);
        }
        return shouldPrintMessage;
    }
}
