/*
Week 1
Optional Enrichment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

These exercises from book "Computer Science: An Interdisciplinary Approach".
https://introcs.cs.princeton.edu/java/home/

1.2.34
Three-sort.
Write a program that takes three integer command-line arguments and prints
them in ascending order.
Use Math.min() and Math.max().
*/

/**
 * @author stasbutuzov
 * @version Feb 25, 2020
 */

public class ThreeSort {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = (a + b + c) - (max + min);

        System.out.println(min);
        System.out.println(mid);
        System.out.println(max);
    }
}
