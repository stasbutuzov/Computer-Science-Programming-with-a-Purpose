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
 * @version May 19, 2021
 */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] thuemorse = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                thuemorse[i] = 0;
            } else if (i % 2 != 0) {
                thuemorse[i] = 1 - thuemorse[i - 1];
            } else {
                thuemorse[i] = thuemorse[i / 2];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thuemorse[i] == thuemorse[j]) {
                    System.out.print("+" + "  ");
                } else {
                    System.out.print("-" + "  ");
                }
            }
            System.out.println();
        }
    }
}
