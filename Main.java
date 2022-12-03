import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Point p1 = readPoint("p1");
        Point p2 = readPoint("p2");
        Point p3 = readPoint("p3");

        System.out.println(biggerA(p1, p2, p3));
        double a = distance(p1, p2);
        double b = distance(p1, p3);

        if (a > b) {
            Point bA = biggerA(p1, p2, p3);
            System.out.println(bA.x);
            System.out.println(bA.y);

        } else if (a < b) {
            Point bB = biggerB(p1, p2, p3);
            System.out.println(bB.x);
            System.out.println(bB.y);
        } else {
            Point bC = equality(p1, p2, p3);
            System.out.println(bC.x);
            System.out.println(bC.y);
        }
    }

    public static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Point readPoint(String pointName) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите %s.x = ", pointName);
        double x = scanner.nextDouble();
        System.out.printf("Введите %s.y = ", pointName);
        double y = scanner.nextDouble();

        return new Point(x, y);
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));

    }

    public static Point biggerA(Point p1, Point p2, Point p3) {
        double x0 = (p1.x + p2.x) / 2;
        double y0 = (p1.y + p2.y) / 2;
        double p4xa = x0 * 2 - p3.x;
        double p4ya = y0 * 2 - p3.y;
        return new Point(p4xa, p4ya);
    }

    public static Point biggerB(Point p1, Point p2, Point p3) {
        double x0 = (p1.x + p3.x) / 2;
        double y0 = (p1.y + p3.y) / 2;
        double p4xb = x0 * 2 - p2.x;
        double p4yb = y0 * 2 - p2.y;
        return new Point(p4xb, p4yb);
    }

    public static Point equality(Point p1, Point p2, Point p3) {
        if (p2.y < p3.y) {
            double p4xC = (p2.x - p1.x) ;
            double p4yC = (p3.y - p1.y) ;
            return new Point(p4xC, p4yC);
        } else {
            double x0 = (p1.x + p3.x) / 2;
            double y0 = (p1.y + p2.y) / 2;
            double p4xC = x0 * 2 - p1.x;
            double p4yC = y0 * 2;
            return new Point(p4xC, p4yC);
        }
    }
}