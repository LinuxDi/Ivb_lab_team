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

    // ===== выполнение условий задачи =====

    //а) победители в каждом виде соревнований
        public static void winnersByType() {
            String[] types = new String[commands.length];
            int typeCount = 0;
            for (int i = 0; i < commands.length; i++) {
                boolean exists = false;
                for (int j = 0; j < typeCount; j++) {
                    if (types[j].equalsIgnoreCase(commands[i].getSName())) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    types[typeCount] = commands[i].getSName();
                    typeCount++;
                }
            }

            System.out.println("\nПобедители по видам соревнований:");
            for (int i = 0; i < typeCount; i++) {
                int pos_max = -1;   // номер команды-победителя (-1, т.к. пока никого нет)
                for (int j = 0; j < commands.length; j++) {
                    if (commands[j].getSName().equalsIgnoreCase(types[i])) {
                        if (pos_max == -1 || commands[j].getScore() > commands[pos_max].getScore()) {
                            pos_max = j;
                        }
                    }
                }
                System.out.println("\t" + types[i] + " => " + commands[pos_max]);
            }
        }
}
