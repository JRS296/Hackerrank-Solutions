import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
    // Write your code here
        ArrayList<Integer> uq = new ArrayList<Integer>();
        //unique
        for (int i=0; i<a.size(); i++)
        {
            if(uq.contains(a.get(i)))
            {
                //System.out.println("Yes");
                continue;
            }
            else
            {
                uq.add(a.get(i));
            }
        }
        //System.out.println(uq);
        //int ans = 999999999;
        // for (int j=0; j<uq.size(); j++)
        // {
        //     int dist = 0;
        //     int x = uq.get(j);
        //     for(int k=0; k<a.size(); k++)
        //     {
        //         if (a.get(k)==x)
        //         {
        //             for(int l=0; l<a.size(); k++)
        //             {
        //             System.out.println("Hello"+a.get(k)+" "+x);
        //             dist = Math.abs(k-j);
        //             System.out.println(dist);
        //             if (dist<ans && dist>2)
        //             {
        //                 ans=dist;
                        
        //                 break;
        //             }
        //             System.out.println(ans); 
        //         }
        //     }
        // }
        // if (ans==999999999)
        //     return -1;
        // else
        //     return ans;
        // int ans = 999999999;
        // for(int i=0; i<a.size(); i++)
        // {
        //     for(int j=i+1; j<a.size()-1; j++)
        //     {
        //         if(a.get(i)==a.get(j))
        //         {
        //             int dist = Math.abs(i-j);
        //             System.out.println(dist);
        //             if(ans>dist)
        //             {
        //                 ans = dist;
        //                 System.out.println(ans);
        //             }
        //         }
        //     }
        // }
        // if (ans==999999999)
        //      return -1;
        // else
        //     return ans;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int minDistance = 999999999, prevIndex = 0, currentIndex = 0;

        for (int i = 0; i < a.size(); i++) {
            if (hmap.containsKey(a.get(i))) {
                currentIndex = i;
                prevIndex = hmap.get(a.get(i));
                minDistance = Math.min((currentIndex - prevIndex), minDistance);
            }
            else{
                hmap.put(a.get(i), i);//Eg: 10 4
            }
        }
        return (minDistance == 999999999 ? -1 : minDistance);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
