import java.util.Arrays;
public class InfiniteBijectionSets {
    public static void main(String args[]) {
        int a1 = 0;
        int a2 = 0;
        int b2 = 1;
        int a3 = 0;
        int b3 = 1;
        int c3 = 2;
        int naturals = -1;
        int runs = 0;
        int[] oneSet = new int[] {a1};
        int[] twoSet = new int[] {a2,b2};
        int[] threeSet = new int[] {a3,b3,c3};
        for(;;) {
            if (runs % 3 == 0) {
                naturals += 1;
                System.out.println(naturals + ": " + Arrays.toString(oneSet));
                oneSet[0] += 1;
            }
            if (runs % 3 == 1) {
                if (twoSet[0] + 1 != twoSet[1]) {
                    for (int i = 1; i < twoSet[1]; i++) {
                        naturals += 1;
                        System.out.println(naturals + ": " + Arrays.toString(twoSet));
                        twoSet[0] = i;
                    }
                }
                naturals += 1;
                System.out.println(naturals + ": " + Arrays.toString(twoSet));
                twoSet[1] += 1;
                twoSet[0] = 0;
            }
            if (runs % 3 == 2) {
                if (threeSet[1] + 1 != threeSet[2]) {
                    for (int i = 1; i < threeSet[2]; i++) {
                        if (threeSet[0] + 1 != threeSet[1]) {
                            for (int j = 1; j < threeSet[1]; j++) {
                                naturals += 1;
                                System.out.println(naturals + ": " + Arrays.toString(threeSet));
                                threeSet[0] = j;
                            }
                        }
                        naturals += 1;
                        System.out.println(naturals + ": " + Arrays.toString(threeSet));
                        threeSet[1] += 1;
                        threeSet[0] = 0;
                    }
                }
                if (runs == 2) {
                    naturals += 1;
                    System.out.println(naturals + ": " + Arrays.toString(threeSet));
                }
                threeSet[2] += 1;
                threeSet[1] = 1;
                threeSet[0] = 0;
            }
            runs += 1;
        }
    }
}