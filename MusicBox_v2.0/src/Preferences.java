import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by jusk2 on 2017-02-28.
 */

public class Preferences {
  // Field
  File path;
  private String[] songTitles;
  private String[] playList;

  // Constructor
  public Preferences() {
//    songTitles = null;
//    playList = null;
    path = new File("D:\\Music");
    directorySearcher();
  }

  // Class
  public void directorySearcher() { // 디렉토리 음악 정보 가져오기
    songTitles = path.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        return name.endsWith(".mp3");
      }
    });
  }

  public boolean checkPlayer() {  // 디렉토리에 음악이 없을 경우 프로그램 종료
    if (songTitles.length == 0) {
      return false;
    } else
      return true;
  }

  public String[] getSongTitles() {
    return songTitles;
  }

  public void playListCreate() {
    playList = songTitles;
  }

  public void playListPrintAll() {
    for (int i=0; i<playList.length; i++) {
      System.out.println(i+1 + "번 " + playList[i]);
    }
  }

  public String findTitle(int select) {
    if (select >= playList.length || select < 0)
      return null;
    else
      return playList[select];
  }
}


