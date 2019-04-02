import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static long[][] color;
	
	static int A;
	static int B;
	static int C;
	
	static int X;
	static int Y;
	static int Z;
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			Z = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			color = new long[3][N];
			
            for(int i = A; i < X; i++)
                color[0][(i - A) % N]++;
            for(int i = A - 1; i >= 0; i--)
            	color[0][(A - i) % N]++;
            
            coloringCube(1, Y, B);
            coloringCube(2, Z, C);
            
            bw.write("#"+(test_case+1)+" ");
            for(int i = 0; i < N; i++)
            	bw.write(color[2][i] + " ");
            bw.write("\n");
		}
		bw.close();
		br.close();
	}
	
	static void coloringCube(int idx, int offset, int criteria) {
	
		long sum = 0;
		long quotient = (offset - 1 - criteria) / N;
		long remain = (offset - 1 - criteria) % N;
		
		for(int i = 0; i < N; i++)
			sum += color[idx - 1][i];
		
		for(int i = 0; i < N; i++)
			color[idx][i] = (sum * quotient) + color[idx - 1][i];
		
		for(int i = 1; i <= remain; i++) {
			for(int j = 0; j < N; j++)
				color[idx][(i + j) % N] += color[idx - 1][j];
		}
		quotient = criteria / N;
		remain = criteria % N;
		
		for(int i = 0; i < N; i++)
			color[idx][i] += (sum * quotient);
		
		for(int i = 1; i <= remain; i++) {
			for(int j = 0; j < N; j++)
				color[idx][(i + j) % N] += color[idx - 1][j];
		}
	}
}