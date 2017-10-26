/*
Min Sum Path in Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
*/

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> matrix) {
	    int n = matrix.size();
		if( n == 0)
			return 0;

		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE/2);
		dp[0] = matrix.get(0).get(0);

		for(int i=1 ; i<n ; i++){
			for(int j=i ; j>0 ; j--){
				dp[j] = Math.min(dp[j] , dp[j-1])+matrix.get(i).get(j);
			}
			dp[0] = dp[0] + matrix.get(i).get(0);
		}
		int min = dp[0];
		for(int i=1 ; i<n ; i++)
		    min = Math.min(min , dp[i]);
        return min;
	}
}