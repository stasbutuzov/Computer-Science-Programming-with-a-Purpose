/*
Week 3
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/arrays/specification.php
*/

/**
 * @author stasbutuzov
 * @version May 17, 2021
 */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length;
        int[] a = new int[n];
        int[] s = new int[n];

        for (int i = 1; i < n; i++) {
            a[i] = Integer.parseInt(args[i]);
            s[i] = s[i - 1] + a[i];
        }

        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * (s[n - 1]));
            int index = 0;
            while (s[index] <= r) {
                index++;
            }
            System.out.print(index + " ");
        }
    }
}
