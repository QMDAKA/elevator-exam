import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws ScannerException {
        Elevator elevator = new Elevator();
        ResourcesScanner resourcesScanner = new ResourcesScanner("resources.txt");
        System.out.println("Total number of stops: " + elevator.solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY()));
    }
}
