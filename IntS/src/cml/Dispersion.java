package cml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dispersion {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        double arr[] = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Double.parseDouble(input[i]);
        }
        //We expect that the input is valid
        if(input.length==1){
            System.out.println("Please enter at least two values");
        }
        Dispersion ds = new Dispersion();
        System.out.println(ds.returnStandardDeviation(arr));
    }

    private double returnStandardDeviation(double[] arr) {
        double standardDeviation = 0;
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double secondSum = 0;
        for (int i = 0; i < arr.length; i++) {
            secondSum += Math.pow(arr[i] - sum / arr.length, 2);
        }
        standardDeviation = Math.sqrt(secondSum / (arr.length - 1));
        return standardDeviation;
    }
}
