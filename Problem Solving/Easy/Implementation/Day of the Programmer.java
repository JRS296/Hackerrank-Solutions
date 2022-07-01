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
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
    // Write your code here
        if (year>=1700 && year<=1917)
        {
            return(Julian(year));
        }
        else if (year > 1917)
        {
            return(Gregorian(year));
        }
        return("NULL");
    }
    
    public static int leapYear(int year, int type)
    {
        int ans = 0;
        if (type == 0)
        {
            if (year % 400 == 0)
                ans++;
            else if (year % 4 == 0 && year % 100 != 0)
                ans++;
        }
        else if (type == 1)
        {
            if (year % 4 == 0)
                ans++;
        }
        
        return ans;
    }
    
    public static String Gregorian(int y)
    {
        int l = leapYear(y, 0);
        String ans = "";
        if (y==1918)
        {
            ans += "26.09." + Integer.toString(y);
            return ans;
        }
        
        if (l==0)
        {
            ans += "13.09." + Integer.toString(y);
        }
        else if(l>0)
        {
            ans += "12.09." + Integer.toString(y);
        }
        
        
        return ans;
    }
    public static String Julian(int y)
    {
        int l = leapYear(y, 1);
        String ans = "";
        if (l==0)
        {
            ans += "13.09." + Integer.toString(y);
        }
        else if(l>0)
        {
            ans += "12.09." + Integer.toString(y);
        }
        return ans;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
