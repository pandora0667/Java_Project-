import java.util.Scanner;

/**
 * Created by jusk2 on 2017-03-03.
 */
public class SortingMain {
  public static void main(String[] args) {
    GenericSorting<Character> genericSortingCharacter = new GenericSorting();
    GenericSorting<Integer> genericSortingInteger = new GenericSorting();
    GenericSorting<Double> genericSortingDouble = new GenericSorting();

    Character[] arrayChar = {'E', 'Q', 'A', 'G', 'I'};
    Integer[] arrayInt = {100, 25, 1, 5, 87};
    Double[] arrayDouble = {3.14, 2.34, 15.6, 9.78};
    Scanner scanner = new Scanner(System.in);

    genericSortingCharacter.setT(arrayChar);
    genericSortingInteger.setT(arrayInt);
    genericSortingDouble.setT(arrayDouble);

    System.out.println("JAVA Generic Sorting V1.0");
    System.out.println("| 1. 오름차순 | 2. 내림차순 | 3. 나가기 ");
    int function = scanner.nextInt();

    switch (function) {
      case 1:
        genericSortingCharacter.ascending();
        genericSortingInteger.ascending();
        genericSortingDouble.ascending();
        break;
      case 2:
        genericSortingCharacter.descending();
        genericSortingInteger.descending();
        genericSortingDouble.descending();
        break;
      default:
    }
  }
}