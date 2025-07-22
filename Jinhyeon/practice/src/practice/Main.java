package practice;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		HashSet<Integer> hset = new HashSet<>();
		
		hset.add(999);
		hset.add(999);
		hset.add(999);
		hset.add(15);
		hset.add(10);
		hset.add(10);
		System.out.println(hset);
	}
}
