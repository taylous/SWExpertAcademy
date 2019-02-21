import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int[] numbers;
    static int Answer;
     
    public static void main(String args[]) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        char[] container;
        int n;
 
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
 
            st = new StringTokenizer(br.readLine());
 
            container = st.nextToken().toCharArray();
            n = Integer.parseInt(st.nextToken());
 
            if(container.length == 2) {
            	
            	while(n-- > 0)
            		swap(0, 1);
            	
            	
            }
            else {
	            numbers = new int[container.length];
	            for (int i = 0; i < container.length; i++)
	                numbers[i] = container[i] - '0';
	 
	            maximumPrizeMoney(n, 0);
            }
            System.out.println("#"+(test_case + 1)+" "+Answer);
            Answer = 0;
        }
        br.close();
    }
 
    static void maximumPrizeMoney(int n, int idx) {
 
        if(n == 0) {
 
            int ret = 0;
            int offset = 0;
            for(int i = numbers.length - 1; i >= 0; i--)
                ret += numbers[i] * Math.pow(10, offset++);
            Answer = Math.max(Answer, ret);
            return;
        }
 
        for (int i = idx; i < numbers.length; i++) {
            for(int j = i; j < numbers.length; j++) {
 
                if(i == j)
                    continue;
 
//                System.out.println("IDX : " + idx + " n : " + n);
//                System.out.println("i : " + i + " j : " + j);
//                
                if(numbers[i] <= numbers[j]) {
 
                	System.out.println("\tIDX : " + idx + " i : " + i + " j : " + j + " n : " + n);
                	
                    swap(i, j);
                    maximumPrizeMoney(n - 1, i);
                    swap(j, i);
                }
            }
        }
    }
 
    static void swap(int a, int b) {
 
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}