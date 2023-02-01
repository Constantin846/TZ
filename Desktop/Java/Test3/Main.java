import java.io.IOException;
import java.util.*;

public class Main {
    private static final String[] ROMENUM = new String[] {
            "I","II","III","IV","V","VI","VII","VIII","IX","X"};

    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            String[] strSplit = str.split(" ");

            if (strSplit.length != 3)
                throw new IOException("Неправильный ввод!");

            boolean isRomeNum = false;
            int a, b, result;

            try {
                a = Integer.parseInt(strSplit[0]);
                b = Integer.parseInt(strSplit[2]);
            } catch (Exception e) {
                a = GetNum(strSplit[0]);
                b = GetNum(strSplit[2]);
                isRomeNum = true;
            }

            if (a > 10 || b > 10)
                throw new IOException("Число больше 10!");

            switch (strSplit[1]) {
                case "+": result = a + b;
                    break;
                case "-": result = a - b;
                    break;
                case "*": result = a * b;
                    break;
                case "/": result = a / b;
                    break;
                default:
                    throw new IOException("Нет такого действия!");
            }

            if (isRomeNum)
                System.out.println(GetRomeNum(result));
            else
                System.out.println(result);
        }
    }

    public static int GetNum(String romeNum) throws IOException {
        for (int i = 0; i < 10; i++){
            if (ROMENUM[i].equals(romeNum))
                return i + 1;
        }
        throw new IOException("Неправильный ввод!");
    }

    public static String GetRomeNum(int num){
        String romeNum = "";

        int firstSign = num / 10;
        if (firstSign != 0) {
            romeNum = ROMENUM[firstSign - 1];
            romeNum = romeNum.replace("X", "C");
            romeNum = romeNum.replace("V", "L");
            romeNum = romeNum.replace("I", "X");
        }

        int secondSign = num % 10;
        if (secondSign != 0)
            romeNum = romeNum + ROMENUM[secondSign - 1];

        return romeNum;
    }
}