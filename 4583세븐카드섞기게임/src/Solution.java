import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] sequence = { 0, 1, 2, 3, 4, 5, 6 };

    static int[] left;
    static int[] right;

	static int M;
	static long K;
	
	public static void main(String args[]) throws Exception	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("4583세븐카드섞기게임\\sample_input.txt"));
        StringTokenizer st;
        long remain = 0, count = 0;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

		    st = new StringTokenizer(br.readLine(), " ");

		    M = Integer.parseInt(st.nextToken());
		    K = Long.parseLong(st.nextToken());

		    left = new int[M];
		    right = new int[M];

		    for(int i = 0; i < M; i++) {

		        st = new StringTokenizer(br.readLine(), " ");

		        left[i] = Integer.parseInt(st.nextToken()) - 1;
		        right[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            if(K > 100000) {
                while (true) {

                    if (K <= 100)
                        break;

                    remain += K % 12;
                    K /= 12;
                }

                while(count != remain) {

                    for(int j = 0; j < M; j++) {

                        int t = sequence[left[j]];
                        sequence[left[j]] = sequence[right[j]];
                        sequence[right[j]] = t;
                    }
                    count++;
                }

            }
            else {

                while(count != K) {

                    for(int j = 0; j < M; j++) {

                        int t = sequence[left[j]];
                        sequence[left[j]] = sequence[right[j]];
                        sequence[right[j]] = t;
                        count++;

                        if(count == K)
                            break;
                    }
                }
            }

            System.out.print("#"+(test_case+1) + " ");
            for(int data : sequence)
                System.out.print(data);
            System.out.println();

            sequence = new int[]{ 0, 1, 2, 3, 4, 5, 6 };
            remain = count = 0;
		}
		br.close();
	}
}