import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sol1406 {
	
	static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(
			new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static class Node{
		Node prev;
		Node next;
		String data;
		Node (String data){
			this.data = data;
		}
	}
	
	static class DoublyLinkedList {
		Node head;
		Node tail;
		
		Node addFront(Node cursor, Node target) {
			// 평소에 addFront로 삽입
			if (head == cursor) {
				head = target;
				target.prev = cursor;
				cursor.next = target;					
				return cursor;
			}
			return cursor;
		}
		Node addBack(Node cursor, Node target) {
			// tail에서 오른쪽 커서로 이동했을때 addBack
			if (tail == cursor) {
				tail = target;
				target.next = cursor;
				cursor.prev = target;
				return target;
			}
			return target;
		}
	}
	public static void main(String[] args) throws IOException{
		DoublyLinkedList dll = new DoublyLinkedList();
		st = new StringTokenizer(br.readLine());
		Node cursor = null;
		while (st.hasMoreTokens()) {
			Node node = new Node(st.nextToken());
			if(dll.head == null) {
				node.next = node;
				node.prev = node;
				dll.head = node;
				dll.tail = node;	//처음에 head의 next, prev이 생김
				cursor = node;
			}else {
				cursor = dll.addBack(cursor, node);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch (s) {
				case "L":
					if (cursor.next != null) {
						cursor = cursor.next;
					}
					break;
				case "D":
					if (cursor.prev!= null) {
						cursor = cursor.prev;
					}
					break;
				case "B":
					break;
				case "P":
					break;
			}
			
		}
	}
}
