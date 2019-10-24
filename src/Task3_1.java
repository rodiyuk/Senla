import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Необходимо написать программу, которая определяет
пересекаются ли два отрезка. Координаты отрезков вводятся
вручную во время выполнения программы.
 */
public class Task3_1 {
    public static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите координаты первого отрезка(AB):\nКоординаты точки А(x1;y1): ");
        double x1 = Integer.parseInt(reader.readLine());
        double y1 = Integer.parseInt(reader.readLine());
        System.out.println("Координаты точки B(x2;y2): ");
        double x2 = Integer.parseInt(reader.readLine());
        double y2 = Integer.parseInt(reader.readLine());
        System.out.println("Введите координаты второго отрезка(CD):\nКоординаты точки C(x3;y3): ");
        double x3 = Integer.parseInt(reader.readLine());
        double y3 = Integer.parseInt(reader.readLine());
        System.out.println("Координаты точки D(x4;y4): ");
        double x4 = Integer.parseInt(reader.readLine());
        double y4 = Integer.parseInt(reader.readLine());

        Point A = new Point(x1, y1);
        Point B = new Point(x2, y2);
        Point C = new Point(x3, y3);
        Point D = new Point(x4, y4);
        System.out.println((intersection(A, B, C, D)));
    }
    public static String intersection(Point a, Point b, Point c, Point d) {
        double v1=(d.x-c.x)*(a.y-c.y)-(d.y-c.y)*(a.x-c.x);
        double v2=(d.x-c.x)*(b.y-c.y)-(d.y-c.y)*(b.x-c.x);
        double v3=(b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
        double v4=(b.x-a.x)*(d.y-a.y)-(b.y-a.y)*(d.x-a.x);
        if(v1*v2<0 && v3*v4<0) {
            double A1, B1, C1, A2, B2, C2;
            A1 = b.y - a.y;
            A2 = d.y - c.y;
            B1 = a.x - b.x;
            B2 = c.x - d.x;
            C1 = (a.x * (a.y - b.y) + a.y * (b.x - a.x)) * (-1);
            C2 = (c.x * (c.y - d.y) + c.y * (d.x - c.x)) * (-1);
            double D = ((A1 * B2) - (B1 * A2));
            double Dx = ((C1 * B2) - (B1 * C2));
            double Dy = ((A1 * C2) - (C1 * A2));
            if(D != 0){
               double X = (Dx / D);
                double Y = (Dy / D);
                return  "Отрезки пересекаются в точке: " + X + ", " + Y;
            }
        } return  "Отрезки не пересекаются ";
    }
}