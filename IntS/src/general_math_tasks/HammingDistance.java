package general_math_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HammingDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(rd.readLine());
        int b=Integer.parseInt(rd.readLine());
        HammingDistance hd=new HammingDistance();
        System.out.println(hd.hammingDistance(a,b));
    }
    private int hammingDistance(int a, int b) {
        int c=a^b;
        String d=Integer.toString(c,2);
        int res = 0;

        for (int i = 0; i < d.length(); i++) {
            if(d.charAt(i)=='1'){
                res++;
            }
        }
        return res;
    }
}
