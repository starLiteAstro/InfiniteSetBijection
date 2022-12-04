import java.util.Arrays;
public class InfiniteBijectionSets {
    public static void main(String args[]) {
        int naturals = -1; // Natural numbers to map to each set
        int runs = 0; // Number of runs the infinite loop will take
        int[] emptySet = new int[] {}; // Empty set
        int[] oneSet = new int[] {0}; // 1-cardinality set
        int[] twoSet = new int[] {0,1}; // 2-cardinality set
        int[] threeSet = new int[] {0,1,2}; // 3-cardinality set
        for(;;) { // Run infinite loop
            if (runs % 3 == 1) { // Remainder 1 mod 3 = Print 1-cardinality set
                naturals += 1;
                System.out.println(naturals + ": " + Arrays.toString(oneSet));
                oneSet[0] += 1; // Increment element
            }
            else if (runs % 3 == 2) { // Remainder 2 mod 3 = Print 2-cardinality set
                if (twoSet[0] + 1 != twoSet[1]) { // If difference between first and second element greater than 1
                    for (int i = 1; i < twoSet[1]; i++) {
                        naturals += 1;
                        System.out.println(naturals + ": " + Arrays.toString(twoSet));
                        twoSet[0] = i; // Increment first element up to second element - 1
                    }
                }
                naturals += 1;
                System.out.println(naturals + ": " + Arrays.toString(twoSet));
                twoSet[1] += 1; // Increment second element
                twoSet[0] = 0; // Reset first element back to 0
            } else { // Otherwise, print 3-cardinality set
                if (threeSet[1] + 1 != threeSet[2]) { // If difference between second and third element greater than 1
                    for (int i = 1; i < threeSet[2]; i++) { 
                        if (threeSet[0] + 1 != threeSet[1]) {
                            for (int j = 1; j < threeSet[1]; j++) {
                                naturals += 1;
                                System.out.println(naturals + ": " + Arrays.toString(threeSet));
                                threeSet[0] = j; // Increment first element up to second element - 1
                            }
                        }
                        naturals += 1;
                        System.out.println(naturals + ": " + Arrays.toString(threeSet));
                        threeSet[1] += 1; // Increment second element
                        threeSet[0] = 0; // Reset first element back to 0
                    }
                }
                if (runs == 0) { // If first run, print empty set
                    naturals += 1;
                    System.out.println(naturals + ": " + Arrays.toString(emptySet));
                }
                if (runs == 3) { // If fourth run, print possible first 3-cardinality set
                    naturals += 1;
                    System.out.println(naturals + ": " + Arrays.toString(threeSet));
                }
                if (runs >= 1) { // On each run apart from the first, reset/increment values
                    threeSet[2] += 1; // Increment third element
                    threeSet[1] = 1; // Reset second element back to 1
                    threeSet[0] = 0; // Reset first element back to 0
                }
            }
            runs += 1;
        }
    }
}
