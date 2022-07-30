import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    //Trick question again, think logically - Palindrome implies that if even - two of each letter should occur, if odd, likewise, except for one character.
    public static String gameOfThrones(String s) {
    // Write your code here
        int l = s.length();
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
            for(int i=0; i<l; i++)
            {
                if(dict.containsKey(s.charAt(i)))
                {
                    char ch = s.charAt(i);
                    int x = dict.get(ch);
                    dict.put(ch, x+=1);
                }
                else
                {
                    dict.put(s.charAt(i), 1);
                }
            }
            System.out.println(dict);
        Collection<Integer> values = dict.values(); //Important, add to cheat sheet
        ArrayList<Integer> listOfValues = new ArrayList<Integer>(values);
        System.out.println(listOfValues);
        if(l%2==0)
        {   
            int count=0;
            
            for (int i=0; i<listOfValues.size(); i++)
            {
                if (listOfValues.get(i)%2==0)
                {
                    count+=1;
                }
            }
            if(count==listOfValues.size())
            {
                return "YES";
            }
        }
        else
        {
            int count=0;
            int ind = 0;
            for (int i=0; i<listOfValues.size(); i++)
            {
                if (listOfValues.get(i)==1 || listOfValues.get(i)%2!=0)
                {
                    ind = i;
                }
            }
            for (int i=0; i<listOfValues.size(); i++)
            {
                if (i==ind)
                {
                    continue;
                }
                if (listOfValues.get(i)%2==0)
                {
                    count+=1;
                }
            }
            if(count==listOfValues.size()-1)
            {
                return "YES";
            }
        }
        return "NO";
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
