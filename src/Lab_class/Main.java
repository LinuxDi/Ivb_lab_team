/*
Лабораторная работа студента ИВб-25-2
Нарикаева Максима
Вариант 9

maksimnarikaev8@gmail.com
 */

package Lab_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        cycle: while (true) {

            System.out.println("\n1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Победители по видам соревнований");
            System.out.println("4. Победитель общего зачёта");
            System.out.println("5. Упорядочить команды по занятому месту");
            System.out.println("6. Выход");
            System.out.println("Выберите пункт меню (1..6): ");

            // проверка: если ввели не число, 'c' останется 0
            Scanner scan = new Scanner(System.in);
            int c = 0;
            if (scan.hasNextInt()) {
                c = scan.nextInt();
            } else {
                System.out.println("Нужно ввести целое число!");
            }

            switch (c) {
                case 1: TeamService.fillCommands();        break;
                case 2: TeamService.printCommands();       break;
                case 3: TeamService.winnersByType();       break;
                case 4: TeamService.overallWinner();       break;
                case 5: TeamService.sortByPlace();         break;
                case 6: break cycle;
                default: System.out.println("Такого пункта нет!");
            }
        }

    }
}