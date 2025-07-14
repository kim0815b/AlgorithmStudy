import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[] left;
	static int[] right;
	static StringBuilder sb01;
	static StringBuilder sb02;
	static StringBuilder sb03;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb01 = new StringBuilder();
		sb02 = new StringBuilder();
		sb03 = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		left = new int[n];
		right = new int[n];
		
		Arrays.fill(left, -1);
		Arrays.fill(right, -1);
		
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			StringTokenizer st02 = new StringTokenizer(line);
			
			char[] ch = new char[3];
			
			for (int j = 0; j < 3 && st02.hasMoreTokens(); j++) {
			    ch[j] = st02.nextToken().charAt(0);  // 토큰에서 첫 글자만 가져옴
			}
			if (ch[1] != '.') {
				left[(int)ch[0]-65] = (int) ch[1] - 65; 
			}
			if (ch[2] != '.') {
				right[(int)ch[0]-65] = (int) ch[2] - 65; 
			}
		}
		dfs(0);
		
		bw.write(sb01.toString());
		bw.newLine();
		bw.write(sb02.toString());
		bw.newLine();
		bw.write(sb03.toString());
		bw.flush();
	}
	public static void dfs(int node) {
		if (node < 0) {
			return;
		}
		sb01.append((char)(node + 65));
		
		dfs(left[node]);
		
		sb02.append((char)(node + 65));
		
		dfs(right[node]);
		
		sb03.append((char)(node + 65));
	}
}
