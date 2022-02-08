package step20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2630 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] arr = null;
	static int wCnt = 0;//�Ͼ�� ����
	static int bCnt = 0;//�Ķ��� ����
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i< N; i++) {
			String s[] = br.readLine().split(" ");
			for(int j=0; j < N;j++) { 
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		fun(0,0,N);
		
		bw.write(wCnt+"\n"+bCnt);
		bw.flush();
		bw.close();
	}
	public static void fun(int startY, int startX , int n) {
		if(n==1) {//�ִ� �и���
			if(arr[startY][startX] == 1) bCnt++;
			else wCnt++;
			return;
		}
		//�ϳ��� �ٸ��� �ֳ� �˻�
		int rowSum = 0;
		for (int i = startY; i < startY + n; i++) {
			for (int j = startX; j < startX + n; j++) {
				rowSum += arr[i][j];
			}
		}
		//�Ͼ�� �Ķ����ϰ�� ��ȯ
		if(rowSum == 0) {
			wCnt++;
			return;
		} else if(rowSum == n*n) {
			bCnt++;
			return;
		}
		//1~4�и� ��� ����
		fun(startY , startX , n/2);
		fun(startY , startX + n/2 , n/2);
		fun(startY + n/2, startX , n/2);
		fun(startY + n/2, startX + n/2, n/2);
	}
}
