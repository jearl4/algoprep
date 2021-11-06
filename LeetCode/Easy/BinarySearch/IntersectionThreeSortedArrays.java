package LeetCode.Easy.BinarySearch;

public class IntersectionThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new LinkedHashMap();
        List<Integer> solution = new ArrayList();

        for (Integer num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer num : arr3) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer item : map.keySet()) {
            if (map.get(item) == 3) {
                solution.add(item);
            }
        }
        return solution;
    }
}
