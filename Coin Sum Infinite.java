/*
Coin Sum Infinite
You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).

Example :

Input : 
	S = [1, 2, 3]  
	N = 4

Return : 4

Explanation : The 4 possible ways are
{1, 1, 1, 1}
{1, 1, 2}
{2, 2}
{1, 3}	
Note that the answer can overflow. So, give us the answer % 1000007
*/

public class Solution {
    public int coinchange2(ArrayList<Integer> set, int n) {
        if(n < 1)
			return 0;
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i=0 ; i<set.size() ; i++){
			for(int j=1 ; j<=n ; j++){
				if(j >= set.get(i))
					dp[j] += dp[j-set.get(i)];
					dp[j] = dp[j] % 1000007;
			}
		}
		return dp[n];
    }
}
