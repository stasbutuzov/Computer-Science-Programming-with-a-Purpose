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

import java.awt.Color;

/**
 * @author stasbutuzov
 * @version Dec 9, 2021
 */

public class KernelFilter {

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {

        int width = picture.width();
        int height = picture.height();
        Picture resultPicture = new Picture(width, height);

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int center = weights.length / 2;
                double resultR = 0, resultG = 0, resultB = 0;
                for (int i = 0; i < weights.length; i++) {
                    for (int j = 0; j < weights.length; j++) {
                        double omegaKernel = weights[i][j];
                        Color color = picture.get((col + width + i - center) % width,
                                (row + height + j - center) % height);
                        int r = color.getRed(), g = color.getGreen(), b = color.getBlue();
                        resultR += r * omegaKernel;
                        resultG += g * omegaKernel;
                        resultB += b * omegaKernel;
                    }
                }
                int[] rgb = new int[3];
                rgb[0] = (int) Math.round(resultR);
                rgb[1] = (int) Math.round(resultG);
                rgb[2] = (int) Math.round(resultB);

                for (int i = 0; i < 3; i++) {
                    if (rgb[i] < 0) {
                        rgb[i] = 0;
                    } else if (rgb[i] > 255) {
                        rgb[i] = 255;
                    }
                }
                resultPicture.set(col, row, new Color(rgb[0], rgb[1], rgb[2]));
            }
        }
        return resultPicture;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1},
        };
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights.length; j++) {
                weights[i][j] = weights[i][j] / 16;
            }
        }
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0},
        };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1},
        };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = {
                {-2, -1, 0},
                {-1, 1, 1},
                {0, 1, 2},
        };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    weights[i][j] = (double) 1 / 9;
                } else {
                    weights[i][j] = 0;
                }
            }
        }
        return kernel(picture, weights);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        // Take the name of a file as a command-line argument.
        String file = args[0];
        // Create a picture by reading an source image from the file.
        Picture picture = new Picture(file);
        // Apply each filter to the picture and show results.
        identity(picture).show();
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();
    }
}
