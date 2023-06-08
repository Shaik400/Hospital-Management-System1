import java.util.Scanner;

class Strong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number");
        int num = sc.nextInt();
        int copy = num;
        int sum = 0;
        while (num != 0) {
            int d = num % 10;
            sum = sum + d * fact(d);
            num = num / 10;
        }

        if (sum == copy) {
            System.out.println("strong num");
        } else {
            System.out.println(" Not a strong num");
        }
    }

    static int fact(int num) {
        int fact = 1;
        {
            for (int i = num; i >= 1; i--) {
                fact = fact * i;

            }

            return fact;
        }
    }

}
