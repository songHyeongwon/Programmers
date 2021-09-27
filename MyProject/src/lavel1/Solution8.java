package lavel1;
//https://programmers.co.kr/learn/courses/30/lessons/86491
public class Solution8 {
	public static void main(String[] args) {
		int[][] arr = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		
		System.out.println(new Solution8().solution(arr));
	}
	
	public int solution(int[][] sizes) {
		//가장 큰 값인 max와 2개중에 작은값중 가장 큰값인 minMax
		int max = 0;
		int minMax = 0;
		
		for(int i =0; i< sizes.length; i++) {
			int sizesMax = Math.max(sizes[i][0], sizes[i][1]);
			int sizesMin = Math.min(sizes[i][0], sizes[i][1]);
			
			max = Math.max(max, sizesMax);
			minMax = Math.max(minMax, sizesMin);
		}
		
        return max*minMax;
    }
}
