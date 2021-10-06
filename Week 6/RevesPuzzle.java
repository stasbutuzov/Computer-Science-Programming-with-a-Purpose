/*
Week 6
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/recursion/specification.php
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Oct 6, 2021
 */

public class RevesPuzzle {
    private static void hanoiThree(int n, int k, String from, String temp, String to) {
        if (n == k) {
            return;
        }
        hanoiThree(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoiThree(n - 1, k, temp, from, to);
    }

    private static void hanoiFour(int n, String from, String temp, String temp1, String to) {
        if (n == 0) {
            return;
        }
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        hanoiFour(k, from, to, temp1, temp);
        hanoiThree(n, k, from, temp1, to);
        hanoiFour(k, temp, from, temp1, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        hanoiFour(n, "A", "B", "C", "D");
    }
}
