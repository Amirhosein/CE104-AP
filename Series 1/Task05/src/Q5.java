import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Complex {
    double real;
    double img;

    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public static Complex add(Complex n1, Complex n2) {
        double real = n1.real + n2.real;
        double img = n1.img + n2.img;
        return new Complex(real, img);
    }

    public static Complex difference(Complex n1, Complex n2) {
        double real = n1.real - n2.real;
        double img = n1.img - n2.img;
        return new Complex(real, img);
    }

    public static Complex times(Complex n1, Complex n2) {
        double real = n1.real * n2.real - n1.img * n2.img;
        double img = n1.real * n2.img + n1.img * n2.real;
        return new Complex(real, img);
    }

    public static Complex division(Complex n1, Complex n2) {
        double real = (n1.real * n2.real + n1.img * n2.img) / (Math.pow(n2.real, 2) + Math.pow(n2.img, 2));
        double img = (n1.img * n2.real - n1.real * n2.img) / (Math.pow(n2.real, 2) + Math.pow(n2.img, 2));
        return new Complex(real, img);
    }

    public static void print(Complex b) {
        String img = "";
        if (b.img != 1) {
            img = String.valueOf(new DecimalFormat().format(b.img));
        }
        if (b.img < 0){
            System.out.format("%s%si\n",new DecimalFormat().format(b.real),img);
        }
        else {
            System.out.format("%s+%si\n",new DecimalFormat().format(b.real),img);

        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n1Line = scanner.nextLine();
        String n2Line = scanner.nextLine();
        Double[] n1Parts = new Double[2];
        Double[] n2Parts = new Double[2];

        n1Parts[0] = Double.valueOf(n1Line.split(" ")[0]);
        n1Parts[1] = Double.valueOf(n1Line.split(" ")[1]);
        n2Parts[0] = Double.valueOf(n2Line.split(" ")[0]);
        n2Parts[1] = Double.valueOf(n2Line.split(" ")[1]);

        Complex n1 = new Complex(n1Parts[0], n1Parts[1]);
        Complex n2 = new Complex(n2Parts[0], n2Parts[1]);

        List<String> operators = new ArrayList<>();
        String operator;

        while (true) {
            operator = scanner.nextLine();
            if (operator.equals("#")) break;
            operators.add(operator);
        }

        for (String op: operators) {
            Complex result = switch (op) {
                case "+" -> Complex.add(n1, n2);
                case "-" -> Complex.difference(n1, n2);
                case "*" -> Complex.times(n1, n2);
                case "/" -> Complex.division(n1, n2);
                default -> null;
            };
            assert result != null;
            Complex.print(result);
        }
    }
}
