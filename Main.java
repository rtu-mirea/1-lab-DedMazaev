package com.company;
import org.w3c.dom.Text;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            int test = 8;
            Scanner in = new Scanner(System.in);
            while (test != 0) {
                try {
                    System.out.print("[0] - Завершение работы" + '\n' +
                            "[1] - Вариант на String" + '\n' +
                            "[2] - Ванриант на StringBuffer" + '\n' +
                            "[3] - Вариант на регулярные выражения" + '\n' +
                            "Выберите вариант: ");
                    test = in.nextInt();
                    switch (test) {
                        case 0:
                            System.out.print("End of working");
                            break;
                        case 1:
                            testStringClass(in);
                            break;
                        case 2:
                            testStringBuilderClass(in);
                            break;
                        case 3:
                            testRegularExpressionsClass(in);
                            break;
                        default:
                            System.out.println("Вы ввели недопустимую конструкцию!");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

    }
    static void testStringClass(Scanner in) throws Exception {
        TextWork object = new TextWork();
        int task = 8;
        while (task != 0){
            System.out.print("[0] - Предыдущее меню" + '\n' +
                    "[1] - Ввод строки" + '\n' +
                    "[2] - Вывод строки" + '\n' +
                    "[3] - Задание 1" + '\n' +
                    "[4] - Задание 2" + '\n' +
                    "[5] - Задание 3" + '\n' +
                    "[6] - Задание 4" + '\n' +
                    "Выберете задание: ");
            task = in.nextInt();
            switch(task){
                case 0:
                    System.out.println("Возвращение к предыдущему меню...");
                    break;
                case 1:
                    System.out.println("Введите текст: ");
                    in.nextLine();
                    String str = in.nextLine();
                    object.inputText(str);
                    break;
                case 2:
                    System.out.println(object.getText());
                    break;
                case 3:
                    object.paragraphSegmentation();
                    System.out.println("Текст разделенный на параграфы:\n" + object.getText());
                    break;
                case 4:
                    object.toUpperWords();
                    System.out.println("Текст с прописными буквами:\n" + object.getText());
                    break;
                case 5:
                    System.out.print("Введите номер абзаца: ");
                    int i = in.nextInt();
                    System.out.println("Количество слов в абзаце №" + i + " с содержанием \"ам\" равно " + object.findAmIn(i));
                    break;
                case 6:
                    System.out.println("Новая строка с включенным количеством слов:\n" + object.wordNum());
                    break;
                default:
                    System.out.println("Вы ввели недопустимую конструкцию!");
                    break;
            }
        }
    }
    static void testStringBuilderClass(Scanner in) {
        BilderTewtWork object = new BilderTewtWork();
        int task = 8;
        while (task != 0){
            System.out.print("[0] - Предыдущее меню" + '\n' +
                    "[1] - Ввод строки" + '\n' +
                    "[2] - Вывод строки" + '\n' +
                    "[3] - Задание 1" + '\n' +
                    "[4] - Задание 2" + '\n' +
                    "[5] - Задание 3" + '\n' +
                    "Выберете задание: ");
            task = in.nextInt();
            switch(task){
                case 0:
                    System.out.println("Возвращение к предыдущему меню...");
                    break;
                case 1:
                    System.out.println("Введите текст: ");
                    in.nextLine();
                    String str = in.nextLine();
                    object.inputText(new StringBuilder(str));
                    break;
                case 2:
                    System.out.println(object.getText());
                    break;
                case 3:
                    object.paragraphSegmentation();
                    System.out.println("Текст разделенный на параграфы:\n" + object.getText());
                    break;
                case 4:
                    object.toUpperWords();
                    System.out.println("Текст с прописными буквами:\n" + object.getText());
                    break;
                case 5:
                    //ривет мир. я иван люблю делать ам! ам ам ам 3 раза сказал ам всего 4? ам было в 3 абзаце, вот!
                    object.paragraphNum();
                    System.out.println("Текст с добавленным предложением:\n" + object.getText());
                    break;
                default:
                    System.out.println("Вы ввели недопустимую конструкцию!");
                    break;
            }
        }
    }
    static void testRegularExpressionsClass(Scanner in) {
        RegularExpression object = new RegularExpression();
        int task = 8;
        while (task != 0){
            System.out.print("[0] - Предыдущее меню" + '\n' +
                    "[1] - Ввод строки" + '\n' +
                    "[2] - Вывод строки" + '\n' +
                    "[3] - Задание 1" + '\n' +
                    "Выберете задание: ");
            task = in.nextInt();
            switch (task){
                case 0:
                    System.out.println("Возвращение к предыдущему меню...");
                    break;
                case 1:
                    System.out.println("Введите текст: ");
                    in.nextLine();
                    String str = in.nextLine();
                    object.inputText(str);
                    break;
                case 2:
                    System.out.println("Ваш текст:\n" + object.ghetText());
                    break;
                case 3:
                    object.changeNum();
                    System.out.println("Измененный текст:\n" + object.ghetText());
                    break;
                default:
                    System.out.println("Вы ввели недопустимую конструкцию!");
                    break;
            }
        }
    }
}
