import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. STRING t
     * 3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int count = 0;
        List<Character> s1 = new ArrayList<>();
        List<Character> t1 = new ArrayList<>();
        List<Character> temp = new ArrayList<>();

        for (char ch : s.toCharArray()) {

            s1.add(ch);
            //temp.add(ch);
        }
        for (char ch : t.toCharArray()) {

            t1.add(ch);
            // temp.add(ch);
        }
        int l1 = s1.size();
        int l2 = t1.size(); 
        
        for(int i=l1-1;i>-1; i--)
        {
            //System.out.println(s1);
            if(i==l2-1)
            {
                if(t1.equals(s1))
                {
                    //count=(t1.size()*2);
                    if(count<k)
                    {
                        return "Yes";
                    }
                }
                while(i>-1)
                {
                    if(t1.equals(s1))
                    {
                        //count=(t1.size()*2);
                        if(count<k)
                        {
                            return "Yes";
                        }
                        break;
                    }
                    else
                    {
                        count+=2;
                        s1.remove(i);
                        t1.remove(i);
                        i--;
                    }
                }
                break;
            }
            else{
                s1.remove(i);
                count++;
            }
        }
        System.out.println(s1);
        System.out.println(t1);
        System.out.println(count);

        //System.out.println(ptr);
        // s1=temp;
        // for (int i = s1.size() - 1; i > -1; i--) {
        //     for (int ptr = t1.size() - 1; ptr > -1; ptr--) {
        //         if (t1.equals(s1)) {
        //             System.out.println("Hello");
        //         }
        //         if (s1.get(i) != t1.get(ptr)) {
        //             s1.remove(i);
        //             count++;

        //             System.out.println(s1);
        //             System.out.println(t1);
        //             System.out.println(count);

        //             if (t1.equals(s1)) {
        //                 System.out.println("Hello");
        //             }
        //         }

        //     }
        //     s1 = temp;
        // }

        if (count == k) {
            return "Yes";
        } else {
            return "No";
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
