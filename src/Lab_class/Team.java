package Lab_class;

import java.util.Scanner;

public class Team {
    //поля класса
        private String TeamName;            //название команды
        private String SorevName;           //вид соревнования
        private int Score;                  //количество очков
        private static Team[] commands;     //массив объектов

    //началькое заполнение массива
        static {
            commands = new Team[]{
                    new Team("Team", "Sport", 1)
            };
        }

    //конструктор
        public Team(String teamName, String sorevName, int score){
            this.TeamName = teamName;
            this.SorevName = sorevName;
            this.Score = score;
        }

    //конструктор по умолчанию
        public Team() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Название команды: ");
            this.setTeamName(scan.nextLine());
            System.out.println("\t Вид спорта:");
            this.setSorevName(scan.nextLine());
            System.out.println("\t Количество очков");
            this.setScore(scan.nextInt());
            scan.nextLine();
        }

    //геттеры и сеттеры
        public String getTName(){return this.TeamName;}
        public void setTeamName(String tname){
            if (tname.isEmpty())
                System.out.println("Недопустимое значение!");
            else
                this.TeamName = tname;
        }

        public String getSName(){return this.SorevName;}
        public void setSorevName(String sname){
            if (sname.isEmpty())
                System.out.println("Недопустимое значение!");
            else
                this.SorevName = sname;
        }

        public int getScore(){return this.Score;}
        public void setScore(int score){
            if (score<0)
                System.out.println("Недопустимое значение!");
            else
                this.Score = score;
        }


        @Override
        public String toString() {
            return String.format("Команда: %s \t вид: %s \t очков: %d", TeamName, SorevName, Score);
        }

    //вывод массива
        public static void printCommands() {
                for (int i = 0; i < commands.length; i++) {
                    System.out.println(commands[i]);
                }
        }

        public static void fillCommands() {
            System.out.println("Введите количество команд: ");
            int n = new Scanner(System.in).nextInt();
            commands = new Team[n];
            System.out.println("Введите информацию о командах: ");
            for (int i=0; i < commands.length; i++){
                System.out.println("Команда " + (i+1) + ": ");
                commands[i] = new Team();
            }
        }

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
