package com.hari.test.practice;

import java.util.Stack;

public class Matrix_DFS {

	int []dx = {0,1,0,-1};
	int []dy = {1,0,-1,0};

	private void DFS_matrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] b = new boolean[m][n];

		Stack<String> stack = new Stack<>();
		String item = 0+","+0;
		stack.push(item);

		while(!stack.empty()) {
			String element = stack.pop();
			int x = Integer.parseInt(element.split(",")[0]);
			int y = Integer.parseInt(element.split(",")[1]);

			if (x < 0 || y < 0 || x >= m || y >= n || b[x][y])
				continue;

			System.out.print(matrix[x][y]+ " ");
			b[x][y] = true;
			//insertIntoStack(stack,x,y,m,n,b);
			for (int i = 0; i < dx.length; i++) {
				int k = x + dx[i];
				int l = y + dy[i];
				stack.push(k + "," + l);
			}
		}
	}

	private void dfs_recurstion(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];

		dfs_recur_helper(matrix,0,0,m,n,visited);
	}


	private void dfs_recur_helper(int[][] matrix,int x,int y, int m, int n, boolean[][] visited) {

		if(x<0 || y <0 || x>=m || y >= n || visited[x][y])
			return;
		visited[x][y] = true;
		System.out.print(matrix[x][y] + " ");

		dfs_recur_helper(matrix, x+1, y, m, n, visited);
		dfs_recur_helper(matrix, x, y+1, m, n, visited);
		dfs_recur_helper(matrix, x, y-1, m, n, visited);
		dfs_recur_helper(matrix, x-1, y, m, n, visited);


	}

	public static void main(String[] args) {
		int[][] spiralMatrix = { { 1, 2, 3 },
								 { 4, 5, 6 },
								 { 7, 8, 9 } };
		Matrix_DFS md = new Matrix_DFS();
		md.DFS_matrix(spiralMatrix);
		System.out.println("\n");
		md.dfs_recurstion(spiralMatrix);
	}

}
