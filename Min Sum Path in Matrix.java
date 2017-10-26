/* 
Min Sum Path in Matrix

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time. 
Example :

Input : 

    [  1 3 2
       4 3 1
       5 6 1
    ]

Output : 8
     1 -> 3 -> 2 -> 1 -> 1
*/

public class Solution {
	public int minPathSum(ArrayList<ArrayList<Integer>> matrix) {
	    int row = matrix.size();
		if(row == 0)	return 0;
		int col = matrix.get(0).size();

		int[][] dp = new int[row][col];
		dp[0][0] = matrix.get(0).get(0);
		for(int i=1 ; i<col ; i++)
			dp[0][i] = dp[0][i-1]+matrix.get(0).get(i);
		for(int i=1 ; i<row ; i++)
			dp[i][0] = dp[i-1][0]+matrix.get(i).get(0);

		for(int i=1 ; i<row ; i++){
			for(int j=1 ; j<col ; j++){
				dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + matrix.get(i).get(j);
			}
		}
		return dp[row-1][col-1];
	}
}
