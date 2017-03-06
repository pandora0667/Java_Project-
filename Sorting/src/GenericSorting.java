
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jusk2 on 2017-03-03.
 */
public class GenericSorting<T> {
  // field
  private T[] t;

  // Constructor
  public GenericSorting() {
  }

  // Class
  public void setT(T[] t) {
    this.t = t;
  }

  public void ascending() {
    Arrays.sort(t);
    for (T element : t) {
      System.out.print(element +", ");
    }
    System.out.println();
  }

  public void descending() {
    Arrays.sort(t);
    for (int i=t.length-1; i>=0; i--) {
      System.out.print(t[i] + ", ");
    }
    System.out.println();

  }
}