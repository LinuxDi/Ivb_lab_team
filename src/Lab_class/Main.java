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
            int c = new Scanner(System.in).nextInt();
            switch (c) {
                case 1: Team.fillCommands();   break;
                case 2: Team.printCommands();  break;
                case 3: Team.winnersByType();  break;
                default: break cycle;
            }
        }

    }
}