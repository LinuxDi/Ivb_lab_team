package Lab_class;

import java.util.Scanner;

public class Team {

    // ===== поля класса =====
        private String          TeamName;       //название команды
        private String          SorevName;      //вид соревнования
        private int             Score;          //количество очков

    // ===== конструкторы =====

    //конструктор
        public Team(String  teamName,
                    String  sorevName,
                    int     score){
            this.TeamName =     teamName;
            this.SorevName =    sorevName;
            this.Score =        score;
        }

    //конструктор по умолчанию (то есть ввод происходит через клавиатуру)
    //Было принято решение сделать через циклы, чтобы в массив класса не попадали объекты с нулевыми значениями
        public Team() {

            // пока название не задано (null), спрашиваем название команды снова
            Scanner scan = new Scanner(System.in);
            while (this.TeamName == null) {
                System.out.println("Название команды: ");
                this.setTeamName(scan.nextLine());
            }

            // то же самое для вида соревнования
            while (this.SorevName == null) {
                System.out.println("\t Вид спорта:");
                this.setSorevName(scan.nextLine());
            }

            // -1 означает "очки ещё не заданы"
            this.Score = -1;
            while (this.Score < 0) {
                System.out.println("\t Количество очков: ");
                if (scan.hasNextInt()) {
                    this.setScore(scan.nextInt());
                } else {
                    System.out.println("Нужно ввести целое число!");
                    scan.next();
                }
                scan.nextLine();
            }
        }


    //===== геттеры и сеттеры =====
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

    // ===== метод toString (как объект выводится на экран) =====
        @Override
        public String toString() {
            return String.format("Команда: %s \t вид: %s \t очков: %d", TeamName, SorevName, Score);
        }
}
