import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
    // Write your code here
        String num[] = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
        String terms[] = {"o' clock", "minute", "minutes", "past", "quarter","to"};
        String ans = "";
        
        if(m==0)
        {
            ans+=num[h]+" "+terms[0];
        }
        else if(m>0 && m<15)
        {
            if(m==1)
            {
                ans+=num[1]+" "+terms[1]+" past "+num[h];
            }
            else
            {
                ans+=num[m]+" "+terms[2]+" past "+num[h];
            }
        }
        else if(m==15)
        {
            ans+=terms[4]+" "+terms[3]+" "+num[h];
        }
        else if(m>15 && m<30)
        {
            if(m>15&&m<21)
            {
                ans+=num[m]+" minutes past "+num[h];
            }
            else
            {
                ans+=num[20]+" "+num[m%20]+" minutes"+" past "+num[h];
            }
        }
        else if(m==30)
        {
            ans+="half past "+num[h];
        }
        else if(m>30 && m<45)
        {
            if((60-m)>15&&(60-m)<21)
            {
                ans+=num[60-m]+" "+terms[2]+" to "+num[h+1];
            }
            else
            {
                ans+=num[20]+" "+num[(60-m)%20]+" "+terms[2]+" to "+num[h+1];
            }
        }
        else if(m==45)
        {
            ans+=terms[4]+" to "+num[h+1];
        }
        else if(m>45 && m<60)
        {
            
            ans+=num[60-m]+" "+terms[2]+" to "+num[h+1];
            
        }
        return ans;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
