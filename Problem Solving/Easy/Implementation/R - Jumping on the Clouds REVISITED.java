import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int e = 100;
        int i=k%c.length;
        if(c[i]==0)
            {
                e-=1;
            }
            if(c[i]==1)
            {
                e-=3;
            }
        while(i!=0)
        {
            System.out.println(i);
            i = (i+k)%c.length;
            if(c[i]==0)
            {
                e-=1;
            }
            if(c[i]==1)
            {
                e-=3;
            }
            // System.out.println(i);
            // i = (i+k)%c.length;
            //e-=1;
        }
        return e;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/*
energy = 100 #initial energy
i = k % n #initial jump from 0
energy -= c[i] * 2 + 1 #initial energy loss
while i != 0:
    i = (i + k) % n
    energy -= c[i] * 2 + 1
    
print energy
*/
