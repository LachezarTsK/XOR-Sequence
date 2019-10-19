import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long numberOfQueries = scanner.nextLong();

    while (numberOfQueries-- > 0) {
      long lowerIndex = scanner.nextLong();
      long upperIndex = scanner.nextLong();
      long result = getResuts_XorSequence(lowerIndex, upperIndex);
      System.out.println(result);
    }
    scanner.close();
  }

  /**
   * The method applies the property that for any XOR sequence 
   * of type G(n) = A(0)xA(1)xA(2)xA(3)x ... A(n),
   * where "x" designates XOR operation, n>=0, 
   * and A(n) = A(0)xA(1)xA(2)xA(3)x ... A(n),  
   * it is always in force:
   *
   * if n%8=0 then G(n) = n; 
   * if n%8=1 then G(n) = n; 
   * if n%8=2 then G(n) = 2; 
   * if n%8=3 then G(n) = 2; 
   * if n%8=4 then G(n) = n+2; 
   * if n%8=5 then G(n) = n+2; 
   * if n%8=6 then G(n) = 0; 
   * if n%8=7 then G(n) = 0;
   *
   * File "Proof of properties of XOR Sequences" contains 
   * a detailed proof of the above properties.
   */
  private static long getInteger(long index) {
    long[] results = {index, index, 2, 2, index + 2, index + 2, 0, 0};
    return results[(int) (index % 8)];
  }

  /**
   * The method calculates the result of the XOR subsequence, 
   * applying the following property: 
   * The result of the XOR operation on any subsequence 
   * A(n)xA(n+1)xA(n+2)x...A(n+(m-1))xA(n+m) is always equal to
   * G(n-1)xG(n+m), where "x" designates XOR operation
   * and 1<=n, m<="number of elements in sequence".
   *
   * File "Proof of properties of XOR Sequences" contains 
   * a detailed proof of the above property.
   */
  private static long getResuts_XorSequence(long lowerIndex, long upperIndex) {
    long results_lowerIndex = getInteger(lowerIndex - 1);
    long results_upperIndex = getInteger(upperIndex);

    return results_lowerIndex ^ results_upperIndex;
  }
}
