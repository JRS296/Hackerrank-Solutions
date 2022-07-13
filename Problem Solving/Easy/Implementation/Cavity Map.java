import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
    // Write your code here
        //System.out.println(grid);
        ArrayList<ArrayList<Character>> g2 = new ArrayList<ArrayList<Character>>();
        ArrayList<String> ans = new ArrayList<String>();
        for(int i=0; i<grid.size(); i++)
        {
            g2.add(new ArrayList<Character>(grid.size()));
            String s = String.valueOf(grid.get(i));
            for(int j=0; j<grid.size(); j++)
            {
                g2.get(i).add(j,s.charAt(j));
            }
        }
        for(int i=0; i<g2.size(); i++)
        {
            String s = "";
            for(int j=0; j<g2.size(); j++)
            {
                if(i==0 | j==0 | i==g2.size()-1 | j==g2.size()-1)
                {
                    s+=g2.get(i).get(j);
                }
                else{
                    int x = g2.get(i).get(j);
                    if(x>g2.get(i-1).get(j) && x>g2.get(i+1).get(j) && x>g2.get(i).get(j-1) && x>g2.get(i).get(j+1))
                    {
                        s+='X';
                    }
                    else
                    {
                        s+=g2.get(i).get(j);
                    }
                }
            }
            ans.add(s);
        }    
        
        System.out.println(g2);
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        List<String> result = Result.cavityMap(grid);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
