package general_math_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutations {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Permutations pm = new Permutations();
        pm.generatePermutations(arr, input.length, input.length);
    }

    //We use Heap's algorithm
    private void generatePermutations(int arr[], int size, int n) {
        if (size == 1) {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
        for (int i = 0; i < size; i++) {
            generatePermutations(arr, size - 1, n);
            if (size % 2 == 1) {
                int temp = arr[0];
                arr[0] = arr[size - 1];
                arr[size - 1] = temp;
            } else {
                int temp = arr[i];
                arr[i] = arr[size - 1];
                arr[size - 1] = temp;
            }
        }
    }
}
