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

public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (x < 0) {
            return 0;
        } else if (x == 0) {
            return 0.5;
        } else if (Double.isNaN(x)) {
            return Double.NaN;
        }
        return 1;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        } else {
            return 1 / (1 + Math.pow(Math.E, (x * -1)));
        }
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        } else if (x >= 20) {
            return 1;
        } else if (x <= -20) {
            return -1;
        } else {
            return (Math.pow(Math.E, (x * 2)) - 1) / (Math.pow(Math.E, (x * 2)) + 1);
        }
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return 1;
        } else if (x == Double.NEGATIVE_INFINITY) {
            return -1;
        } else {
            return x / (1 + Math.abs(x));
        }
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (x <= -2) {
            return -1;
        } else if ((x > -2) && (x < 0)) {
            return x + (Math.pow(x, 2) / 4);
        } else if ((x >= 0) && (x < 2)) {
            return x - (Math.pow(x, 2) / 4);
        } else if (Double.isNaN(x)) {
            return Double.NaN;
        }
        return 1;
    }

    // Takes a double command-line argument x and prints each activation function
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);

        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("tanh(" + x + ") = " + tanh(x));
        StdOut.println("softsign(" + x + ") = " + softsign(x));
        StdOut.println("sqnl(" + x + ") = " + sqnl(x));
    }
}
