import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Sol13023 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<List<Integer>> graph = new ArrayList<>();
	static int result;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
	    for (int i = 0; i < n; i++) {
	    	graph.add(new ArrayList<>());
	    }
		for(int i=0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			addEdge(a, b);
		}
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			if (result != 1) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
	}
	
	static void dfs(int node, int depth) {
		if (depth > 4) {
			result = 1;
			return;
		}
		for(int n: graph.get(node)) {
			if (!visited[n]){
				visited[n] = true;
				dfs(n, depth + 1);
				visited[n] = false;
			}
		}
	}
	
	
	static void addEdge(int a, int b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
	}
}
