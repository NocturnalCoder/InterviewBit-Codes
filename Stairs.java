/*
Stairs 
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example :

Input : 3
Return : 3

Steps : [1 1 1], [1 2], [2 1]
*/

public class Solution {
	public int climbStairs(int n) {
	    if(n < 1)
	        return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int a=1,b=2,c=0;
        for(int i=3 ; i<=n ; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
	}
}
