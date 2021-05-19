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

public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        double r = 6371;

        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);

        double xsin = Math.sin((x2 - x1) / 2);
        double ysin = Math.sin((y2 - y1) / 2);
        double sqrt = Math.sqrt(xsin * xsin + Math.cos(x1) * Math.cos(x2) * ysin * ysin);
        double distance = 2 * r * Math.asin(sqrt);

        System.out.println(distance + " kilometers");
    }
}
