import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static final int SEQUENCE_SIZE = 7;

    static ArrayList<int[]> shuffle = new ArrayList<>();
    static int[] sequence = new int[SEQUENCE_SIZE];

    static int M;
    static long K;

	public static void main(String[] args) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("4583세븐카드섞기게임//sample_input.txt"));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {

		    initiate();

		    st = new StringTokenizer(br.readLine());

		    M = Integer.parseInt(st.nextToken());
		    K = Long.parseLong(st.nextToken());

		    for(int i = 0; i < M; i++) {

		        st = new StringTokenizer(br.readLine());
                shuffle.add(new int[]{ Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1 });
            }
		    calculate();

		    sb.append("#");
		    sb.append(test_case);
            sb.append(" ");
		    for(int value : sequence)
		        sb.append(value);
		    sb.append("\n");

		    shuffle.clear();
		}
        System.out.println(sb.toString());
		br.close();
	}

	static void initiate() {

        for(int i = 0; i < SEQUENCE_SIZE; i++)
            sequence[i] = i;
    }

	static void swap(int i, int j) {

	    int t = sequence[i];
	    sequence[i] = sequence[j];
	    sequence[j] = t;
    }

	static boolean checkSequence() {

	    for(int i = 0; i < SEQUENCE_SIZE; i++) {

	        if(sequence[i] != i)
	            return false;
        }
	    return true;
    }

	static void calculate() {

	    long ret = 0;
	    int order = 0;

        while(ret < K) {

            swap(shuffle.get(order)[0], shuffle.get(order++)[1]);
            ret++;

            if(order == M) {

                if(checkSequence()) {
                    K %= ret;
                    ret = 0;
                }
                order = 0;
            }
        }
    }
}