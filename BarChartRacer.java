public class BarChartRacer {
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);

        int width = 1000;
        int height = 700;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 10);
        StdDraw.enableDoubleBuffering();

        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String dataSource = in.readLine();

        BarChart chart = new BarChart(title, xAxisLabel, dataSource);

        while (!in.isEmpty()) {
            in.readLine(); // blank line
            String caption = in.readLine();
            int n = Integer.parseInt(in.readLine());
            Bar[] bars = new Bar[n];

            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                String[] parts = line.split(",");
                String name = parts[1];
                String category = parts[2];
                int value = Integer.parseInt(parts[3]);
                bars[i] = new Bar(name, value, category);
            }

            Arrays.sort(bars);
            chart.setCaption(caption);
            chart.reset();
            for (int i = n - 1; i >= n - 12; i--) {
                chart.add(bars[i]);
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}
