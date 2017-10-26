/*
Max Rectangle in Binary Matrix 
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
*/

public class Solution {
	public int maximalRectangle(ArrayList<ArrayList<Integer>> list) {
	    int row = list.size();
		int col = list.get(0).size();
		int answer = getmaxAreaHistogram(list.get(0));
		for(int i=1 ; i<row ; i++){
			for(int j=0 ; j<col ; j++)
				if(list.get(i).get(j) == 1)
					list.get(i).set(j , list.get(i-1).get(j)+1);
			answer = Math.max(answer , getmaxAreaHistogram(list.get(i)));
		}
		return answer;
	}
	
	public int getmaxAreaHistogram(ArrayList<Integer> list){
		int n = list.size();
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(left, -1);
		Arrays.fill(right, n);
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0 ; i<n ; i++){
			while(!stack.isEmpty() && list.get(i) <= list.get(stack.peek()))
				stack.pop();
			if(!stack.empty())
				left[i] = stack.peek();
			stack.push(i);
		}
		stack.clear();

		for(int i=n-1 ; i>=0 ; i--){
			while(!stack.isEmpty() && list.get(i) <= list.get(stack.peek()))
				stack.pop();
			if(!stack.empty())
				right[i] = stack.peek();
			stack.push(i);
		}

		int ans=0;
		for(int i=0 ; i<n ; i++)
			ans = Math.max(ans , (right[i]-left[i]-1)*list.get(i));
		return ans;
	}
}
