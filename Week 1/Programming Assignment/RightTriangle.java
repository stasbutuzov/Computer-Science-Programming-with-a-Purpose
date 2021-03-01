/*
Week 1
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/hello/specification.php
*/

/**
 * @author stasbutuzov
 * @version Feb 24, 2020
 */

public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean isRightTriangle;

        isRightTriangle = (a > 0 && b > 0 && c > 0)
                && (c * c == a * a + b * b || a * a == b * b + c * c || b * b == a * a + c * c);
        System.out.println(isRightTriangle);
    }
}
