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

    //б) команда, занявшая первое место по общему зачёту
        public static void overallWinner() {
            // names[k] - название команды, totals[k] - сумма её очков по всем видам
            String[] names = new String[commands.length];
            int[] totals = new int[commands.length];
            int count = 0;
            for (int i = 0; i < commands.length; i++) {
                boolean found = false;
                for (int j = 0; j < count; j++) {
                    if (names[j].equalsIgnoreCase(commands[i].getTName())) {
                        totals[j] += commands[i].getScore();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    names[count] = commands[i].getTName();
                    totals[count] = commands[i].getScore();
                    count++;
                }
            }

            int pos_max = 0;
            for (int i = 1; i < count; i++) {
                if (totals[i] > totals[pos_max]) pos_max = i;
            }
            System.out.println("\nПобедитель общего зачёта:");
            System.out.println("\t" + names[pos_max] + " - " + totals[pos_max] + " очков");
        }

    //в) упорядочить команды
        public static void sortByPlace() {
            for (int i = 0; i < commands.length - 1; i++)
                for (int j = 0; j < commands.length - i - 1; j++)
                    if (commands[j].getScore() < commands[j + 1].getScore()) {
                        Team rab = commands[j];
                        commands[j] = commands[j + 1];
                        commands[j + 1] = rab;
                    }
            System.out.println("\nСписок команд по занятому месту:");
            for (int i = 0; i < commands.length; i++) {
                System.out.println((i + 1) + " место: " + commands[i]);
            }
        }
}
