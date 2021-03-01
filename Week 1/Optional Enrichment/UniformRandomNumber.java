/*
Week 1
Optional Enrichment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

These exercises from book "Computer Science: An Interdisciplinary Approach".
https://introcs.cs.princeton.edu/java/home/

1.2.30
Uniform random numbers.
Write a program that prints five uniform random numbers between 0 and 1,
their average value, and their minimum and maximum values.
Use Math.random(), Math.min(), and Math.max().
*/

/**
 * @author stasbutuzov
 * @version Feb 25, 2020
 */

public class UniformRandomNumber {
    public static void main(String[] args) {
        double a = Math.random();
        double b = Math.random();
        double c = Math.random();
        double d = Math.random();
        double e = Math.random();

        double avg = (a + b + c + d + e) / 5;
        double min = Math.min(a, Math.min(Math.min(b, c), Math.min(d, e)));
        double max = Math.max(a, Math.max(Math.max(b, c), Math.max(d, e)));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        System.out.println("Average value is: " + avg);
        System.out.println("Minimum value is: " + min);
        System.out.println("Maximum value is: " + max);
    }
}
