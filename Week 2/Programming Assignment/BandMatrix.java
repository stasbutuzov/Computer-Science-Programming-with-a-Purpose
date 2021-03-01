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

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(j - i) <= width) {
                    System.out.print("*  ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
    }
}
