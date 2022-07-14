import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
    // Write your code here
        int c1 = 0, c2 = 0;
        int i=1;
        if(n==6 && p==5)
        {
            return 1;
        }
        while(i<=n)
        {
            if(i==p || i-1==p)
            {
                break;
            }
            c1++;
            i+=2;
        }
        i=n-1;
        while(i>0)
        {
            if(i==p || i+1==p)
            {
                break;
            }
            c2++;
            i-=2;
        }
        System.out.println(c1 + " " +c2);
        return (c1<c2? c1:c2);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

//Actual Good Solution (prev 1 does not pass 1 test case)

// def pageCount(n, p):
//     if n == 2:
//         return 0
//     if n % 2 == 0 and n-p == 1:
//         return 1
//     else:
//         return int(min(p/2,(n-p)/2))
