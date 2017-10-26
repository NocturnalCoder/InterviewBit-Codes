/*
Edit Distance

Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.
*/

public class Solution {
	public int minDistance(String str1, String str2) {
	    int len1 = str1.length();
		int len2 = str2.length();
		if(str1.equals(str2))
			return 0;
		int[][] dp = new int[len1+1][len2+1];
		for(int i=0 ; i<=len1 ; i++){
			for(int j=0 ; j<=len2 ; j++){
				if(i==0 || j==0){
					dp[i][j] = Math.max(i,j);
					continue;
				}
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]) , dp[i-1][j-1]) + 1;
				}
			}
		}
		return dp[len1][len2];
	}
}