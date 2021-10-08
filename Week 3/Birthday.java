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
        double fraction = 0;
        int sum = 0;

        for (int i = 0; i < trials; i++) {
            int people = 0;
            boolean[] hasBirthday = new boolean[n];
            while (people < n) {
                int birthday = (int) (Math.random() * n);
                people++;
                if (hasBirthday[birthday]) {
                    count[people - 1]++;
                    break;
                } else {
                    hasBirthday[birthday] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            sum += count[i - 1];
            fraction = (double) sum / trials;
            System.out.println(i + "\t" + count[i - 1] + "\t" + fraction);
            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
