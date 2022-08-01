import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
    // Write your code here
        ArrayList<Character> a = new ArrayList<>();
        for(int i=0; i<s.length(); i++)
        {
            a.add(s.charAt(i));
        }
        
        int l = a.size();
        int i=0;
        for(i=0; i<l-1; i++)
        {
            if(a.get(i)==a.get(i+1))
            {
                System.out.println(a.get(i));
                System.out.println(a.get(i+1));
                a.remove(i);
                a.remove(i);
                i=-1;
                l=a.size();
                System.out.println(a);
            }
        }
        System.out.println(a);
        
        String ans = "";
        for(i=0; i<a.size(); i++)
        {
            ans+=a.get(i);
        }
        if(ans=="")
        {
            return "Empty String";
        }
        else
        {
            return ans;
        }
        
    }
    
    public static boolean hasSecond(ArrayList<Character> ex, int ind)
    {
        if(ex.get(ind)==ex.get(ind+1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
