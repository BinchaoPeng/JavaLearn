package Test;

public class Switch_ {
    enum expr_int {
        GREEN, RED, BLUE;
    }

    public static void main(String[] args) {
        int expr_int = 1;
        char expr_char = 'a';
        long expr_long = 1L;
        boolean expr_boolean = true;
        float expr_float = 3.f;
        double expr_double = 1.1;
        String expr_string = "1";
        short expr_short = 2;

        int expr = 0;

        switch (expr){
            case 1:
                System.out.println("int");
                break;
            case 'a':
                System.out.println("char");
                break;
            case 2:
                System.out.println("long");
                break;
            case 4:
                System.out.println("long");
                break;
            default:
                System.out.println("default");
        }

    }

}
