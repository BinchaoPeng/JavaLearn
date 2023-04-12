package exception;

public class FinallyReturn {
    public static void main(String[] args) {
        System.out.print(getNumber(0));  // -1
        System.out.print(getNumber(1));  // 1
        System.out.print(getNumber(2));  // 1
        System.out.print(getNumber(4));  // 0
    }


    public static int getNumber(int num) {
        try {
            return 2 / num;
        } catch (Exception exception) {
            return 0;
        } finally {
            if (num == 0) {
                return -1;
            }
            if (num == 1) {
                return 1;
            }
        }
    }
}

