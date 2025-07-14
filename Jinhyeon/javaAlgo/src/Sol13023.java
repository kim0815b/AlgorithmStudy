import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Sol13023 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Map<String, List<String>> graph = new HashMap<>();
	
	public static void main(String[] args) {
		String[] input = br.readLine().split();
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		for(int i; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			addEdge(a, b);
		}
		
	}
	static void dfs(String node, int depth) {
		
	}
	
	
	static void addEdge(String a, String b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
	}
}
