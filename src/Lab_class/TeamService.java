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
}
