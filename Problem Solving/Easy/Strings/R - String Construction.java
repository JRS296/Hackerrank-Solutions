//Trick Question, only really needed to know the number of unique terms, answer works nonetheless

//Final ANswer:

// public static int stringConstruction(String s) {
//     // Write your code here
//         int cost=0;
//         HashMap<Character, Integer> ans = new HashMap<>();
//         for(int i=0; i<s.length(); i++)
//         {
//             if(ans.containsKey(s.charAt(i)))
//             {
//                 continue;
//             }
//             else
//             {
//                 ans.put(s.charAt(i), i);
//                 cost+=1;
//             }
//         }
        
//         return cost;
//     }

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    /*
     * Complete the 'stringConstruction' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int stringConstruction(String s) {
    // Write your code here
        int cost = 0;
        int l = s.length();
        ArrayList<Character> t = new ArrayList<>();
        ArrayList<String> SUBS = new ArrayList<>();
        String temp = "";
        for (int i=0; i<l; i++)
        {
            t.add(s.charAt(i));
        }
        //System.out.println(t);
        
        for(int i=l-1; i>-1; i--)
        {
            int flag = 0;
            temp=s.substring(i,l);
            t.remove(i);
            String x = "";
            for(Character ch: t)
            {
                x+=ch;
            }
            //System.out.println(t+" "+temp+" "+x);
            SUBS = subStrings(temp);
            for(int j=0; j<SUBS.size(); j++)
            {
                //System.out.println(SUBS.get(j));
                if(x.equals(SUBS.get(j)))//make sure that temp = substring(s) of x
                {
                    //System.out.println(x+" "+SUBS.get(j)+ "lalalal");
                    flag=1;
                }
            }
            if(flag>0)
            {
                cost+=1;
                break;
            }
            else{
                    cost+=1; 
                }
            
        }   
        return cost;
    }
    
    public static ArrayList<String> subStrings(String str)
    {
        ArrayList<String> ans = new ArrayList<String>();
        int l = str.length();
        for(int i=0; i<l; i++)
        {
            String temp = "";
            for(int j=0; j<=i; j++)
            {
                temp+=str.charAt(j);
            }
            ans = printPermutn(temp);
        }
        return ans;
    }
    
    public static ArrayList<String> printPermutn(String str) {
    int len = str.length();
    int total = factorial(len);
    ArrayList<String> a = new ArrayList<String>();

    for (int number = 0; number < total; number++) {
      StringBuilder sb = new StringBuilder(str);
      int temp = number;

    String ans = "";
      for (int divisor = len; divisor >= 1; divisor--) {
        int q = temp / divisor;
        int r = temp % divisor;
    
        ans+=sb.charAt(r);
        sb.deleteCharAt(r);
        temp = q;
      }
      a.add(ans);
    }
    return a;
  }

  public static int factorial(int n) {
    int fact = 1;
    for (int i = 2; i <= n; i++) {
      fact *= i;
    }
    return fact;
  }


    // Figure out a way to return stuff from a recursion func - DONE
    
    // public static void printPermutn(String str, String ans, ArrayList<String> a)
    // {
 
    //     // If string is empty
    //     if (str.length() == 0) {
    //         a.add(ans);
    //         return;
    //     }
 
    //     for (int i = 0; i < str.length(); i++) {
 
    //         // ith character of str
    //         char ch = str.charAt(i);
 
    //         // Rest of the string after excluding
    //         // the ith character
    //         String ros = str.substring(0, i) +
    //                      str.substring(i + 1);
 
    //         // Recursive call
    //         printPermutn(ros, ans + ch,a);
    //     }
    // }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.stringConstruction(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
