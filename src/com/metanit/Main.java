package com.metanit;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.*;


public class Main {

    public static void main(String[] args) {
       /* // Григорианский календарь
       Scanner sc=new Scanner(System.in);
        int year= sc.nextInt();
            System.out.println(" year/4-y/100+y/400=" +(year/4-year/100+year/400));
            */
      /* // проверка (a+b)==с для вещественных переменных
      double a=0.1,b=0.2,c=0.3;
        System.out.println(Math.abs((a+b)-c)<1E-4);
        */
        /*//изменение значение одного бита заданного целого числа на противоположное.
        int a=10,ind=1;
        System.out.println(a^(1<<(ind-1)));

         */
        /*//Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии 5
        System.out.println((char) ((int) '\\'+5));

         */
        /*
        int a=18;
        System.out.println(Integer.toBinaryString(a));//представление числа а в двоичном виде
        System.out.println(Integer.bitCount(a));// подсчет единичных битов в числе а

         */
        /*//Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая)
        String text="Madam, I'm Adam!";
        String str=text.replaceAll("[^a-zA-Z0-9]","");//удаление всех символов не входящих в условия a-zA-Z0-9
        StringBuilder sb=new StringBuilder(str);//необходим для метода reverse()
        String rev=sb.reverse().toString();// перпеворачиваем строку и приводим ее в String
        System.out.println(str.equalsIgnoreCase(rev)); // сверяем строки без учета регистра
        */
        /*//Реализуйте метод, вычисляющий факториал заданного натурального числа.
        int value=3;
        BigInteger b=new BigInteger("1");
        for (int i=1;i<=value;i++) {
            b = b.multiply(BigInteger.valueOf(i));//BigInteger запись умножения b*i при чем i тоже приводим к данному виду
        }
        System.out.println(b);
         */
       /* //Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный
        // в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
        int[] a, b, c;
        a = new int[]{7, 9, 12};
        b = new int[]{5, 8, 11, 12,15};
        c = new int[a.length+b.length];
        int k = 0, i = 0, j = 0;
        for (k = 0; k<c.length; k++) {
            if (i>a.length-1){
                c[k]=b[j++];
            }else if (j>b.length-1){
                c[k]=a[i++];
            }else if (a[i]<b[j]){
                c[k]=a[i++];
            }else {
                c[k]=b[j++];
            }
        }
        System.out.println(Arrays.toString(c));
        */
        /*
// разделение текста по ролям
        String[] roles=new String[] {"12","34","56","123"};
        String[] textLines=new String[]{"34:hello","12:hi","12:how","34:","56:qwerty","123:repeat"};
        int i,j;
        StringBuilder sb=new StringBuilder();//создание буффера для сбора подстрок
        for (i=0;i< roles.length;i++){
            for (j=0;j<textLines.length;j++){
                String[] s=textLines[j].split(":",2);//разделил на 2 части роль и текст
                if(s[0].equals(roles[i]))
                sb.append((j+1)+")"+s[1].toString()+'\n');//добавление в буффер подстроки

            }
            System.out.println('\n'+roles[i].toString()+":"+'\n'+sb.toString());
            sb.setLength(0);//очистка буффера
        }

         */
        //тест про робота
        Robot robot = new Robot(0,0, Direction.DOWN);
        moveRobot(robot, -10, 20);
    }
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }
    public static void moveRobot(Robot robot, int toX, int toY) {
        boolean flag=true;
        while(flag){
            if(robot.getDirection()==Direction.UP){
                if(toY>=0)
                    while (robot.getY()!=toY)
                        robot.stepForward();
            }
            if(robot.getDirection()==Direction.DOWN){
                if(toY<=0)
                    while (robot.getY()!=toY)
                        robot.stepForward();
            }
            if(robot.getDirection()==Direction.RIGHT){
                if(toX>=0)
                    while (robot.getX()!=toX)
                        robot.stepForward();
            }
            if(robot.getDirection()==Direction.LEFT){
                if(toX<=0)
                    while (robot.getX()!=toX)
                        robot.stepForward();
            }
            robot.turnRight();
            if (robot.getX()==toX && robot.getY()==toY)
                flag=false;
        }

    }

}



