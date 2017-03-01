import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by jusk2 on 2017-03-01.
 */
public class PlayMusic extends Thread{

  private Player mp3;
  private String playTitle;
  private File path;

  public PlayMusic(String playTitle) {
    this.path = new File("D:\\Music");
    this.playTitle = playTitle;
  }

  public void run() {
    try {
      FileInputStream e = new FileInputStream(path + "\\" + playTitle);
      mp3 = new Player(e);
      mp3.play();
    } catch (Exception e) {
      System.out.println("오류코드 : " + e);
      System.out.println("재생 음악을 다시한번 확인하여 주세요. ");
    }
  }

  public void musicStop() {
    mp3.close();
  }

}
