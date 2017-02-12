import java.util.Scanner;

/**
 * Created by jusk2 on 2017-02-12.
 */
public class CalenderMain {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CalenderPrint calenderPrint = new CalenderPrint();
    boolean run = true;

    System.out.println("JAVA Calender Print Project V.1.0");
    System.out.println();

    while (run){
      System.out.println("원하시는 기능을 선택하세요.");
      System.out.print("| 1. 현재시간 | 2. 현재 날자 | 3. 현재 달력 | 4. 나가기 |  ");
      int select = scanner.nextInt();

      switch (select) {
        case 1:
          System.out.println();
          System.out.println(calenderPrint.getTime());
          System.out.println();
          break;
        case 2:
          System.out.println();
          System.out.println(calenderPrint.getDate());
          System.out.println();
          break;
        case 3:
          System.out.println();
          System.out.println("|===================  " + calenderPrint.toString() + "|");
          System.out.println("|\t일\t 월\t 화\t 수\t 목\t 금\t 토\t |");
          System.out.println(calenderPrint.getCalender());
          System.out.println("|================================|");
          System.out.println();
          break;
        case 4:
          run = false;
          break;
        default:
          System.out.println();
          System.out.println("잘못된 입력값입니다. ");
          System.out.println();
      }
    }
  }
}
