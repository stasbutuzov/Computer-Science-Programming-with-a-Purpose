/*
Week 10
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/barchart/specification.php
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

import java.util.Arrays;

/**
 * @author stasbutuzov
 * @version Jan 2, 2022
 */

public class Bar implements Comparable<Bar> {
    private final String name, category;
    private final int value;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        this.name = name;
        this.category = category;
        this.value = value;

        if (name == null || value < 0 || category == null) {
            throw new IllegalArgumentException("Incorrect value: check you values");
        }
    }

    // Returns the name of this bar.
    public String getName() {
        return this.name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("Nothing to compare: Bar cannot be a null");
        }
        return (this.value - that.value);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
        for (Bar bar : bars) {
            StdOut.println(bar.getName() + " (" + bar.getCategory() + "): " + bar.getValue());
        }
    }
}
