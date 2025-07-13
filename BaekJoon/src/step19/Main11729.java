package step19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main11729 {
	
	static ArrayList<int[]> list = new ArrayList<int[]>();
	
	public static void main(String[] args) throws IOException{
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		int n = Integer.parseInt(br.readLine());
		
		move(n , 1 , 3 , 2); // n개의 하노이탑을 1~3으로 옮긴다 2를 거쳐서
		
		bw.write(list.size()+"\n");
		for(int[] k : list) {
			bw.write(k[0] +" " + k[1]+ "\n");
		}
		bw.close();//스트림을 닫음
		br.close();
	}

	private static void move(int n, int as, int to, int is) {
		// TODO Auto-generated method stub
		int[] moves = {as, to};
		if(n == 1) {
			list.add(moves);
			return;
		}
		move(n-1 , as , is, to); //n-1개의 탑을 as~is로 옮긴다 to를 거쳐서
		list.add(moves);
		move(n-1 , is , to, as); //n-1개의 탑을 is~to로 옮긴다 as를 거쳐서
	}
}
