package general_math_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        LongestConsecutiveSubsequence ls=new LongestConsecutiveSubsequence();
        System.out.println(ls.findLongestConsecutiveSubsequence(arr));
    }
    private int findLongestConsecutiveSubsequence(int arr[])
    {
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;
        for (int i=0; i<arr.length;i++) {
            set.add(arr[i]);
        }
        for (int i=0; i< arr.length; i++) {
            if (!set.contains(arr[i]-1)) {
                int start = arr[i];
                while (set.contains(start))
                    start++;
                if (longest<start-arr[i])
                    longest = start-arr[i];
            }
        }
        return longest;
    }
}
