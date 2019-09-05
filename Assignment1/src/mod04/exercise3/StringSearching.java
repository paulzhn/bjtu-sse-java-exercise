package mod04.exercise3;

import java.util.Scanner;

public class StringSearching {
    public static void main(String[] args) {
        String a, b;

        Scanner scan = new Scanner(System.in);
        System.out.print("Input the string to be found: ");
        b = scan.nextLine();
        System.out.print("Input the string where to find: ");
        a = scan.nextLine();

        StringSearching tmp = new StringSearching();
        System.out.println(tmp.isSubstring(a, b));
    }

    private boolean isSubstring(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0) && a.length() - i + 1 >= b.length()) {
                int ok = 1;
                int k = i;
                for (int j = 0; j < b.length(); j++) {
                    if (a.charAt(k++) != b.charAt(j)) {
                        ok = 0;
                        break;
                    }
                }
                if (ok == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
