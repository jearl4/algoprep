package AlgoExpert.Recursion;

import java.util.HashMap;
import java.util.Map;

// find the nth fibonacci number given an int input 
public class NthFibonacci {
    // O(2^n) recursive solution
    public static int getNthFib(int n){
        if(n==2){
            return 1;
        }else if(n == 1){
            return 0;
        }else{
            return getNthFib(n-1) + getNthFib(n -2);
        }
    }

    // O(n) caching
    public static int getNthFibCaching(int n){
        Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
        // insert first 2 numbers
        cache.put(1,0);
        cache.put(2,1);
        return getNthFibCaching(n, cache);
    }
    public static int getNthFibCaching(int n, Map<Integer, Integer> cache){
        if(cache.containsKey(n)){
            return cache.get(n);
        }else{
            cache.put(n, getNthFibCaching(n-1, cache) + getNthFibCaching(n-2, cache));
            return cache.get(n);
        }
    }

    // O(n) iterative
    public static int getNthFibIterative(int n){
        int[] previousTwo = {0,1};
        int counter = 3;
        while (counter <= n) {
            int nextFib = previousTwo[0] + previousTwo[1];
            previousTwo[0] = previousTwo[1];
            previousTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? previousTwo[1] : previousTwo[0];
    }
}