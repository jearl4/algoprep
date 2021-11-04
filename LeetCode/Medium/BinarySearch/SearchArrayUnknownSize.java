package LeetCode.Medium;

/**
 * // This is ArrayReader's API interface. You should not implement it, or
 * speculate about its implementation interface ArrayReader { public int get(int
 * index) {} }
 */
public class SearchArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int start = 0, end = 1;
        while (reader.get(end) < target) {
            int newStart = end + 1;
            end += (end - start) * 2;
            start = newStart;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
