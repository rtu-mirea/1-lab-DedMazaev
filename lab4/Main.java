package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        FileControl obj = new FileControl();
        ArrayList<Toy> toys;
        int task = 8;
        while (task != 0) {
            try {
                System.out.print("[0] - Завершение работы" + '\n' +
                        "[1] - Задание 1 (Разобраться с файлами)" + '\n' +
                        "[2] - Задание 2 (применить знания на практике)" + '\n' +
                        "[3] - Задание 3 (Разобраться с текстовыми файлами)" + '\n' +
                        "[4] - Задание 4 (Сделать что-то)" + '\n' +
                        "Выберите нужное задание: ");
                task = in.nextInt();
                switch (task) {
                    case 0:
                        System.out.println("Завершение работы");
                        break;
                    case 1:
                        task1();
                        break;
                    case 2:
                        in.nextLine();
                        System.out.println("Введите имя файла");
                        obj.save(in.nextLine());
                        toys = obj.load();
                        for (Toy toy : toys) {
                            System.out.println("Фирма игрушки: " + toy.getFirm() + ", " +
                                    "цена за игрушку: " + toy.getPrice() + ", " +
                                    "Возрастное ограничение: " + toy.getLowAge() + '-' + toy.getHighAge());
                        }
                        System.out.println("Работа с RandomAccess");
                        toys = obj.randomAccess(toys);
                        for (Toy toy : toys) {
                            System.out.println("Фирма игрушки: " + toy.getFirm() + ", " +
                                    "цена за игрушку: " + toy.getPrice() + ", " +
                                    "Возрастное ограничение: " + toy.getLowAge() + '-' + toy.getHighAge());
                        }
                        break;
                    case 3:
                        task3Ex1();
                        task3Ex2();
                        task3Ex3();
                        break;
                    case 4:
                        task4();
                        break;
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    private static void task1(){
        try {
            Scanner in = new Scanner(System.in);
            // Упражнение 1
            File f1 = new File("MyFile1.txt");
            System.out.println("Упражнение 1 ---------------------------------------------------------------");
            f1.createNewFile();
            File f2 = new File ("/MyFile2.txt");
            f2.createNewFile();
            File f3 = new File("A:\\New Folder 42");
            f3.createNewFile();

            if(f1.exists())
                System.out.println(f1.getName() + " был создан");
            else
                System.out.println(f1.getName() + " не был создан");
            if(f2.exists())
                System.out.println(f2.getName() + " был создан");
            else
                System.out.println(f2.getName() + " не был создан");
            if(f3.exists())
                System.out.println(f3.getName() + " был создан");
            else
                System.out.println(f3.getName() + " не был создан");
            File dir = new File("first\\second\\third");
            dir.mkdirs();
            if(dir.exists())
                System.out.println(dir.getName() + " был создан");
            else
                System.out.println(dir.getName() + " не был создан");
            // Упражнение 2
            System.out.println("\nУпражнение 2 ---------------------------------------------------------------");
            if (f2.isFile())
                System.out.println(f2.getName() + " является файлом, его родитель - " + f2.getParent());
            else
                System.out.println(f2.getName() + " не является файлом");
            if(dir.isDirectory())
                System.out.println(dir.getName() + " является папкой, ее родитель - " + dir.getParent());
            else
                System.out.println(dir.getName() + " не является папкой");
            File f4 = new File(f1.getName());
            if (f4.exists())
                System.out.println(f4.getName() + " находитсся в папке приложения");
            else
                System.out.println(f4.getName() + " не находится в папке приложения");
            System.out.println("Полный путь к файлу " + f1.getName() + ":\n" + f1.getAbsolutePath());
            if (f1.isFile())
                System.out.println("Размер файла" + f1.getName() + " в байтах равен " + f1.length());
            else
                System.out.println("Размер папки" + f1.getName() + " в байтах равен " + f1.length());
            //Упражнение 3
            System.out.println("\nУпражнение 3 ---------------------------------------------------------------");
            File dir1 = new File("OneMoreDirectory");
            dir1.mkdir();
            File dir2 = new File("C:\\Users\\Vasily\\Desktop\\Laba4");
            String arr[] = dir2.list();
            File arr1[] = dir2.listFiles();
            int count = 0;
            System.out.println("Содержимое папки " + dir2.getName() + ":\n");
            for(String str: arr)
                System.out.println(str);
            System.out.println("Содержимое папки " + dir2.getName() + ":\n");
            for(File file: arr1) {
                System.out.println(file.getName());
                if(file.isDirectory())
                    count++;
            }
            System.out.println("Количество папок в папке приложения равно " + count);


            dir1.delete();
            while(dir.getParent() != null){
                dir.delete();
                dir = new File(dir.getParent());
            }
            dir.delete();
            f1.delete();
            f2.delete();
            f3.delete();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    private static void task3Ex1(){
        try {
            Reader reader = new InputStreamReader(new FileInputStream("T1.txt"));
            Writer writer = new OutputStreamWriter(new FileOutputStream("T2.txt"));
            int x;
            while((x = reader.read()) != -1) {
                writer.write((char)x);
            }
            System.out.println("Все символы были пернесены из файла T1.txt в файл T2.txt");
            reader.close();
            writer.close();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
    private static void task3Ex2(){
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream("A.txt"));
            for (int i = 40; i < 552; i++) {
                writer.write((char) i);
            }
            writer.close();
            System.out.println("Файл A.txt был заполнен 512 символами");

            BufferedReader inb = new BufferedReader(new InputStreamReader(new FileInputStream("A.txt")), 128);
            BufferedWriter outb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("B.txt")), 128);
            char[] buf = new char[128];
            for(int i = 0; i < 4; i++){
                inb.read(buf);
                outb.write(buf);
                outb.newLine();
            }
            System.out.println("Символы по 128 штук были перенесены из файла A.txt в B.txt");
            inb.close();
            outb.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    private static void task3Ex3(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Vasily\\Desktop\\Laba4\\src\\A.txt"), "Cp1251"));
            System.out.println("Кодировка системы: " + Charset.defaultCharset().name());
            String str = in.readLine();
            System.out.println("Строка прочитанная в неверной кодировке:\n" + str);
            in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Vasily\\Desktop\\Laba4\\src\\B.txt"), "UTF-8"));
            str = in.readLine();
            System.out.println("Строка прочитанная в верной кодировке:\n" + str);
        }
        catch (Exception e){System.err.println(e);}
    }
    private static void task4(){
        int task = 666;
        Scanner in = new Scanner(System.in);
        while(task != 0){
            try{
                System.out.print("[0] - Возвращение к предыдущему меню" + '\n' +
                        "[1] - проверка класса получающего данные из файла" +'\n' +
                        "[2] - проверка класса консольного ввода" +'\n' +
                        "[3] - проверка класса сериализации" +'\n' +
                        "Выбериет нужный варант: ");
                task = in.nextInt();
                switch (task){
                    case 0:
                        System.out.println("Возвращение к предыдущему меню");
                        break;
                    case 1:
                        in.nextLine();
                        System.out.println("Введите название файла");
                        ClassTextFile obj = new ClassTextFile(in.nextLine());
                        TextWork textObj = obj.task4();
                        System.out.println("Текст объекта, прочитанный из файла\n" + textObj.getText());
                        break;
                    case 2:
                        ConsoleInput object = new ConsoleInput();
                        object.consoleInputData();
                        System.out.println(object.getObject().getText());
                        break;
                    case 3:
                        in.nextLine();
                        System.out.println("Введите название файла для сериализации");
                        SerilisationClass o = new SerilisationClass(in.nextLine());
                        System.out.println("Файл был создан");
                        o.makeCollection();
                        System.out.println("Коллекция была создана");
                        o.readCollection();
                        System.out.println("Коллекция была десериализирована");
                        ArrayList<TextWork> arr = o.getObjectCollection();
                        for (TextWork i:
                             arr) {
                            System.out.println(i.getText());
                        }
                        break;
                }
            }
            catch (Exception e){System.err.println(e);}
        }
    }
}
