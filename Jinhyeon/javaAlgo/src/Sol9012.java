import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class Sol9012 {
	static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(
			new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Stack<Character> stack;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		String str;
		for (int i = 0; i < t; i++) {
			stack = new Stack<>();
			if (i == 2) {};
			str = br.readLine();
			isVPS(str);
			bw.newLine();
		}
		bw.flush();
	}
	
	static void isVPS(String st) throws IOException{
		for (char ch : st.toCharArray()) {
			if (ch == ('(')){
				stack.push(ch);
			}else if(!stack.isEmpty()){
				stack.pop();
			}else{
				bw.write("NO");
				return;
			}
		}
		if (stack.isEmpty()) {
			bw.write("YES");
		}else {
			bw.write("NO");
		}
	}
}
