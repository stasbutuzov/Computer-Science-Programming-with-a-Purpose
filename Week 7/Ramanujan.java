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
 * @version Oct 15, 2021
 */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        if (n < 1729) {
            return false;
        }

        long a, b, c = 1, d = 1;
        int count = 0;

        for (int i = 1; i <= Math.round(Math.cbrt(n)); i++) {
            a = i;
            b = (long) Math.cbrt(n - (a * a * a));
            if ((a * a * a + b * b * b == n) && (a != b)) {
                count++;
                if (count == 1) {
                    c = a;
                    d = b;
                }
                if ((count == 2) && (c != a) && (c != b) && (d != a) && (d != b)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.print(isRamanujan(n));
    }
}
