package general_math_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public static void main(String[] args) throws IOException {
        int [][]arr={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        QueueReconstructionByHeight queueReconstructionByHeight=new QueueReconstructionByHeight();
        for (int[] x : queueReconstructionByHeight.reconstructQueue(arr)) {
            System.out.print(Arrays.toString(x)+" ");
        }
    }

    private int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }
}
