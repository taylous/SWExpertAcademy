import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
 
    static boolean[] primeNumber = new boolean[1000];
    static int Answer;
    static int N;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        init();
         
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
 
            N = Integer.parseInt(br.readLine());
             
            saesaemIwaThreePrimeNumber(N, 3, 2);
            sb.append("#");
            sb.append(test_case + 1);
            sb.append(" ");
            sb.append(Answer);
            sb.append("\n");
            Answer = 0;
        }
        System.out.println(sb.toString());
        br.close();
    }
 
    static void init() {
 
        int rootSqrt = (int) Math.sqrt(999);
 
        for (int i = 2; i <= rootSqrt; i++) {
             
            if (primeNumber[i])
                continue;
 
            for (int j = i + i; j <= 999; j += i)
                primeNumber[j] = true;
        }
    }
     
    static void saesaemIwaThreePrimeNumber(int value, int count, int idx) {
                 
        if(idx == N)
            return;
        if(count == 0 && value != 0)
            return;
        if(value == 0) {
             
            if(count == 0)
                Answer++;
            return;
        }
        if(value < idx)
            return;
 
        if(!primeNumber[idx])
            saesaemIwaThreePrimeNumber(value - idx, count - 1, idx);    
        saesaemIwaThreePrimeNumber(value, count, idx + 1);
    }
}