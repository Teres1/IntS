package cml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Counting {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        double arr[] = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Double.parseDouble(input[i]);
        }
        Counting cm = new Counting();
        System.out.println(cm.groupArray(arr));
    }

    private double calculateMean(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }

    private List<List<Double>> groupArray(double[] a) {
        double mean = calculateMean(a);
        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        List<Double> list3 = new ArrayList<>();
        List<Double> list4 = new ArrayList<>();
        List<Double> list5 = new ArrayList<>();
        List<List<Double>> res = new ArrayList<>();
        for (double i : a) {
            if (-0.5*Math.abs(mean)<=i&&i<=0.5*Math.abs(mean)) {
                list1.add(i);
            }
        }
        for (double i : a) {
            if (isNumberInInterval(i,0.5*mean,mean)) {
                list2.add(i);
            }
        }
        for (double i : a) {
            if (isNumberInInterval(i,mean,1.5*mean)) {
                list3.add(i);
            }
        }
        for (double i : a) {
            if (isNumberInInterval(i,1.5*mean,2*mean)) {
                list4.add(i);
            }
        }
        for (double i : a) {
            if (isNumberInInterval(i,2*mean,a.length*mean)) {
                list5.add(i);
            }
        }
        res.add(list1);
        if(list2.size()>0) {
            res.add(list2);
        }
        if(list3.size()>0) {
            res.add(list3);
        }
        if(list4.size()>0) {
            res.add(list4);
        }
        if(list5.size()>0) {
            res.add(list5);
        }
        return res;
    }
    private  boolean isNumberInInterval(double num,double a,double b){
        return Math.abs(a)<Math.abs(num)&&Math.abs(num)<=Math.abs(b);
    }
}
