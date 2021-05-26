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
 * @version May 25, 2021
 */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] field = new int[m][n];

        //generate cells containing mine uniformly at random
        while (k > 0) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);
            if (field[x][y] != -1) {
                field[x][y] = -1;
                k--;
            }
        }

        //count the number of neighboring mines (above, below, left, right, or diagonal)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] != -1) {
                    //loops for pick neighboring cells
                    for (int a = -1; a < 2; a++) {
                        for (int b = -1; b < 2; b++) {
                            if (i + a > -1 && j + b > -1 && i + a < m && j + b < n) {
                                if (field[i + a][j + b] == -1) {
                                    field[i][j]++;
                                }
                            }
                        }
                    }
                }
            }
        }

        //print resulting field
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == -1) {
                    System.out.print("*" + "  ");
                } else {
                    System.out.print(field[i][j] + "  ");
                }
            }
            System.out.println();
        }

    }
}
