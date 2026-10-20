package Lab_class;

import java.util.Scanner;

public class TeamService {

    // ===== поля класса =====
        private static Team[]   commands;       //массив объектов


    // ===== начальное заполнение массива =====
    // выполняется один раз при первом обращении к классу
        static {
            commands = new Team[]{
                    new Team("Team", "Sport", 1)
            };
        }


    // =====  методы для работы с массивом =====

    //вывод массива
        public static void printCommands() {
            for (int i = 0; i < commands.length; i++) {
                System.out.println(commands[i]);
            }
        }

    //заполнение массива с клавиатуры
        public static void fillCommands() {
            int n = 0;
            while (n <= 0) {
                System.out.println("Введите количество команд: ");
                Scanner scan = new Scanner(System.in);
                if (scan.hasNextInt()) {
                    n = scan.nextInt();
                    if (n <= 0)
                        System.out.println("Недопустимое значение!");
                } else {
                    System.out.println("Нужно ввести целое число!");
                }
            }
            commands = new Team[n];
            System.out.println("Введите информацию о командах: ");
            for (int i=0; i < commands.length; i++){
                System.out.println("Команда " + (i+1) + ": ");
                commands[i] = new Team();
            }
        }
}
