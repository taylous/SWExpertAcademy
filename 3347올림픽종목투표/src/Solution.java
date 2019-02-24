import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Event implements Comparable<Event> {

	int number;
	int cost;
	int vote;

	Event(int number, int cost, int vote) {

	    this.number = number;
	    this.cost = cost;
	    this.vote = vote;
    }

	@Override
	public int compareTo(Event other) {
		return this.vote >= other.vote ? 1 : -1;
	}
}

public class Solution {

    static ArrayList<Event> event = new ArrayList<>();
    static int[] commissioner;

	static int N;
	static int M;

	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("3347올림픽종목투표\\sample_input.txt"));
        StringTokenizer st = null;


		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			System.out.print("#"+(test_case+1) + " ");

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			commissioner = new int[M + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++)
			    event.add(new Event(i, Integer.parseInt(st.nextToken()),0));

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++)
			    commissioner[i] = Integer.parseInt(st.nextToken());

			for(int k = 0; k < M; k++) {
                for (int i = 0; i < N; i++) {

                    if (commissioner[k] >= event.get(i).cost) {

                        event.get(i).vote++;
                        break;
                    }
                }
            }
            Collections.sort(event);
			Collections.reverse(event);

			System.out.println(event.get(0).number);
			event.clear();
		}
		
		br.close();
	}
}