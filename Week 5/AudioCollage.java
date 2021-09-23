/*
Week 5
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/functions/specification.php
FAQ:
https://coursera.cs.princeton.edu/introcs/assignments/functions/faq.php#
Samlples of WAV files:
https://coursera.cs.princeton.edu/introcs/assignments/functions/files/
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Sep 23, 2021
 */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            double temp = a[a.length - i - 1];
            a[a.length - i - 1] = a[i];
            a[i] = temp;
        }
        return a;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] c;
        if (a.length > b.length) {
            c = new double[a.length];
            for (int i = 0; i < b.length; i++) {
                c[i] = b[i];
            }
            for (int i = 0; i < c.length; i++) {
                c[i] += a[i];
            }

        } else {
            c = new double[b.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i];
            }
            for (int i = 0; i < c.length; i++) {
                c[i] += b[i];
            }
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] b = new double[(int) (a.length / alpha)];
        for (int i = 0; i < a.length / alpha; i++) {
            b[i] = a[((int) (i * alpha))];
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double alpha = 1.5;
        double[] sample1 = StdAudio.read("piano.wav");
        double[] sample2 = StdAudio.read("cow.wav");
        double[] sample3 = StdAudio.read("dialup.wav");
        double[] sample4 = StdAudio.read("singer.wav");
        double[] sample5 = StdAudio.read("chimes.wav");

        StdAudio.play(amplify(sample2, alpha));
        StdAudio.play(reverse(sample5));
        StdAudio.play(merge(sample2, sample1));
        StdAudio.play(mix(sample1, sample4));
        StdAudio.play(changeSpeed(sample3, alpha));
    }
}
