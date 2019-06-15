package cml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindTrend {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        double[] a = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            a[i] = Double.parseDouble(input[i]);
        }
        FindTrend ft = new FindTrend();
        System.out.println(ft.findTrendSecondWay(a));
        System.out.println(ft.findTrendFirstWay(a));
    }

    //We expect that input is valid
    //First way->Least square equation
    private List<Double> findTrendSecondWay(double[] arr) {
        double arrSum = 0;
        double indexSum = 0;
        double arrElementMultiplyByIndexSum = 0;
        double indexSquareSum = 0;
        double firstIndexOfLinearRegresion = 0;
        double secondIndexOfLinearRegresion = 0;
        List<Double> result = new ArrayList<>();
        for (double i :arr) {
            arrSum += i;
        }
        for (int i = 0; i < arr.length; i++) {
            indexSum += i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arrElementMultiplyByIndexSum += arr[i] * (i + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            indexSquareSum += Math.pow(i + 1, 2);
        }
        secondIndexOfLinearRegresion = (arrElementMultiplyByIndexSum - indexSum * arrSum / arr.length) / (indexSquareSum - indexSum * indexSum / arr.length);
        firstIndexOfLinearRegresion = (arrSum - secondIndexOfLinearRegresion * indexSum) / arr.length;
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        for (int i = 0; i < 5; i++) {
            result.add(firstIndexOfLinearRegresion + result.get(result.size() - 2) * secondIndexOfLinearRegresion);
        }
        return result;
    }

    //Second way->Linear equation
    private List<Double> findTrendFirstWay(double[] arr) {
        List<Double> result = new ArrayList<>();
        if (arr.length >= 3) {
            double a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
            double b = arr[1] - a * arr[0];
            for (int i = 0; i < arr.length; i++) {
                result.add(arr[i]);
            }
            for (int i = 0; i < 5; i++) {
                result.add(a * result.get(result.size() - 1) + b);
            }
        }
        return result;
    }

}
