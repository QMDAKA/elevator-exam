import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int solution(int[] A, int[] B, int N, int M, int X, int Y) {
        Set<Integer> setOfSelectedFloor = new HashSet<Integer>();
        int result = 0;
        int waitingGuest = N;
        int currentWeightInElevator = 0;
        int currentGuestInElevator = 0;
        for (int i = 0; i < N; i++) {
            currentWeightInElevator += A[i];
            currentGuestInElevator++;
            if (currentGuestInElevator > X || currentWeightInElevator > Y) {
                result += setOfSelectedFloor.size() + 1;
                setOfSelectedFloor.clear();
                currentGuestInElevator = 0;
                currentWeightInElevator = 0;
                i--;
            } else {
                waitingGuest--;
                setOfSelectedFloor.add(B[i]);
            }
            if (waitingGuest == 0) {
                result += setOfSelectedFloor.size() + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ResourcesScanner resourcesScanner = new ResourcesScanner("resources.txt");
        System.out.println(solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY()));
    }
}
