/*
Week 4
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/io/specification.php
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Aug 10, 2021
 */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] x = new int[m + 1];
        int count = 0;
        double h = 0.0;
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            x[i] += 1;
            count += 1;
        }

        for (int i = 1; i <= m; i++) {
            double p = (double) x[i] / count;
            if (x[i] > 0) {
                h -= p * Math.log(p) / Math.log(2);
            }
        }
        StdOut.printf("%.4f\n", h);
    }
}
