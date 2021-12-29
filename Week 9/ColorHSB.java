/*
Week 9
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/oop2/specification.php
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Dec 14, 2021
 */

public class ColorHSB {
    private static final int DEGREE = 360;
    private final int hue, sat, bright;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        hue = h;
        sat = s;
        bright = b;

        if (hue < 0 || hue >= DEGREE) {
            throw new IllegalArgumentException("Incorrect value: the hue must be between 0 and 359");
        }
        if (sat < 0 || sat > 100) {
            throw new IllegalArgumentException("Incorrect value: the saturation must be between 0 and 100");
        }
        if (bright < 0 || bright > 100) {
            throw new IllegalArgumentException("Incorrect value: the bright must be between 0 and 100");
        }
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bright + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return sat == 0 || bright == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("The input is null!");
        }

        int h = this.hue - that.hue;
        int s = this.sat - that.sat;
        int b = this.bright - that.bright;

        return Math.min(h * h, (DEGREE - Math.abs(h)) * (DEGREE - Math.abs(h))) + (s * s) + (b * b);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // Take a color represents by integer command-line arguments.
        int h1 = Integer.parseInt(args[0]);
        int s1 = Integer.parseInt(args[1]);
        int b1 = Integer.parseInt(args[2]);
        ColorHSB inputColor = new ColorHSB(h1, s1, b1);
        ColorHSB nearestColor = inputColor;
        String nearestColorName = "";
        int minDist = Integer.MAX_VALUE;

        // Read the data file of pre-defined colors from standard input.
        while (!StdIn.isEmpty()) {
            String colorNameFromFile = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
            ColorHSB colorFromFile = new ColorHSB(h2, s2, b2);

            if (inputColor.distanceSquaredTo(colorFromFile) < minDist) {
                minDist = inputColor.distanceSquaredTo(colorFromFile);
                nearestColorName = colorNameFromFile;
                nearestColor = colorFromFile;
            }
        }
        StdOut.println(nearestColorName + " " + nearestColor + "\n");
    }
}
