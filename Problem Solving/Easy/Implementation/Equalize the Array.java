import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
        
        int greatest = 0;
        int len = arr.size();
        for (int i=0; i<len; i++)
        {
            int count = 0;
            int x = arr.get(i);
            for (int j=0; j<len; j++)
            {
                if(arr.get(j)==x)
                {
                    count++;
                }
            }
            if (count > greatest)
            {
                greatest = count;
            }
        }
        return len-greatest;
    /* Write your code here
        int steps = 0;
        int len = arr.size();
        int cnt = 0;
        ArrayList<Integer> uq = new ArrayList<Integer>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        //unique
        for (int i=0; i<len; i++)
        {
            if(uq.contains(arr.get(i)))
            {
                //System.out.println("Yes");
                continue;
            }
            else
            {
                uq.add(arr.get(i));
            }
        }
        //System.out.println(uq);
        
        for (int i=0; i<len; i++)
        {
            if(arr.get(i)==uq.get(i))
            {
        
        steps = len - cnt;
        return steps;*/
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
