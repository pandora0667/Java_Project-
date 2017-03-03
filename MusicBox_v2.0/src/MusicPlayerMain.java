import java.util.EventListener;
import java.util.Scanner;

/**
 * Created by jusk2 on 2017-02-28.
 */
public class MusicPlayerMain {
  public static void main(String[] args) {
    Preferences preferences = new Preferences();
    Scanner scanner = new Scanner(System.in);

    if (!preferences.checkPlayer()) {
      System.out.println("해당 디렉토리에 음악이 존재 하지 않습니다. 음악을 넣고 다시 시도 하세요.");
      return;
    }

    System.out.println(" ---------- 성원  Music Box V2.5 ---------- ");
    System.out.println("D:\\Music 위치에서 MP3를 읽어오고 있습니다....");
    System.out.println("해당 위치에 있는 음악은 다음과 같습니다.");
    System.out.println();

    for (int i = 0; i< preferences.getSongTitles().length; i++)
      System.out.println(preferences.getSongTitles()[i]);

    System.out.println("-------------------------------------------");
    System.out.println("재생목록을 생성합니다.....");
    preferences.playListCreate();
    System.out.println("기본 재생목록이 생성되었습니다.");

    boolean run = true;
    while (run) {
      System.out.println();
      System.out.println("원하시는 기능을 선택하세요.");
      System.out.println("| 1. 재생목록 | 2. 선택재생 | 3. 전체재생 | 4. 재생목록 갱신 | 5. 나가기");
      int function = scanner.nextInt();

      switch (function) {
        case 1:
          preferences.playListPrintAll();
          break;

        case 2:
          boolean run2 = true;
          System.out.print("원하는 곡을 선택하세요 -> ");
          int select = scanner.nextInt()-1;

          while (run2) {
            if (preferences.findTitle(select) != null) {
              String play = preferences.findTitle(select);
              System.out.println(play + "을(를) 재생합니다.");
              System.out.println();
              PlayMusic playMusic = new PlayMusic(play);
              playMusic.start();

              System.out.print("| 1. 다음곡 | 2. 이전곡 | 3. 나가기 |  ");
              int stop = scanner.nextInt();

              // 중복코드 해결 요망
              switch (stop) {
                case 1:
                  select++;
                  preferences.findTitle(select);
                  playMusic.isInterrupted();
                  playMusic.musicStop();
                  break;
                case 2:
                  select--;
                  preferences.findTitle(select);
                  playMusic.isInterrupted();
                  playMusic.musicStop();
                  break;
                default:
                  playMusic.isInterrupted();
                  playMusic.musicStop();
                  run2 = false;
              }
            } else {
              System.out.println("재생할 곡이 없습니다.");
              run2 = false;
            }
          }
          break;

        case 3:
          boolean run3 = true;
          select = 0;
          while (run3) {
            if (preferences.findTitle(select) != null) {
              String play = preferences.findTitle(select);
              System.out.println(play + "을(를) 재생합니다.");
              System.out.println();
              PlayMusic playMusic = new PlayMusic(play);
              playMusic.start();
              select++;

              try {
                playMusic.join();
                } catch (InterruptedException e) {
              }
//
//              System.out.println("1. 나가기");
//                int stop = scanner.nextInt();
//                if (stop == 1) {
//                  playMusic.isInterrupted();
//                  playMusic.musicStop();
//                  run3 = false;
//              }

            } else {
              System.out.println("재생을 완료했습니다.");
              run3 = false;
            }
          }
          break;

        case 4:
          preferences.directorySearcher();
          if (!preferences.checkPlayer()) {
            System.out.println("디렉토리에 음악이 없습니다. 추가하고 다시 실행하세요.");
            return;
          }
          preferences.playListCreate();
          System.out.println("재생목록이 갱신되었습니다.");
          break;

        case 5:
          System.out.println("이용해 주셔서 감사합니다.");
          run = false;
          break;

        default :
          System.out.println("잘못된 입력값입니다. 다시 시도하세요.");
      }
    }
  }
}
