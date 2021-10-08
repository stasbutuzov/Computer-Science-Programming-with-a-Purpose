/*
Week 3
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/arrays/specification.php
*/

/**
 * @author stasbutuzov
 * @version Oct 7, 2021
 */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        boolean[][] mines = new boolean[m][n];
        boolean[][] board = new boolean[m + 2][n + 2];
        int[][] neighborhood = new int[m][n];

        // generate cells containing mine uniformly at random
        while (k > 0) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);
            if (!mines[x][y]) {
                mines[x][y] = true;
                k--;
            }
        }

        // place mines on board using extended array
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                board[i][j] = mines[i - 1][j - 1];
            }
        }

        // count the number of neighboring mines (above, below, left, right, or diagonal)
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!board[i][j]) {
                    // loops for pick neighboring cells
                    for (int a = -1; a <= 1; a++) {
                        for (int b = -1; b <= 1; b++) {
                            if (board[i + a][j + b]) {
                                neighborhood[i - 1][j - 1]++;
                            }
                        }
                    }
                }
            }
        }

        // print resulting field
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) {
                    System.out.print("*" + "  ");
                } else {
                    System.out.print(neighborhood[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
