import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {

        int A;
        int B;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение:  ");
        String Vvod = input.nextLine();
        String[] vvod1 = Vvod.split(" ");


        if (vvod1.length!=3) throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        String chislo_1 = vvod1[0];
        String operator = vvod1[1];
        String chislo_2 = vvod1[2];

        if (existNumOperation(operator)!=true) throw new Exception("throws Exception //т.к. ("+  operator+  ") не является математической операцией");
        if (existArab(chislo_1)&existRim(chislo_2)) throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        if (existArab(chislo_2)&existRim(chislo_1)) throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        if ((!existArab(chislo_1)&&!existRim(chislo_1))||(!existArab(chislo_2)&&!existRim(chislo_2))) throw new Exception("throws Exception //числа введены не по формату");

        if (existArab(chislo_1)& existArab(chislo_2)){
            A=Integer.parseInt(chislo_1);
            B=Integer.parseInt(chislo_2);


            if (operator.equals("+")){
                System.out.println(A+B);
            }
            if (operator.equals("-")){
                System.out.println(A-B);
            }
            if (operator.equals("*")){
                System.out.println(A*B);
            }
            if (operator.equals("/")){
                System.out.println(A/B);
            }

        }

        if (existRim(chislo_1)& existRim(chislo_2)){
            A= existRimToNum(chislo_1);
            B= existRimToNum(chislo_2);

            if ((A>10)||(B>10)) throw new Exception("throws Exception //т.к. введенные числа больше X");

            String[] Rim = {
                    "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                    "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                    "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",
            };
            int resultat=0;


            if (operator.equals("+")){
                resultat=(A+B);
            }
            if (operator.equals("-")){
                resultat=(A-B);
            }
            if (operator.equals("*")){
                resultat=(A*B);
            }
            if (operator.equals("/")){
                resultat=(A/B);
            }

            if (resultat>=0) System.out.println(Rim[resultat-1]);
            else throw new Exception("throws Exception - у римских цифр  не может быть отрицательный результат");
        }


    }

    static boolean existRim(String a){
        String[] Rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",};
        for (String s : Rim) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }
    static boolean existArab(String a){
        String[] Arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",};
        for (String s : Arab) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }
    static int existRimToNum(String a){
        String[] Rim = {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",
        };
        int n=0;
        for (int i = 0; i < 10 ; i++) {

            if(Rim[i].equals(a)) return i+1;

        }
        return n;
    }
    static boolean existNumOperation(String a){
        String[] NumOperation = {"+", "-", "/", "*"};
        for (String s : NumOperation) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }
    //klkhlhl
}