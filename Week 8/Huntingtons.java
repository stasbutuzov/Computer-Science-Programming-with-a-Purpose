/*
Week 8
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/oop1/specification.php
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Nov 8, 2021
 */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int index = 0;
        int count = 0;
        int countConsRepeats = 0;

        while (index <= dna.length() - 3) {
            String codon = dna.substring(index, index + 3);
            if (codon.equals("CAG")) {
                count++;
                index += 3;
                if (count > countConsRepeats) {
                    countConsRepeats = count;
                }
            } else {
                count = 0;
                index += 1;
            }
        }
        return countConsRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\t", "");
        s = s.replace("\n", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10 || maxRepeats > 180) {
            return "not human";
        } else if (maxRepeats < 36) {
            return "normal";
        } else if (maxRepeats < 40) {
            return "high risk";
        } else {
            return "Huntington's";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // Take the name of a file as a command-line argument.
        String file = args[0];
        // Read the genetic sequence from the file using the In class.
        In read = new In(file);
        String sequence = read.readAll();
        // Remove any whitespace (spaces, tabs, and newlines).
        String clearSequence = removeWhitespace(sequence);
        // Count the number of CAG repeats.
        int repeats = maxRepeats(clearSequence);
        // Print a medical diagnosis.
        StdOut.println("max repeats = " + repeats);
        StdOut.println(diagnose(repeats) + "\n");
    }
}
