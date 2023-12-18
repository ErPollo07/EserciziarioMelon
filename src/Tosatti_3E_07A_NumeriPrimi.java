public class Tosatti_3E_07A_NumeriPrimi {
    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {

            if (i > 1) {
                if (IsPrime(i)) {
                    System.out.println(i);
                }
            }
        }
    }

    /**
     * @param n number to evaluate if it is prime
     * */
    private static boolean IsPrime(int n) {

        boolean flag = true;

        for (int j = 2; j <= n / 2 && flag; j++) {

            if (n % j == 0)
                flag = false;
        }

        return flag;
    }
}
