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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    
    public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
        int MC = 0;
        
        List<Integer> uq = new ArrayList<Integer>();
        
        //unique
        for(int i=0; i<arr.size(); i++)
        {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(arr.get(i));
            if(uq.containsAll(temp))
            {
                continue;
            }
            else
            {
                uq.addAll(temp);
            }
        }
        System.out.println(uq);
        
        //List<Integer> ar = new ArrayList<Integer>(uq.size());
        int ar[] = new int[uq.size()];
        
        for(int i=0; i<arr.size(); i++)
        {
            int x = arr.get(i);
            for (int j=0; j<ar.length; j++)
            {
                if(arr.get(i)==uq.get(j))
                {
                    ar[j]+=1;
                    System.out.println(ar[j]);
                }
            }
        }
        
        int pos = 0, great = 0;
        for(int i=0; i<ar.length; i++)
        {
            if (ar[i]>great)
            {
                great = ar[i];
                pos = i;
            }
        }
        
        return uq.get(pos);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

