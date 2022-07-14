import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'chocolateFeast' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c
     *  3. INTEGER m
     */

    public static int chocolateFeast(int n, int c, int m) {
    // Write your code here
        int choco=n/c,eat=0,wp=0;
        while(choco>0){  //add until chocolate=0
            eat+=choco;
            wp+=choco;   //counting no. of chocolates as wrappers
            choco=wp/m;  //No. of wrappers turned
            wp=wp%m;     //left wrappers
        }
    return eat;
    }
    
    // public static int recFunc(int bars, int wrappers, int m, int leftover, int total)
    // {
    //     if (wrappers/m>0)
    //     {
    //         System.out.println(bars+""+wrappers+""+m+""+leftover+""+total);
    //         total += bars;
    //         wrappers = bars;
    //         bars = wrappers/m;
    //         leftover = wrappers%m;
    //         //System.out.println(bars+""+wrappers+""+m+""+leftover+""+total);
    //         return recFunc(bars, wrappers, m, leftover, total);
    //     }
    //     else
    //     {
    //         return total;
    //     }
    // }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int c = Integer.parseInt(firstMultipleInput[1]);

            int m = Integer.parseInt(firstMultipleInput[2]);

            int result = Result.chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
