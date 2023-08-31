/**
 Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив 
(либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, 
если сохранено значение ?, заменить его на соответствующее число.Если на каком-то месте встречается символ, 
отличный от числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
 */
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Task {
    public static void main(String[] args) {
        String path = "X:\\Devs\\GeekBrains\\JavaExceptions\\sem2\\sem2\\src\\main\\java\\text.txt";
        writeFile(changeLetter(readFile(path)), path);
    }

    public static List<String[]> readFile (String path) {
        List<String[]> result = new ArrayList<String[]>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = file.readLine()) != null) {
                String[] temp = line.split("=");
                if (!temp[1].equals("?") && !isNumeric(temp[1])) {
                    throw new RuntimeException("invalid data in line " + line);
                }
                result.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static boolean isNumeric (String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String[]> changeLetter (List<String[]> data) {
        for (String[] line: data) {
            if (line[1].equals("?")) {
                line[1] = String.valueOf(line[0].length());
            }
        }
        return data;
    }

    public static void writeFile (List<String[]> data, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String[] line : data) {
                bw.write(line[0] + "=" + line[1]);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}