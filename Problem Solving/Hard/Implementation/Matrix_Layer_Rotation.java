//My Solution - Does not work for time
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     * 1. 2D_INTEGER_ARRAY matrix
     * 2. INTEGER r
     */

    public static void matrixRotation(ArrayList<ArrayList<Integer>> matrix, int r, int m, int n) {
        // Write your code here
        // defining x
        if (r == 0) {// || r%(2*m+((2*n) - 4))==0
            //System.out.println(matrix);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix.get(i).get(j)+" ");
                }
                System.out.println(" ");
            }
            //System.out.println(r);
        } else {
            int x = 0;
            if (m % 2 == 0 && n % 2 == 0) {
                if(m>n)
                {
                   x = n / 2; 
                }
                else
                {
                    x = m / 2;
                }
            } else {
                //x = (m + 1) / 4 + (n + 1) / 4;
                if(m>n)
                {
                   x = (n+1) / 2; 
                }
                else
                {
                    x = (m+1) / 2;
                }
            }
            //System.out.println(x);
            ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(m * n);
            for (int i = 0; i < m; i++) {
                arr.add(new ArrayList<Integer>());
                for (int j = 0; j < n; j++) {
                    arr.get(i).add(j, 0);
                }
            }
            // System.out.println(arr);

            int m1 = m;
            int n1 = n;
            // Starting Element
            for (int l = 0; l < x; l++) {
                // System.out.println(l);
                int i = l;
                int i1 = i;
                int j = l;
                int j1 = j;

                while (i < (m1 - 1)) {
                    i++;
                    arr.get(i).set(j, matrix.get(i1++).get(j1));
                }

                while (j < (n1 - 1)) {
                    j++;
                    arr.get(i).set(j, matrix.get(i1).get(j1++));
                }

                while (i > l) {
                    i--;
                    arr.get(i).set(j, matrix.get(i1--).get(j1));
                }

                while (j > l) {
                    j--;
                    arr.get(i).set(j, matrix.get(i1).get(j1--));
                }

                m1--;
                n1--;
            }
            // System.out.println(arr);
            // System.out.println(arr.get(0).get(0));
            matrixRotation(arr, --r, m, n); //Recursion
        }
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int BE = 0;
        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            ArrayList<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
                if (i == 0 || j == 0 || i == m - 1|| j == n - 1) {
                    BE += 1;
                }
            }

            matrix.add(matrixRowItems);
        }
        
        r = r%BE;
        //System.out.println(r);
        Result.matrixRotation(matrix, r, m, n);

        bufferedReader.close();
    }
}

/*
Given Solution:

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void matrixRotation(int[][] matrix, int m, int n, int r) {
        int layers = Math.min(m, n)/2;
        for(int l = 0; l < layers; l++) {
            int m_l = l+m-2*l;
            int n_l = l+n-2*l;
            int nbRotationsNeeded = (m_l-1-l)*2 + (n_l-1-l)*2;
            int boundedR = r % nbRotationsNeeded;
            if (boundedR == 0) continue;
            int rotationCount = 0;
            int i = l;
            int j = l;
            int current_first_i = i;
            int current_first_j = j;
            int current = matrix[i][j];
            while (rotationCount < nbRotationsNeeded) {
                int currentRotation = boundedR;
                while (currentRotation != 0) {
                    // go down
                    if (j == l && i<m_l-1) {
                        i++;
                    }
                    // go right
                    else if (i == m_l-1 && j<n_l-1) {
                        j++;
                    }
                    // go up
                    else if (j == n_l-1 && i>l) {
                        i--;
                    }
                    // go left
                    else if (i == l && j>l) {
                        j--;
                    }
                    currentRotation--;
                }
                int temp = matrix[i][j];
                matrix[i][j] = current;
                if (current_first_i == i && current_first_j == j) {
                    // go down
                    if (j == l && i<m_l-1) {
                        i++;
                    }
                    // go right
                    else if (i == m_l-1 && j<n_l-1) {
                        j++;
                    }
                    // go up
                    else if (j == n_l-1 && i>l) {
                        i--;
                    }
                    // go left
                    else if (i == l && j>l) {
                        j--;
                    }
                    current_first_i = i;
                    current_first_j = j;
                    temp = matrix[i][j];
                }
                current = temp;
                
               
                rotationCount++;
            }
        }
        
        // print
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        for(int matrix_i = 0; matrix_i < m; matrix_i++){
            for(int matrix_j = 0; matrix_j < n; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        matrixRotation(matrix, m, n, r);
        in.close();
    }
}

 
 */