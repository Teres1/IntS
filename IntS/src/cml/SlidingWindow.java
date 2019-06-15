package cml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        double arr[] = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Double.parseDouble(input[i]);
        }
        int v = Integer.parseInt(rd.readLine());
        SlidingWindow sw = new SlidingWindow();
        System.out.println(sw.findSlidingWindow(arr, v));
    }

    private List<Double> findSlidingWindow(double[] a, int v) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int startRange = (int) a[i] - v;
            int endRange = (int) a[i] + v;

            int start = 0;
            for (int k = 0; k < a.length; k++) {
                if (a[k] <= endRange && a[k] >= startRange) {
                    start = k;
                    break;
                }
            }
            double sum = 0;
            int j = start;
            while (a[j] <= endRange) {
                sum += a[j];
                j++;
                if (j == i + endRange + 1 || j == a.length) {
                    break;
                }
                if (a[j] == endRange) {
                    sum += endRange;
                    break;
                }
            }
            list.add(sum);
        }
        return list;

    }
}