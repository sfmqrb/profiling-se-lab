public class Sum {
    public static void main(String[] args)
    {
        int n = 1000000;
        double result = complex_operation_1(n);
    }

    private static double complex_operation_2(int n) {
        double result = 1.0;
        for (int i = 0; i < 1000000; i++) {
            int b = sum_good(n + i);
            if (i % 2 == 0)
                result /= (double) b;
            else
                result *= (double) b;
        }
        return result;
    }

    private static double complex_operation_1(int n) {
        double result = 1.0;
        for (int i = 0; i < 1000000; i++) {
            int a = sum_bad(n + i);
            if (i % 2 == 0)
                result /= (double) a;
            else
                result *= (double) a;
        }
        return result;
    }

    public static int sum_bad(int n)
    {
        int sum = 0;
        for (int i=0; i<=n; i++) {
            sum += i;
        }
        return sum;
    }
    public static int sum_good(int n)
    {
        return n * (n + 1) / 2;
    }
}
