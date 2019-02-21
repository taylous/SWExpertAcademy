import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String args[]) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[] sequence = null;
        int testCase;
        int idx;
         
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
             
        	testCase = Integer.parseInt(br.readLine());
            sequence = new int[101];
            
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                sequence[Integer.parseInt(st.nextToken())]++;
              
            idx = 0;
            for(int i=0; i<101; i++)
                if(sequence[i] >= sequence[idx]) 
                    idx = i;
            System.out.println("#" + testCase + " "  + idx);
        }
        br.close();
    }
}