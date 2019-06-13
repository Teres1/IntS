package general_math_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.largestNumber(arr));
    }

    private String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = nums[i] + "";
        }
        Arrays.sort(s, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(s).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }
}