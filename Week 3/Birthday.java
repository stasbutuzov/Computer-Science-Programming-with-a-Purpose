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
 * @version May 20, 2021
 */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] count = new int[n + 2];

        for (int i = 0; i < trials; i++) {
            int people = 1;
            boolean[] hasBirthday = new boolean[n];
            boolean found = false;
            while (!found) {
                int birthday = (int) (Math.random() * n);
                if (hasBirthday[birthday]) {
                    count[people]++;
                    found = true;
                } else {
                    hasBirthday[birthday] = true;
                    people++;
                }
            }
        }

        int i = 1;
        int sum = 0;
        double fraction = 0;
        while (fraction < 0.5) {
            sum += count[i];
            fraction = (double) sum / trials;
            System.out.println(i + "\t" + count[i] + "\t" + fraction);
            i++;
        }
    }
}
