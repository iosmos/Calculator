import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        int a;
        int b;
        String strIn;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример через пробелы: "); strIn = in.nextLine();

//                                            РАЗБИВАЕМ В МАССИВ

        String [] strMass =  strIn.split(" ");
        if (strMass.length != 3) throw new Exception("В примере должно быть 2 числа и 1 знак (через пробелы)");
        String [] strNumbers = new String[] {strMass[0], strMass[2]};

//                                            ПРОВЕРЯЕМ РИМСКИЕ ИЛИ АРАБСКИЕ
        int romeOrArab = 0;
        if (Rome.isRome(strNumbers[0]) && Rome.isRome(strNumbers[1])) {
            a = Rome.romeToArab(strNumbers[0]);
            b = Rome.romeToArab(strNumbers[1]);
            romeOrArab++;
        } else if (Arab.isArab(strNumbers[0]) && Arab.isArab(strNumbers[1])) {
            a = Arab.arabToNumb(strNumbers[0]);
            b = Arab.arabToNumb(strNumbers[1]);
            romeOrArab--;
        } else throw new Exception("Неверные числа: используйте числа от 1 до 10 в одной системе исчисления(арабские или римские)");


//                                            ПРОВЕРЯЕМ ЗНАК

        int result = Operator.firstResult(a,b,romeOrArab,strMass[1]);

//                                            ВЫВОДИМ РЕЗУЛЬТАТ С ПРОВЕРКОЙ: АРАБСКИЕ ИЛИ РИМСКИЕ

        if (romeOrArab < 0){
            System.out.println(result);
        } else if ((romeOrArab > 0) && (result > 0)) {
            System.out.println(Rome.romeNumbers[(int)result]);
        }
    }
}


class Operator {
    public static int firstResult(int a, int b, int c, String x) throws Exception{
        double chekResult;
        switch (x) {
            case "+": chekResult = a + b;
            break;
            case "-": chekResult = a - b;
            break;
            case "*": chekResult = a * b;
            break;
            case "/": chekResult = (double)a / (double)b;
            break;
            default: throw new Exception("Неподходящая операция, вводите знаки +-*/");
        }


        if (c < 0) {return (int)chekResult;}
        else {
            if ((int)chekResult > 0){
                return (int)chekResult;
            } else throw new Exception("в римской системе нет отрицательных чисел и 0");
        }
    }
}

class Arab {
    static String[] arabNumbers = new String[]{"0","1","2","3","4","5","6","7","8","9","10"};

    public static boolean isArab(String x){
        for (int i = 0; i < arabNumbers.length; i++){
            if (x.equals(arabNumbers[i])) {return true;}
        } return false;
    }

    public static int arabToNumb(String x) throws Exception{
        for (int i = 0; i < arabNumbers.length; i++){
            if (x.equals(arabNumbers[i])) {return i;}
        } throw new Exception("Неправильный формат чисел");
    }
}
class Rome {
    static String[] romeNumbers = new String[]{"0","I","II","III","IV","V","VI","VII","VIII","IX","X",
            "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
            "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
            "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
            "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
            "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
            "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
            "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
            "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
            "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};

    public static boolean isRome(String x) {
        for (int i = 0; i < romeNumbers.length; i++) {
            if (x.equals(romeNumbers[i])) {return true;}
        }
        return false;
    }

    public static int romeToArab (String x) throws Exception{
        for (int i = 0; i < romeNumbers.length; i++) {
            if (x.equals(romeNumbers[i])) {return i;}
    } throw new Exception("Неправильный формат чисел");
}
}
