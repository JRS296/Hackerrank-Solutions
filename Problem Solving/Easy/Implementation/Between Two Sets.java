package Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        List<Integer> ar1 = new ArrayList<Integer>();
        
        int smallest = 0;
        int greatest = 9999;
        
        for (int i=0; i<a.size(); i++)
        {
            int x = a.get(i);
            if (x>smallest)
            {
                smallest = x;
                //System.out.println(x);
            }
        }
        
        for (int i=0; i<b.size(); i++)
        {
            int x = b.get(i);
            if (x<greatest)
            {
                greatest = x;
                //System.out.println(x);
            }
        }
        
        for (int i=smallest; i<=greatest; i++)
        {
            int counter = 0;
            for (int j=0; j<a.size(); j++)
            {
                if(i%a.get(j)==0)
                {
                    counter++;
                }
            }
            if (counter==a.size())
            {
                ar1.add(i);
            }
        }
        
        //System.out.println(ar1);
        
        List<Integer> ar2 = new ArrayList<Integer>();
        
        for (int i=0; i<ar1.size(); i++)
        {
            for (int j=0; j<b.size(); j++)
            {
                //System.out.println(ar1.get(i) + " " + b.get(j));
                if(b.get(j)%ar1.get(i)!=0)
                {
                    ar2.add(ar1.get(i));
                    break;
                }
            }
        }
        ar1.removeAll(ar2);
        return (ar1.size());
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
