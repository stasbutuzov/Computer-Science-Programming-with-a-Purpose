/*
Week 7
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/performance/specification.php
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Oct 17, 2021
 */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    // Algorithm was peeked here: https://leetcode.com/problems/maximal-square/solution/
    public static int size(int[][] a) {
        int[][] dpMatrix = new int[a[0].length + 1][a[0].length + 1];
        int maxSqLen = 0;
        for (int i = 1; i <= a[0].length; i++) {
            for (int j = 1; j <= a[0].length; j++) {
                if (a[i - 1][j - 1] == 1) {
                    dpMatrix[i][j] = Math.min(Math.min(dpMatrix[i][j - 1], dpMatrix[i - 1][j]), dpMatrix[i - 1][j - 1]) + 1;
                    maxSqLen = Math.max(maxSqLen, dpMatrix[i][j]);
                }
            }
        }
        return maxSqLen;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];

        while (!StdIn.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }
        StdOut.println(size(a));
    }
}
