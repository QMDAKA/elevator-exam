import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int solution(int[] A, int[] B, int N, int M, int X, int Y) {
        int[] setOfSelectedFloor = new int[M+1];

        int countUniqueSelectedFloor = 0;
        int result = 0;
        int waitingGuest = N;
        int currentWeightInElevator = 0;
        int currentGuestInElevator = 0;
        for (int i = 0; i < N; i++) {
            currentWeightInElevator += A[i];
            currentGuestInElevator++;
            if (currentGuestInElevator > X || currentWeightInElevator > Y) {
                result += countUniqueSelectedFloor + 1 ;
                countUniqueSelectedFloor = 0;
                setOfSelectedFloor = new int[M+1];
                currentGuestInElevator = 0;
                currentWeightInElevator = 0;
                i--;
            } else {
                waitingGuest--;
                if(setOfSelectedFloor[B[i]] == 0) {
                    setOfSelectedFloor[B[i]] = 1;
                    countUniqueSelectedFloor++;
                }
            }
            if (waitingGuest == 0) {
                result += countUniqueSelectedFloor + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ResourcesScanner resourcesScanner = new ResourcesScanner("resources.txt");
        System.out.println(solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY()));
    }
}
