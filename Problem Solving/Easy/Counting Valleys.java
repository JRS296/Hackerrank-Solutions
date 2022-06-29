import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
        int seaLevel = 0, ans = 0;
        int ucounter = 0, dcounter = 0;
        boolean peak = false;
        if(path.length()!=steps)
        {
            System.out.println("Error");
            
        }
        else{
            for(int i=0; i<steps; i++)
            {
                if(path.charAt(i)=='U')
                {
                    /*ucounter++;
                    if(seaLevel==-2 && ucounter==2)
                    {
                        ans++;
                        ucounter=0;
                    }*/
                    seaLevel++;
                    if(seaLevel==0)
                    {
                        peak = false;
                    }
                    /*if(seaLevel==-1)
                    {
                        dcounter = 0;
                    }*/
                    
                }
                else if(path.charAt(i)=='D')
                {
                    
                    seaLevel--; 
                    /*if(seaLevel<0)
                    {
                        dcounter++;
                    }*/
                    if(seaLevel<0)
                    {
                        if(!peak)
                        {
                            ans++;
                            dcounter=0;
                            peak = true; 
                        }
                        
                    }
                    /*else if (seaLevel<=-2 && dcounter>=2)
                    {
                        dcounter = 0;
                    }*/
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

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
