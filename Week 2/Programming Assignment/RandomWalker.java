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

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        int x = 0;
        int y = 0;
        double n;

        while ((Math.abs(x) + Math.abs(y)) != r) {
            steps++;
            System.out.println("(" + x + ", " + y + ")");
            n = Math.random();
            if (n < 0.25)
                x++;
            else if (n < 0.5)
                x--;
            else if (n < 0.75)
                y++;
            else if (n < 1)
                y--;
        }
        System.out.println("(" + x + ", " + y + ")");
        System.out.println("steps = " + steps);
    }
}
