#Count total stop taken by elevator
## Function Description
Complete the function **solution**. This function returns the total stops taken by elevator to serve all the people

**solution** has the following parameters:
* int A[]: Array of weight of each people
* int B[]: Array of floor
* int N: Amount of people are waiting for the elevator
* int M: Top floor of hotel
* int X: Greatest possible number of people
* int Y: Elevator weight capacity  

## Solution function in Elevator class
* Solution function
  1. Time Complexity: O(N)
  2. Memory: O(N+M) 
```
public int solution(int[] A, int[] B, int N, int M, int X, int Y) {
        int[] setOfSelectedFloor = new int[M + 1];
        int countUniqueSelectedFloor = 0;
        int result = 0;
        int waitingGuest = N;
        int currentWeightInElevator = 0;
        int currentGuestInElevator = 0;
        for (int i = 0; i < N; i++) {
            currentWeightInElevator += A[i];
            currentGuestInElevator++;
            if (currentGuestInElevator > X || currentWeightInElevator > Y) {
                //Elevator starts to run
                result += countUniqueSelectedFloor + 1;
                countUniqueSelectedFloor = 0;
                setOfSelectedFloor = new int[M + 1];
                //Elevator at rest. Start with new passenger
                currentGuestInElevator = 1;
                currentWeightInElevator = A[i];
            }
            waitingGuest--;
            if (setOfSelectedFloor[B[i]] == 0) {
                setOfSelectedFloor[B[i]] = 1;
                countUniqueSelectedFloor++;
            }
            if (waitingGuest == 0) {
                result += countUniqueSelectedFloor + 1;
                break;
            }
        }
        return result;
    }
```
* Test by ElevatorTest
```
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
    .....
```

## ResourcesScanner 

* Support read resources file
```
public ResourcesScanner(String pathFile) throws ScannerException {
        File myObj = new File(pathFile);
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.substring(2).compareTo("") == 0) {
                    throw new ScannerException("Input field is blank");
                }
                switch (data.charAt(0)) {
                    case 'N':
                        if(parseInt(data.substring(2)) < 1) {
                            throw new ScannerException("Input value less than 1");
                        }
                        this.setN(parseInt(data.substring(2)));
                        break;
                    case 'M':
                        if(parseInt(data.substring(2)) < 1) {
                            throw new ScannerException("Input value less than 1");
                        }
                        this.setM(parseInt(data.substring(2)));
                        break;
                    case 'X':
                        if(parseInt(data.substring(2)) < 1) {
                            throw new ScannerException("Input value less than 1");
                        }
                        this.setX(parseInt(data.substring(2)));
                        break;
                        ....
``` 