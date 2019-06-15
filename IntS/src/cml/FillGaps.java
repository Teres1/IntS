package cml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FillGaps {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        List<String> a = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            a.add(input[i]);
        }
        FillGaps fg = new FillGaps();
        System.out.println(fg.fillGapsFirstWay(a));
        System.out.println(fg.fillGapsSecondWay(a));
        System.out.println(fg.fillGapsThirdWay(a));
    }

    private double calculateStandardDeviation(List<String> a) {
        List<Double> arr = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals("NaN")) {
                arr.add(Double.parseDouble(a.get(i)));
            }
        }
        double standardDeviation = 0;
        double sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        double secondSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            secondSum += Math.pow(arr.get(i) - sum / a.size(), 2);
        }
        standardDeviation = Math.sqrt(secondSum / (a.size() - 1));
        return standardDeviation;
    }

    private List<String> fillGapsFirstWay(List<String> a) {
        List<String> filledArray = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("NaN")) {
                filledArray.add(String.format("%.2f", calculateStandardDeviation(a) * (i - 1) + Double.parseDouble(a.get(0))));
            } else {
                filledArray.add(a.get(i));
            }
        }
        return filledArray;
    }

    private List<String> fillGapsSecondWay(List<String> a) {
        List<String> filledArray = new ArrayList<>();
        double max = -Double.MAX_VALUE;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals("NaN")) {
                if (min > Double.parseDouble(a.get(i))) {
                    min = Double.parseDouble(a.get(i));
                }
                if (max < Double.parseDouble(a.get(i))) {
                    max = Double.parseDouble(a.get(i));
                }
            }
        }
        double actualizer = min + (max - min) / a.size();

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("NaN")) {
                filledArray.add(String.format("%.2f", actualizer * (i + 1) / a.size() + (max - min) / a.size()));
            } else {
                filledArray.add(a.get(i));
            }
        }
        return filledArray;
    }

    private List<String> fillGapsThirdWay(List<String> a) {
        List<String> filledArray = new ArrayList<>();
        filledArray.add(a.get(0));
        double sum = 0;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals("NaN")) {
                sum+=Double.parseDouble(a.get(i));
            }
        }
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).equals("NaN")) {
                if (Math.abs(Double.parseDouble(filledArray.get(i - 1)) - 2 * sum / a.size()) < Math.abs(Double.parseDouble(a.get(i - 1)))) {
                    filledArray.add((Double.parseDouble(a.get(i - 1)) - sum / a.size()) + "");
                } else {
                    filledArray.add((Double.parseDouble(filledArray.get(i - 1)) + sum / a.size()) + "");
                }
            } else {
                filledArray.add(a.get(i));
            }
        }
        return filledArray;
    }
}
