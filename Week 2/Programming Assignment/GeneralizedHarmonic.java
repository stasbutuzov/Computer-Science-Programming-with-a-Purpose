/*
Week 2
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/loops/specification.php
*/

/**
 * @author stasbutuzov
 * @version Mar 2, 2020
 */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double h = 0;
        for (int i = 1; i <= n; i++) {
            h += 1 / Math.pow(i, r);
        }
        System.out.println(h);
    }
}
