/*
Week 5
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/functions/specification.php
FAQ:
https://coursera.cs.princeton.edu/introcs/assignments/functions/faq.php#
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Sep 21, 2021
 */

public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) {
            return 0;
        }

        int absA = Math.abs(a);
        int absB = Math.abs(b);

        while (absB != 0) {
            int temp = absA % absB;
            absA = absB;
            absB = temp;
        }
        return absA;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (gcd(a, b) == 0) {
            return 0;
        } else {
            return (Math.abs(a) * Math.abs(b)) / gcd(a, b);
        }
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = 1;
        for (int i = 2; i < n; i++) {
            if (gcd(i, n) == 1) {
                result++;
            }
        }
        return result;
    }

    // Takes two integer command-line arguments a and b and print each function
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ") = " + totient(a));
        StdOut.println("totient(" + b + ") = " + totient(b));
    }
}
