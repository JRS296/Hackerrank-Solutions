import java.io.*;
import java.util.*;


class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        String[] arr_A = br.readLine().split(" ");
        for(int i_A = 0; i_A < N; i_A++) {
        	A[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        int out_ = Solve(N, A);
        System.out.println(out_);

         wr.close();
         br.close();
    }
    static int Solve(int N, int[] A){
        // Write your code here
        int a2 = -99999999, a1 = 9999999, ans = 0;
        boolean exists = false;
        for(int i=0; i<A.length; i++)
        {
            int x = A[i];
            if (x>=0)
            {
                if(x<a1)
                {
                    a1 = x;
                    exists = true;
                }
            }
            else
            {
                if(x>a2)
                {
                    a2 = x;
                }
            }
        }
        //System.out.println(a1);
        //System.out.println(a2);
        if (exists)
        {
            ans = a1;
        }
        else
        {
            ans = a2;
        }
        return ans;
    }
}