package practical_work4;

public class CalculatingTheAreaOfAnIsoscelesTriangle {
// S = √(p·(p - a)·(p - b)·(p - c)), P = (a+b+c)/2 - формула Герона,
//где a, b, c - стороны треугольника, p - полупериметр.
    public static double calculatingTheAreaOfAnIsoscelesTriangle(double a, double b, double c) throws CalculatingTheAreaOfAnIsoscelesTriangleException {
        if (a < 0 || b < 0 || c < 0) throw new CalculatingTheAreaOfAnIsoscelesTriangleException();
        double S = Math.sqrt((((a + b + c) / 2) * (((a + b + c) / 2) - a) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - c)));
        return S;
//        System.out.println("Площадь треугольника равна " + S + " см2");
    }

}