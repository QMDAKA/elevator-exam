import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

class ScannerException extends Exception {
    String errMsg;

    ScannerException(String errMsg) {
        this.errMsg = errMsg;
    }

    public String toString() {
        return ("ScannerException occured: " + errMsg);
    }
}

public class ResourcesScanner {
    private int[] A;
    private int[] B;
    private int N;
    private int M;
    private int X;
    private int Y;

    public int[] getA() {
        return A;
    }

    public void setA(int[] a) {
        A = a;
    }

    public int[] getB() {
        return B;
    }

    public void setB(int[] b) {
        B = b;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int[] initializeArrayByString(String arrayByString, int arrayLength, int maxValue) throws ScannerException {
        if (arrayByString.split(",").length != arrayLength) {
            throw new ScannerException("Array length and N argument is not same");
        }
        int[] tmpArr = new int[arrayLength];
        int index = 0;
        for (String s : arrayByString.split(",")) {
            tmpArr[index] = Integer.parseInt(s);
            if(tmpArr[index] < 1) {
                throw new ScannerException("Input value less than 1");
            }
            if (tmpArr[index] > maxValue) {
                throw new ScannerException("Input value greater than max value");
            }
            index++;
        }
        return tmpArr;
    }

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
                    case 'Y':
                        if(parseInt(data.substring(2)) < 1) {
                            throw new ScannerException("Input value less than 1");
                        }
                        this.setY(parseInt(data.substring(2)));
                        break;
                    case 'A':
                        this.setA(initializeArrayByString(data.substring(2), this.getN(), this.getY()));
                        break;
                    case 'B':
                        this.setB(initializeArrayByString(data.substring(2), this.getN(), this.getM()));
                        break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ResourcesScanner{" +
                "A=" + Arrays.toString(A) +
                ", B=" + Arrays.toString(B) +
                ", N=" + N +
                ", M=" + M +
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }
}
