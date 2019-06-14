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
        int v=Integer.parseInt(rd.readLine());
        SlidingWindow sw=new SlidingWindow();
        System.out.println(sw.findSlidingWindow(arr,v));
    }
    private List<Double> findSlidingWindow(double[]a, int v){
        List<Double>list=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int startRange=(int)a[i]-v;
            int endRange=(int)a[i]+v;
            System.out.println(startRange+"*"+endRange);
            int start=0;
            int end=0;
            if(startRange<0){
                start=0;
            }else {
                start=startRange;
            }
            if(endRange>a.length-1){
                end=a.length-1;
            }else{
                end=endRange;
            }
            double sum=0;
            for (int j = start; j <= end; j++) {
                if(a[j]>=startRange&&a[j]<=endRange){
                    sum+=a[j];
                }
            }
            list.add(sum);
        }
        return list;
    }
}
