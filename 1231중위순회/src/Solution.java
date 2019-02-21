import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {
	
	char ch;
	int leftChild;
	int rightChild;
	
	Node(char ch, int leftChild, int rightChild) {
		
		this.ch = ch;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}

public class Solution {

	static HashMap<Integer, Node> tree = new HashMap<>();
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		StringBuilder sb;
		
		char ch;
		int no, leftChild, rightChild;
		
		for(int test_case = 0; test_case < 10; test_case++) {

			N = Integer.parseInt(br.readLine());
			
			while(N-- > 0) {
				
				st = new StringTokenizer(br.readLine());
				
				no = Integer.parseInt(st.nextToken());
				ch = st.nextToken().charAt(0);
				
				if(st.countTokens() == 2) {
					
					leftChild = Integer.parseInt(st.nextToken());
					rightChild = Integer.parseInt(st.nextToken());
				}
				else if(st.countTokens() == 1) {
					
					leftChild = Integer.parseInt(st.nextToken());
					rightChild = 0;
				}
				else {
					
					leftChild = rightChild = 0;
				}
				tree.put(no, new Node(ch, leftChild, rightChild));
			}
			sb = new StringBuilder();
			inorder(sb, 1);
			
			System.out.println("#"+(test_case+1)+" "+sb.toString());
			tree.clear();
		}
		br.close();
	}

	static void inorder(StringBuilder sb, int no) {
		
		Node node = tree.get(no);
		
		if(node == null)
			return;
		
		inorder(sb, node.leftChild);
		sb.append(node.ch);
		inorder(sb, node.rightChild);
	}
}
