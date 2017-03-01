import javazoom.jl.player.Player;

import java.util.Scanner;

/**
 * Created by jusk2 on 2017-02-28.
 */
public class MusicPlayerMain {
  public static void main(String[] args) {
    Preferences preferences = new Preferences();
    Scanner scanner = new Scanner(System.in);
    boolean run = true;

    if (!preferences.checkPlayer()) {
      System.out.println("해당 디렉토리에 음악이 존재 하지 않습니다. 음악을 넣고 다시 시도 하세요.");
      return;
    }
    System.out.println(" ---------- 성원  Music Box V2.0 ---------- ");
    System.out.println("D:\\Music 위치에서 파일을 읽어오고 있습니다....");


    while (run) {
      System.out.println();
      System.out.println("원하시는 기능을 선택하세요.");
      System.out.println("| 1. 재생목록 | 2. 노래재생 |  3. 재생목록 수정 | 4. 재생목록 추가 | 5. 나가기");
      int function = scanner.nextInt();

      switch (function) {
        case 1:
          for (int i = 0; i< preferences.getMusicList().length; i++) {
            System.out.println(i+1 + "번 : " + preferences.getMusicList()[i]);
          }
          break;

        case 2:
          System.out.print("음악 번호 선택 : ");
          int songSelect = scanner.nextInt()-1;
          preferences.setTitle(songSelect);
          System.out.println(preferences.getTitle() + "을(를) 재생합니다.");

          PlayMusic playMusic = new PlayMusic(preferences.getTitle());
          playMusic.start();
          System.out.println(Thread.currentThread().getState());

          if (Thread.currentThread().getState() == Thread.currentThread().getState().RUNNABLE) {

            System.out.println("1. 정지");
            boolean run2 = true;
            while (run2){
              int select = scanner.nextInt();
              switch (select) {
                case 1:
                  playMusic.isInterrupted();
                  playMusic.musicStop();
                  run2 = false;
                  break;
                default:
              }
            }
          } else
            break;

        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        default :
          System.out.println("잘못된 입력값입니다. 다시 시도하세요.");
      }
    }
  }
}
