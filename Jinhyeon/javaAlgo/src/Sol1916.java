import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int to;
		int weight;
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class Node implements Comparable<Node>{
		int vertex;
		int dist;
		public Node(int vertex, int dist) {
			this.vertex = vertex;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
	}
	
	static int dijkstra(int n, int from, int to) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from, 0));

		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[from] = 0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if (current.dist > dist[current.vertex]) continue;
			for (Edge e : graph.get(current.vertex)) {
				if (dist[e.to] > current.dist + e.weight) {	
					dist[e.to] = e.weight+current.dist;
					pq.add(new Node(e.to, e.weight+current.dist));
				}
			}
		}
		return dist[to];
	}
	
	static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(
			new OutputStreamWriter(System.out));
	
	static List<List<Edge>> graph = new ArrayList<>();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Edge(to, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken()) - 1;
		int to = Integer.parseInt(st.nextToken()) - 1;
		int result = dijkstra(n, from, to);
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
