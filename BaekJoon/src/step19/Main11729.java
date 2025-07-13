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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//����
		int n = Integer.parseInt(br.readLine());
		
		move(n , 1 , 3 , 2); // n���� �ϳ���ž�� 1~3���� �ű�� 2�� ���ļ�
		
		bw.write(list.size()+"\n");
		for(int[] k : list) {
			bw.write(k[0] +" " + k[1]+ "\n");
		}
		bw.close();//��Ʈ���� ����
		br.close();
	}

	private static void move(int n, int as, int to, int is) {
		// TODO Auto-generated method stub
		int[] moves = {as, to};
		if(n == 1) {
			list.add(moves);
			return;
		}
		move(n-1 , as , is, to); //n-1���� ž�� as~is�� �ű�� to�� ���ļ�
		list.add(moves);
		move(n-1 , is , to, as); //n-1���� ž�� is~to�� �ű�� as�� ���ļ�
	}
}
