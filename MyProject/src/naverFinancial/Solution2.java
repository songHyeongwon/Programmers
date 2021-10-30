package naverFinancial;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution2().solution(5, 3)));
	}
	
	public int[] solution(int n, int jump) {
        int[] answer = null;
        
        Integer[] arr = new Integer[n*n];
        int num = 1;
        int idx = 0;
        while (num < n*n) {
        	arr[idx] = num++;
        	
        	int count = 0;
        	for (int i = idx + 1; count < jump; i++) {
				if(arr[i % (n*n)] == null) count++;
				if(count == jump) {
					idx = i % (n*n);
					break;
				}
			}
		}
        int find = 0;
        for (int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				find = i;
				break;
			}
		}
        answer = getAnswer(find+1 , n);
        
        return answer;
    }
	//달팽이 배열 찾기
	private int[] getAnswer(int find, int n) {
		// TODO Auto-generated method stub
		int[] result = new int[2];
		
		int[][] A = new int[n][n];

        // Filling data.
        int K = 1, f = 0;
        while(K <= n*n){
            // 1. 윗부분
            for(int j=f; j<n-f; j++){
                A[f][j] = K++;
            }

            // 2. 오른쪽 할당
            int k = f+1;
            for(int i=k; i<n-f; i++){
                A[i][n-f-1] = K++;
            }

            // 3. 아래 할당
            k = n-f-2;
            for(int j=k; j>=f; j--){
                A[n-f-1][j] = K++;
            }

            // 4. 왼쪽 할당
            k = n-f-2;
            for(int i=k; i>f; i--){
                A[i][f] = K++;
            }

            f+=1;
        }
        
        for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if(A[i][j] == find) {
					result[0] = i + 1;
					result[1] = j + 1;
					break;
				}
			}
		}
		return result;
	}
}
