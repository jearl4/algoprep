package LeetCode.Contests.Biweekly66;

// Ran out of time
public class MinBuckets5923 {
    public int minimumBuckets(String street) {
        int bucketCount = 0;
        
        if(street.length() == 1){
            if(street.charAt(0) == 'H'){
                return -1;
            }else{
                return 0;
            }
        }
        
        for(int i = 0; i < street.length(); i++){
            if(street.charAt(i) == '.' && street.charAt(i - 1) == 'H' && street.charAt(i + 1) == 'H'){
                bucketCount++;
            }else if(street.charAt(i) == '.' && street.charAt(i - 1) == 'H' && street.charAt(i + 1) == 'H'){
                
            }
        }
        return bucketCount;
    }
}
