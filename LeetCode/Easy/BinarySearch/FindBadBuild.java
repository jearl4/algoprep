package LeetCode.Easy.BinarySearch;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FindBadBuild {
    public int firstBadVersion(int n) {
        int start = 0, end = n, badVersionIndex = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
                badVersionIndex = Math.min(mid, badVersionIndex);
            } else if (!isBadVersion(mid)) {
                start = mid + 1;
            }
        }
        return badVersionIndex;
    }
}
