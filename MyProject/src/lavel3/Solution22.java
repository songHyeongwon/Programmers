package lavel3;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/60059?language=java
public class Solution22 {
	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		System.out.println(new Solution22().solution(key, lock));
		
	}
	
	static int order;
    static int orderLength;
    static int lockLength;
    public boolean solution(int[][] key, int[][] lock) {
        order = key.length-1;
        orderLength = order * 2;
        lockLength = lock.length;

        for(int i =0; i < order + lock.length; i++) {
            for (int j = 0; j < order + lock.length; j++) {
                for (int k = 0; k < 4; k++) {//4개 방향 회전용
                    int[][] arr = new int[58][58];
                    for(int a =0; a < lock.length; a++) {
                        for (int b = 0; b < lock[a].length; b++) {
                            arr[order+a][order+b] = lock[a][b];
                        }
                    }
                    if(match(arr , key, i, j, k)) return true;
                }
            }
        }
        return false;
    }
    //키 누적
    private boolean match(int[][] arr, int[][] key, int i, int j, int k) {
        // TODO Auto-generated method stub
        int[][] newKey = getNewKey(key, k);

        for (int l = 0; l < newKey.length; l++) {
            for (int l2 = 0; l2 < newKey.length; l2++) {
                arr[i + l][ j + l2] += newKey[l][l2];
            }
        }
        return isCheck(arr);
    }
    //일치여부 확인
    private boolean isCheck(int[][] arr) {
        // TODO Auto-generated method stub
        for(int i =0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                if(arr[i+order][j+order] != 1) {
                    return false; 
                }
            }
        }
        return true;
    }
    //시계방향 회전
    private int[][] getNewKey(int[][] key, int type) {
        // TODO Auto-generated method stub
        int[][] result = new int[key.length][key.length];
        int n = key.length -1;
        for(int i =0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                switch(type) {
                case 0:
                    result[i][j] = key[i][j];
                    break;
                case 1:
                    result[i][j] = key[n- j][i];
                    break;
                case 2:
                    result[i][j] = key[n-i][n-j];
                    break;
                case 3:
                    result[i][j] = key[j][n- i];
                    break;
                }

            }
        }
        return result;
    }
    //디버깅 확인용
    public void printArr(int[][] arr) {
        for(int[] k : arr) {
            System.out.println(Arrays.toString(k));
        }
        System.out.println();
    }
}
