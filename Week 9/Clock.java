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
 * @version Dec 28, 2021
 */

public class Clock {
    private static final int MINUTES = 60;
    private static final int HOURS = 24;
    private int hours, minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        hours = h;
        minutes = m;

        if (hours < 0 || hours > HOURS - 1) {
            throw new IllegalArgumentException("Incorrect hours value: the hours must be between 0 and 23");
        }
        if (minutes < 0 || minutes > MINUTES - 1) {
            throw new IllegalArgumentException("Incorrect minutes value: the minute must be between 0 and 59");
        }
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.contains(":") || s.length() != 5) {
            throw new IllegalArgumentException("Incorrect time format: must be two digits, followed by a colon, followed by two digits");
        }

        hours = Integer.parseInt(s.substring(0, 2));
        minutes = Integer.parseInt(s.substring(3, 5));

        if (hours < 0 || hours > HOURS - 1) {
            throw new IllegalArgumentException("Incorrect hours value: the hours must be between 0 and 23");
        }
        if (minutes < 0 || minutes > MINUTES - 1) {
            throw new IllegalArgumentException("Incorrect minutes value: the minute must be between 0 and 59");
        }
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = Integer.toString(this.hours);
        String m = Integer.toString(this.minutes);

        if (h.length() == 1) {
            h = "0" + h;
        }
        if (m.length() == 1) {
            m = "0" + m;
        }
        return (h + ":" + m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return (this.hours < that.hours || (this.hours == that.hours && this.minutes < that.minutes));
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.minutes == MINUTES - 1 && this.hours == HOURS - 1) {
            this.hours = 0;
            this.minutes = 0;
        } else if (this.minutes == MINUTES - 1) {
            this.hours++;
            this.minutes = 0;
        } else {
            this.minutes++;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Incorrect value: delta cannot be negative");
        }

        int deltaM = delta % MINUTES;
        int deltaH = delta / MINUTES;

        if (this.minutes + deltaM >= MINUTES) {
            this.hours = (this.hours + deltaH + 1) % HOURS;
        } else {
            this.hours = (this.hours + deltaH) % HOURS;
        }

        this.minutes = (this.minutes + deltaM) % MINUTES;
    }

    // Test client (see below).
    public static void main(String[] args) {
        // Set and print two user's clock.
        Clock userTime1 = new Clock(7, 0);
        Clock userTime2 = new Clock("23:59");
        Clock userTime3 = new Clock(23, 15);
        Clock userTime4 = new Clock("01:59");

        StdOut.println("First time: " + userTime1);
        StdOut.println("Second time: " + userTime2);
        StdOut.println("Third time: " + userTime3);
        StdOut.println("Fourth time: " + userTime4 + "\n-----");

        // Check the time on userTime1 clock earlier than the time on userTime2 clock.
        StdOut.println("Is time " + userTime1 + " earlier than " + userTime2 + "?");
        StdOut.println("Answer: " + userTime1.isEarlierThan(userTime2) + "\n-----");

        // Check the time on userTime3 clock earlier than the time on userTime4 clock.
        StdOut.println("Is time " + userTime3 + " earlier than " + userTime4 + "?");
        StdOut.println("Answer: " + userTime3.isEarlierThan(userTime4) + "\n-----");

        // tic: Add one minute to the current time.
        userTime1.tic();
        userTime2.tic();
        StdOut.println("Add one minute to First time: " + userTime1);
        StdOut.println("Add one minute to Second time: " + userTime2 + "\n-----");

        // toc: Add Δ minutes to the current time.
        int delta = 134;
        userTime3.toc(delta);
        userTime4.toc(delta);
        StdOut.println("Add " + delta + " minutes to Third time: " + userTime3);
        StdOut.println("Add " + delta + " minutes to Fourth time: " + userTime4);
    }
}
