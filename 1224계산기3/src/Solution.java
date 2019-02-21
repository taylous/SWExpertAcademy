import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static Stack<Integer> operand = new Stack<>();
	static Stack<Character> operator = new Stack<>();
	
	static int Answer;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		char[] sequence;
		char ch;
		
		for(int test_case = 0; test_case < 10; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			sequence = br.readLine().toCharArray();
					
			for(int i = 0; i < sequence.length; i++) {
				
				switch(sequence[i]) {
				
				case '(':
					
					operator.push(sequence[i]);
					break;
					
				case ')':
					
					while(true) {
						
						ch = operator.pop();
						
						if(ch == '(')
							break;
						
						if(ch == '+')
							operand.push(operand.pop() + operand.pop());
						else
							operand.push(operand.pop() * operand.pop());
					}
					break;
					
				case '+':
					
					if(!operator.isEmpty() && operator.peek() == '*') {
						
						while(true) {
						
							if(operator.peek() != '*')
								break;
							
							operand.push(operand.pop() * operand.pop());
							operator.pop();
						}
					}
					operator.push(sequence[i]);
					break;
					
				case '*':
					
					operator.push(sequence[i]);
					break;
					
				default:
					
					operand.push(sequence[i] - '0');
					break;
				}
			}
			while(!operator.isEmpty())
				if(operator.pop() == '+')
					operand.push(operand.pop() + operand.pop());
				else
					operand.push(operand.pop() * operand.pop());
			
			System.out.println("#"+(test_case+1)+" "+operand.pop());
		}
		br.close();
	}

}
