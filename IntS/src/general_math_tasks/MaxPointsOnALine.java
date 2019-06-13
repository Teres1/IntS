package general_math_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MaxPointsOnALine {
    static class Point {
        private double x;
        private double y;


        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        Point[] points = new Point[3];
        for (int i = 0; i < 3; i++) {
            points[i]=new Point(i+1,i+1);
        }
        System.out.println(maxPointsOnALine.maxPoints(points));

    }

    public int maxPoints(Point[] points) {
        if (points.length <= 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> hm = new HashMap<>();
            int samex = 1;
            int samep = 0;
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) {
                        samep++;
                    }
                    if (points[j].x == points[i].x) {
                        samex++;
                        continue;
                    }
                    double slope = (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    if (hm.containsKey(slope)) {
                        hm.put(slope, hm.get(slope) + 1);
                    } else {
                        hm.put(slope, 2);
                    }
                    result = Math.max(result, hm.get(slope) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
}

