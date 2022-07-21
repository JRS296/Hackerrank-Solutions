import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
        int mgizSqrConst = 15;
        int cost = 0;
        
        return cost;
    }
    public static boolean isMagicSquare(List<List<Integer>> s)
    {
        int mgizSqrConst = 15;
        boolean ans = false;
        for(int i=0; i<s.size();i++)
        {
            int sum_r = 0;
            for(int j=0; j<s.size(); j++)
            {
                //rows
                sum_r+=s.get(i).get(j);
                
                //diagonals
                if()
            }
            
            System.out.println(sum_r);
        }
        
        
        
        for(int i=0; i<s.size();i++)
        {
            for(int j=0; j<s.size(); j++)
            {
                //columns
                if()
                
                
                //diagonals
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] sRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> sRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowTempItems[j]);
                sRowItems.add(sItem);
            }

            s.add(sRowItems);
        }

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
