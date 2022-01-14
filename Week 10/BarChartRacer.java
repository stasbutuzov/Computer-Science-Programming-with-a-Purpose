/*
Week 10
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/barchart/specification.php
Samples of data files:
https://coursera.cs.princeton.edu/introcs/assignments/functions/files/
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
The class represents a library for drawing static bar chart:
https://coursera.cs.princeton.edu/introcs/assignments/barchart/files/BarChart.java
*/

import java.util.Arrays;

/**
 * @author stasbutuzov
 * @version Jan 13, 2022
 */

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String file = args[0];
        int k = Integer.parseInt(args[1]);
        In input = new In(file);

        String title = input.readLine();
        String xAxis = input.readLine();
        String source = input.readLine();
        input.readLine();
        BarChart chart = new BarChart(title, xAxis, source);

        while (input.hasNextLine()) {
            int lines = Integer.parseInt(input.readLine());
            Bar[] bars = new Bar[lines];

            String caption = "";
            for (int i = 0; i < lines; i++) {
                String[] record = input.readLine().split(",");
                caption = record[0];
                String name = record[1];
                int value = Integer.parseInt(record[3]);
                String category = record[4];
                bars[i] = new Bar(name, value, category);
            }

            Arrays.sort(bars);
            chart.setCaption(caption);
            for (int i = bars.length - 1; i > bars.length - k - 1; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
            input.readLine();
        }
        chart.reset();
    }
}
