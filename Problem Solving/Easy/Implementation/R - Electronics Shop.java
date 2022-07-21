import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Solution {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        for (int i = 0; i < keyboards.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < keyboards.length; j++) {
                // Checking elements
                int temp = 0;
                if (keyboards[j] < keyboards[i]) {
                    temp = keyboards[i];
                    keyboards[i] = keyboards[j];
                    keyboards[j] = temp;
                }
            }
        }
        for (int i = 0; i < drives.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < drives.length; j++) {
                // Checking elements
                int temp = 0;
                if (drives[j] < drives[i]) {
                    temp = drives[i];
                    drives[i] = drives[j];
                    drives[j] = temp;
                }
            }
        }
        
        int ans = 0;
         boolean flag = false;
         int count = 0;
         for (int i=0; i<keyboards.length; i++)
         {
             int temp = 0;
             for (int j=0; j<drives.length; j++)
             {
                temp += (keyboards[i]+drives[j]);
                if(temp>ans && temp<b)
                {
                    ans = temp;
                    System.out.println(ans);
                    //count++;
                }
                else{
                    continue;
                }

                //System.out.println(count);
             }
         }
        //System.out.println(count);
        System.out.println(ans);
        
        if (ans==0)
            return -1;
        else
            return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
