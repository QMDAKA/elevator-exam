import org.junit.Test;

import static org.junit.Assert.*;

public class ElevatorTest {

    @Test
    public void solutionWithSampleTestCaseOne() throws ScannerException {
        Elevator elevator = new Elevator();
        ResourcesScanner resourcesScanner = new ResourcesScanner("./src/test/test_resources/sample_test_case_1.txt");
        int result = elevator.solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY());
        assertEquals(6, result);

    }
    @Test
    public void solutionWithSampleTestCaseTwo() throws ScannerException {
        Elevator elevator = new Elevator();
        ResourcesScanner resourcesScanner = new ResourcesScanner("./src/test/test_resources/sample_test_case_2.txt");
        int result = elevator.solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY());
        assertEquals(5, result);
    }
    @Test
    public void solutionWithSampleTestCaseThree() throws ScannerException {
        Elevator elevator = new Elevator();
        ResourcesScanner resourcesScanner = new ResourcesScanner("./src/test/test_resources/sample_test_case_3.txt");
        int result = elevator.solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY());
        assertEquals(10, result);
    }
    @Test(expected = ScannerException.class)
    public void solutionWithSampleTestCaseFour() throws ScannerException {
        Elevator elevator = new Elevator();
        ResourcesScanner resourcesScanner = new ResourcesScanner("./src/test/test_resources/sample_test_case_4.txt");
        int result = elevator.solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY());
        assertEquals(6, result);
    }
    @Test(expected = ScannerException.class)
    public void solutionWithSampleTestCaseFive() throws ScannerException {
        Elevator elevator = new Elevator();
        ResourcesScanner resourcesScanner = new ResourcesScanner("./src/test/test_resources/sample_test_case_5.txt");
        int result = elevator.solution(resourcesScanner.getA(), resourcesScanner.getB(), resourcesScanner.getN(), resourcesScanner.getM(), resourcesScanner.getX(), resourcesScanner.getY());
        assertEquals(6, result);
    }
}