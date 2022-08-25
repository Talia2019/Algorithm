package CJY.week12;

import java.util.Scanner;
import java.util.Stack;

public class G4_16120 {
    //G4_16120_PPAP

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ppap = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        if(ppap.equals("P")){
            System.out.println("PPAP");
            System.exit(0);
        }

        if(ppap.charAt(0) != 'P'){
            System.out.println("NP");
            System.exit(0);
        } else {
            stack.add('P');
        }

        int len = ppap.length();
        for (int i = 1; i < len; i++) {
            boolean flag = false;
            if(i < len - 2 && ppap.charAt(i) == 'P' && ppap.charAt(i + 1) == 'A' && ppap.charAt(i + 2) == 'P'){
                flag = true;
            }

            if(flag){
                if(stack.size() == 0){
                    System.out.println("NP");
                    System.exit(0);
                }else {
                    stack.pop();
                    i++;
                }
            } else if(ppap.charAt(i) == 'P'){
                stack.push('P');
            } else {
                System.out.println("NP");
                System.exit(0);
            }
        }

        if(stack.size() == 0){
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }

    }
}
