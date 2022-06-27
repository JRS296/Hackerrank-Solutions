import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        //System.out.println(s);
        int l = s.length();
        String ans = "";
        if (s.charAt(8)=='P')
        {
            //System.out.println("Evening");
            String x = s.substring(0, 2);
            int chng = Integer.parseInt(x);
            if (chng < 12)
            {
                chng += 12;
            }
            ans += Integer.toString(chng) + s.substring(2, l-2);
        }
        else if (s.charAt(8)=='A')
        {
            //System.out.println("Evening");
            String x = s.substring(0, 2);
            int chng = Integer.parseInt(x);
            if (chng >= 12)
            {
                chng -= 12;
            }
            ans += "0" + Integer.toString(chng) + s.substring(2, l-2);
        }
        //System.out.println(ans);
        return (ans);
    }
    
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
