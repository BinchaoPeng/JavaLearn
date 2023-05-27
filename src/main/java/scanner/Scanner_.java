package scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Scanner_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Integer line = scanner.nextInt();
            list.add("" + line);
        }
        System.out.println();
        System.out.println(Arrays.toString(list.toArray()));
    }
}
/*
1 2 3
4 5 6
222222
helll0
 */