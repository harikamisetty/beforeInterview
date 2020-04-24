package com.hari.dsal.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	Queue<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
         
        int m = board.length;
        int n = board[0].length;
         
        for (int i = 0; i < n; i++) {
            solveHelper(0, i, m, n, board);
            solveHelper(m - 1, i, m, n, board);
        }
         
        for (int i = 1; i < m - 1; i++) {
            solveHelper(i, 0, m, n, board);
            solveHelper(i, n - 1, m, n, board);
        }
         
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
            }
        }
    }
     
    private void solveHelper(int row, int col, int m, int n, char[][] board) {
        fill(row, col, m, n, board);
         
        while (!queue.isEmpty()) {
            int cord = queue.poll();
            int x = cord / n;
            int y = cord % n;
             
            fill(x - 1, y, m, n, board);
            fill(x + 1, y, m, n, board);
            fill(x, y - 1, m, n, board);
            fill(x, y + 1, m, n, board);
        }
    }
     
    private void fill(int row, int col, int m, int n, char[][] board) {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') {
            return;
        } 
         
        board[row][col] = 'D';
         
        queue.offer(row * n + col);
    }

}
