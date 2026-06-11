package self.self.HomeWork1;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入最大多少颗星：(奇数)");
        int max = sc.nextInt();
        for (int i = 1; i<= (max/2)+1; i++) {
                for (int j = 1; j <= i + (i - 1); j++) {
                    System.out.print("*");
                }
                System.out.println(" ");
        }
        for (int i = 1; i <= (max/2); i++) {
            for (int j = 1; j <= i + (max - 3) - 3 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
