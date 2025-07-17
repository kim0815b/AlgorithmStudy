import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol1546 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		// TODO Auto-generated method stub
		int n = Integer.parseInt(st.nextToken());
		int[] numbers = new int[n];
		String[] input = br.readLine().split(" ");
		float result;
		float sum = 0;
		int maxNum = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
			if (maxNum < numbers[i]) {
				maxNum = numbers[i];
			}
		}
		
		for(int num: numbers) {
			sum = sum + ((float)num / maxNum * 100); 
		}
		
		result = sum / n;
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
