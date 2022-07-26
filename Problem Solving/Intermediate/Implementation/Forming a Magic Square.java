import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
        boolean ans = true;
        int sum_d1 = 0;
        int sum_d2 = 0;
        int sum_r[] = {0,0,0};
        int sum_c[] = {0,0,0};
        int cost = 0;
        ArrayList<Integer> check = new ArrayList<>();
        
        int arrex[][] = {{9, 5, 1},{7, 5, 3},{2, 5, 8},{4, 5, 6},{2, 9, 4},{6, 1, 8},{6, 7, 2},{8, 3, 4}};
        // ArrayList<ArrayList<Integer>> r1 = new ArrayList<ArrayList<Integer>>Arrays.asList({{0,0}, {0,1}, {0,2}});
        String r1[] = {"00", "01", "02"};
        String r2[] = {"10", "11", "12"};
        String r3[] = {"20", "21", "22"};
        
        String c1[] = {"00", "10", "20"};
        String c2[] = {"01", "11", "21"};
        String c3[] = {"20", "21", "22"};
        
        String d1[] = {"00", "11", "22"};
        String d2[] = {"02", "11", "20"};
        
        // while(ans)
        // {
            for(int i=0; i<s.size();i++)
            {
                
                for(int j=0; j<s.size(); j++)
                {
                //rows
                    sum_r[i]+=s.get(i).get(j);
                
                //columns
                    sum_c[i]+=s.get(j).get(i);
                
                //diagonals
                    if(i==j)
                    {
                        sum_d1 += s.get(i).get(j);
                    }
                    if ((i+j)==s.size()-1)
                    {
                        sum_d2 += s.get(i).get(j);
                    //System.out.println(s.get(i).get(j));
                    }
                } 
                //System.out.println(sum_r+"r");
                //System.out.println(sum_c+"c");
            }
            //System.out.println(sum_d1+"d1");
            //System.out.println(sum_d2+"d2"); 
            if(sum_d1==15 && sum_d2==15)// && sum_r==15 && sum_c==15
            {
                ans = false;
            }
            else{
                if(sum_d1!=15)
                {
                    check.add(0);
                    System.out.println("D1");
                }
                if(sum_d2!=15)
                {
                    check.add(1);
                    System.out.println("D2");
                }
                if(sum_r[0]!=15)
                {
                    check.add(2);
                    System.out.println("R1");
                }
                if(sum_r[1]!=15)
                {
                    check.add(3);
                    System.out.println("R2");
                }
                if(sum_r[2]!=15)
                {
                    check.add(4);
                    System.out.println("R3");
                }
                if(sum_c[0]!=15)
                {
                    check.add(5);
                    System.out.println("C1");
                }
                if(sum_c[1]!=15)
                {
                    check.add(6);
                    System.out.println("C2");
                }
                if(sum_c[2]!=15)
                {
                    check.add(7);
                    System.out.println("C3");
                }
                
                
                //Common Elements Within given arrays
                
                //Compare given arrays for common elements, and then add
            }
            
         
        // }
        
        System.out.println(check);
         
        return cost;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] sRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> sRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowTempItems[j]);
                sRowItems.add(sItem);
            }

            s.add(sRowItems);
        }

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
The 8 valid combinations of 3 numbers that add to 15 are:

9 5 1
7 5 3
2 5 8
4 5 6
2 9 4
6 1 8
6 7 2
8 3 4
All 8 of those combinations need to appear in the square as a row, column or diagonal. The centre cell must appear in the middle row, middle column and both diagonals. So it must be a number that appears four times, and the only digit that does is 5. So 5 must be the centre.

Similarly, each of the corner pieces must form part of a row, a column and a diagonal. So each corner cell must be a number that appears 3 times. Those are the even numbers 2, 4, 6 and 8. That means the diagonals must be "2 5 8" and "4 5 6"
*/

/*
All of the posted solutions require pre-computing all eight magic squares. I wanted to offer a few suggestions on how to generate them -- or at least show what I did.

We can start with two observations: a) the "middle" of any 3x3 magic square must be 5, and b) the "magic sum" must be 15.

Here's a way to think about the "magic sum". The sum of numbers 1-9 is 45. The three horizontal rows will include all 9 numbers (and thus sum to 45). And since there are three rows, each row will sum to 45/3 = 15.

It takes a bit of pen and paper to see that the middle must be 5 (or at least, it took me some trial and error). But once we know these two things, we can think in terms of the 4 "pairs" that can go on opposite sides of the 5:

1 and 9
2 and 8
3 and 7
4 and 6
So for example, if 4 goes Top/Left, we know that 6 must go Bottom/Right (since the "magic sum" must be 15, and 5 is in the middle)

A bit more on pen/paper will show that only two of these pairs fit in the "corners":

2 and 8
4 and 6
The other two pairs must be "wedged" inside the corner paris (e.g., top middle, bottom middle). And once we set our four corners, there is only 1 way to place the rest of the numbers.

This is enough to show that there are 8 magic matrices. There are 4 possible ways to place the 4 and 6 pair (the 4 could go in Top/Left, Top/Right, Bottom/Right, Bottom/Left). Then once we place the 4 and 6, there are two different ways we could place the 2 and 8.

To acutally generate these matrices, I started with one "seed" (which happend to be the first magic matrix I found):

[4 3 8]
[9 5 1]
[2 7 6]
From ths seed, we can rotate it clockwise 4 times (so the 4 appears in each corner). And then from each rotation, we can place the remaining digits either clockwise, or counterclockwise around the 5 (going counterclockwise is equivalent to getting the "mirror" of the matrix along a diagonal).

These two matrix manipulations are also great helper functions to have handy on other problems.
*/
