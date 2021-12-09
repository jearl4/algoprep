package LeetCode.Explore.HashTable;

import java.util.HashSet;

class HappyNumber202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    
    private int getNext(int n){
        int totalSum = 0;
        while(n > 0){
            int digit = n % 10;
            n = n / 10;
            totalSum += Math.pow(digit, 2);
        }
        return totalSum;
    }
}