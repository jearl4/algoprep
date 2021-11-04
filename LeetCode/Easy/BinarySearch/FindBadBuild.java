package LeetCode.Easy.BinarySearch;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FindBadBuild {
    public int firstBadVersion(int n) {
        int start = 0, end = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
