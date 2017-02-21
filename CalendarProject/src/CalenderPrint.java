import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jusk2 on 2017-02-12.
 */

public class CalenderPrint {
  //field
  private Calendar calendar = Calendar.getInstance();
  private int hour;
  private int minute;

  //Constructor
  public CalenderPrint() {
    this.hour = 0;
    this.minute = 0;
  }

  //Class
  public String getTime() {
    hour = calendar.get(Calendar.HOUR);
    minute = calendar.get(Calendar.MINUTE);

    return hour + "시 " + minute + "분";
  }

  public String getDate() {
    Date now = new Date();
    SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
    return date.format(now);
  }

  public String getCalender() {
    StringBuilder returnCalender = new StringBuilder();
    calendar.set(Calendar.DATE, 1);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    int lastDay = calendar.getActualMaximum(Calendar.DATE);

    for (int i = 1; i < dayOfWeek; i++) {
      returnCalender.append("\t *");
    }
    for (int i = 1; i <= lastDay; i++) {
      int dayOfWeekCount = dayOfWeek;
      dayOfWeek++;
      returnCalender.append(" \t"+ i);

      if (dayOfWeekCount % 7 == 0)
        returnCalender.append("\n");
    }
    return returnCalender.toString();
  }

  @Override
  public String toString() {
    String year = Integer.toString(calendar.get(Calendar.YEAR));
    String month = Integer.toString(calendar.get(Calendar.MONTH)+1);

    return year + "년 " + month + "월 ";
  }
}
