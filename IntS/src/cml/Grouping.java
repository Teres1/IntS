package cml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grouping {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        double arr[] = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Double.parseDouble(input[i]);
        }
        //We expect that the input is valid
    }
}
