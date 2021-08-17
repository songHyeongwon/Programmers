package lavel2;

public class Solution1 {
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		

		int[][] arr1 = {
				{1, 2, 3}, 
				{4, 5, 6}}; 
		int[][] arr2 = {
				{1, 4}, 
				{2, 5}, 
				{3, 6}};


		solution1.solution(arr1, arr2);
	}
	public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int temp = 0;
        System.out.println(answer.length);
        System.out.println(answer[0].length);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {

                for (int k = 0; k < arr1[0].length && k < arr2.length; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                    
                }//end for
                answer[i][j] = temp;
                System.out.print(answer[i][j] + ",");
                temp = 0;
            }//end for
            System.out.println();
        }//end for


        return answer;
    }
}
