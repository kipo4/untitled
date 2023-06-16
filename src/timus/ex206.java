import java.math.BigInteger;
import java.util.Scanner;

public class ex206 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        BigInteger ans = new BigInteger(55 + "").pow(k - 1);
        System.out.println(ans.multiply(new BigInteger(36 + "")));
    }
}
