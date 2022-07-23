import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        String ans = "";
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==' ')
            {
                continue;
            }
            else
            {
                ans+=s.charAt(i);
            }
        }
        int r=0, c=0;
        
        int l = ans.length();
        double target = Math.sqrt(l);
        r = (int)Math.floor(target);
        c = (int)Math.ceil(target);
        System.out.println(r+" "+c);
        while(r*c<l)
        {
            r++;
        }
        
        System.out.println(ans);
        
        char ch[][] = new char[r][c];
        int count = 0;
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {   
                if(count==l)
                {
                    ch[i][j]=' ';
                    //System.out.print(ch[i][j]+"&^*");
                }          
                else
                {
                    ch[i][j]=ans.charAt(count);
                    //System.out.print(ch[i][j]);
                    count++;
                }
                //System.out.println(" ");
            }
            //System.out.println(" ");
        }
        String finAns = "";
        count=0;
        for(int j=0; j<c; j++)
        {          
            for(int i=0; i<r; i++)
            {    
                finAns+=ch[i][j];
                count++;
                if (count==(r*c))
                {
                    break;
                }
            }
            finAns+=" ";
        }
        return finAns.replaceAll("\\s+"," ").trim();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
