/**
 * Created by jusk2 on 2017-02-12.
 */

import java.io.FileInputStream;
import java.util.Scanner;
//import javazoom.jl.player.Player;


public class MusicMain {
  public static void main(String[] args) {
    Music music = new Music();
    Scanner scanner = new Scanner(System.in);
    boolean run = true;
    System.out.println(" ---------- 성원 Music Box V1.0 ---------- ");

    while(run) {
      System.out.println("1. 노래목록 2. 노래 재생 3. 나가기 ");
      int select = scanner.nextInt();
      switch(select) {
        case 1:
          music.titlePrint();
          System.out.println();
          break;
        case 2:
          System.out.print("음악 선택 : ");
          int songSelect = scanner.nextInt();
          String playSong = music.getMusicPlay(songSelect);

          try {
            FileInputStream e = new FileInputStream("D:\\Music\\" + playSong + ".mp3");
            Player playMp3 = new Player(e);
            playMp3.play();
          } catch (Exception var9) {
            System.out.println(var9);
          }
          break;
        case 3:
          System.out.println("이용해 주셔서 감사합니다.");
          run = false;
          break;
        default:
          System.out.println("다시 입력하세요");
      }
    }
  }
}
