import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
    // Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1; i<=p.size(); i++)
        {
            //int x = i;
            //System.out.println(i);
            for(int j=0; j<p.size(); j++)
            {
                //System.out.println(j+"-");
                if (i==p.get(p.get(j)-1))
                {
                    //System.out.println("***");
                    ans.add(j+1);
                    break;
                }
            }
        }
        return ans;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] pTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> p = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pTemp[i]);
            p.add(pItem);
        }

        List<Integer> result = Result.permutationEquation(p);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
