/**
 * Created by jusk2 on 2017-02-12.
 */
public class Music {
  private String[] songTitle = new String[8];

  public Music() {
    this.songTitle[0] = "";
    this.songTitle[1] = "DJ Okawari-05-Flower Dance";
    this.songTitle[2] = "Sugar_Maroon 5_V [Deluxe Edition]";
    this.songTitle[3] = "로꼬(LOCO) - AWESOME (Feat. 박재범, GRAY) - 320k";
    this.songTitle[4] = "릴보이(Lil Boi),베이식(Basick)  - 연락해 (Feat. 화사) - 320k";
    this.songTitle[5] = "베이식(Basick) -  Stand Up (Feat. 마마무) - 320k";
    this.songTitle[6] = "씨잼 (C Jamm) & BewhY (비와이)_puzzle";
    this.songTitle[7] = "Animals_Maroon 5_V [Deluxe Edition]";
  }

  public String getMusicPlay(int select) {
    return this.songTitle[select];
  }

  public void titlePrint() {
    for(int i = 1; i < this.songTitle.length; ++i) {
      System.out.println(i + "번 " + this.songTitle[i]);
    }

  }
}
