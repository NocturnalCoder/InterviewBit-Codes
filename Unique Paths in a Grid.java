/*
Unique Paths in a Grid 

Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

 Note: m and n will be at most 100. 
*/

public class Solution {
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> list) {
	    int row = list.size();
		int col = list.get(0).size();
		int[][] dp = new int[row][col];
		int i,j;
		for(i=0 ; i<row && list.get(i).get(0)==0; i++)
			dp[i][0] = 1;
		for(i=0 ; i<col && list.get(0).get(i)==0; i++)
			dp[0][i] = 1;
		for(i=1 ; i<row ; i++){
			for(j=1 ; j<col ; j++){
				if(list.get(i).get(j) == 0)
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[row-1][col-1];
	}
}
