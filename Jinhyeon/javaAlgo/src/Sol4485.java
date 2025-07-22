import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol4485 {
	static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(
			new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dist;
		
		Node(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	static int dijkstra(int n, int[][] cave) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[][] dist = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = cave[0][0];
		pq.add(new Node(0, 0, cave[0][0]));
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while (!pq.isEmpty()) {
			Node current = pq.remove();
			int x = current.x;
			int y = current.y;
			if (current.dist > dist[x][y]) continue;
			for (int i = 0; i < 4; i ++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx <= n-1 && 0 <= ny && ny <= n-1 ) {
					if (dist[nx][ny] > current.dist + cave[nx][ny]) {
						dist[nx][ny] = current.dist + cave[nx][ny]; //
						pq.add(new Node(nx, ny, current.dist + cave[nx][ny]));
					}
				}
				
			}
		}
		return dist[n-1][n-1];
	}
	
	public static void main(String[] args) throws IOException{
		int k = 0;
		while (true) {
			k++;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n != 0) {
				int[][] cave = new int[n][n];
				for (int i = 0; i < n; i ++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < n; j++) {
						cave[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				int minWeight= dijkstra(n, cave);

				bw.write(String.format("Problem %d: %d", k, minWeight));
			}else {
				break;
			}
			bw.newLine();
		}
		bw.flush();
	}
}
