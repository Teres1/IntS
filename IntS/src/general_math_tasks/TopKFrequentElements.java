package general_math_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        int arr[] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int k = Integer.parseInt(rd.readLine());
        TopKFrequentElements tp = new TopKFrequentElements();
        System.out.println(tp.findTopKFrequentElementsInArray(arr, k));
    }

    private Set<Integer> findTopKFrequentElementsInArray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : nums)
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        //We put elements in LinkedHashMap ordered in descending order
        LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        TreeMap<Integer, Integer> finalMap = reverseSortedMap.entrySet().stream().limit(k).collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
        return finalMap.keySet();
    }
}

