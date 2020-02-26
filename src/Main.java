import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int solution(int[] A, int[] B, int N, int M, int X, int Y) {
        Set<Integer> setOfFloor = new HashSet<Integer>();
        int result = 0;
        int indexForTraversalArray = 0;
        int waitingGuest = N;
        int currentWeightInElevator = 0;
        int currentGuestInElevator = 0;
        while (waitingGuest != 0) {
            currentWeightInElevator += A[indexForTraversalArray];
            currentGuestInElevator++;
            if (currentGuestInElevator > X || currentWeightInElevator > Y) {
                result += setOfFloor.size() + 1;
                setOfFloor.clear();
                currentGuestInElevator = 0;
                currentWeightInElevator = 0;
            } else {
                waitingGuest--;
                setOfFloor.add(B[indexForTraversalArray]);
                indexForTraversalArray++;
            }
            if (waitingGuest == 0) {
                result += setOfFloor.size() + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ResourcesScanner resourcesScanner = new ResourcesScanner("resources.txt");
        System.out.println(solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY()));
    }
}
