package Service;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputString {
    public InputString() {
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные по фомату: \nФамилия Имя Отчество дата_рождения(yyyy.mm.dd) номер_телефона пол(m/f)");
        String res = scanner.nextLine();
        return res;
    }

    public String[] getItems(String s, String regex) {
        s = s.strip();
        String[] items = s.split(regex);
        return items;
    }

    public int countElements(String[] s) {
        return s.length;
    }

    public boolean lenCountItem(int item) {
        try {
            if (item > 6) {
                throw new RuntimeException("введено больше значений, чем требуется.");
            } else if (item < 6) {
                throw new RuntimeException("введено меньше значений, чем требуется.");
            }
            return true;
        } catch (RuntimeException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return false;
        }
    }

    public boolean parseLong(String num) {
        try {
            Long.parseLong(num);
            if (Long.parseLong(num) <= 0 || num == null) {
                throw new RuntimeException();
            }
            return true;
        } catch (RuntimeException e) {
            System.err.println("Ошибка: значение телефонного номера не соответсвуют требованиям задания.");
            return false;
        }
    }

    public boolean fullFio(String[] elements) {
        if (!elements[0].isEmpty() & !elements[1].isEmpty() & !elements[2].isEmpty()) {
            return true;
        } else {
            try {
                throw new RuntimeException("не заполнены обязательные поля ФИО.");
            } catch (RuntimeException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
            return false;
        }
    }

    public boolean gender(String s) {
        if (s.length() == 1 & (s.equals("m") || s.equals("f"))) {
            return true;
        } else {
            try {
                throw new RuntimeException("значение пола не соответсвуют требованиям задания.");
            } catch (RuntimeException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
            return false;
        }
    }

    public boolean isDate(String s) {
        int[] birth = new int[3];
        String[] dateLine = getItems(s, Pattern.quote("."));
        try {
            if (dateLine.length == 3 & dateLine[0].length() == 4 & dateLine[1].length() > 0 & dateLine[1].length() < 3 & dateLine[2].length() > 0 & dateLine[2].length() < 3) {
                for (int i = 0; i < dateLine.length; i++) {
                    if (isDigit(dateLine[i])) {
                        birth[i] = Integer.parseInt(dateLine[i]);
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
            LocalDate.of(birth[0], birth[1], birth[2]);
            return true;
        } catch (Exception e) {
            System.err.println("Ошибка: некорректный ввод даты рождения. (yyyy.mm.dd)");
        }
        return false;
    }

    public boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
