package module3;

import java.util.Arrays;

public class HashFunction {
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;


    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + (int) hash;
        return hash;
    }
    public String findKey(String key) {
        // Find the keys original hash key
        int arrayIndexHash = Integer.parseInt(key) % 29;
        while (theArray[arrayIndexHash] != "-1") {
            if (theArray[arrayIndexHash] == key) {
                //Found the key so return it
                System.out.println(key + " was found in index "
                        + arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            ++arrayIndexHash;
            if (arrayIndexHash == arraySize) {
                arrayIndexHash %= arraySize;
            }
        }
        // couldn't locate the key
        return null;
    }

    HashFunction(int size) {
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    public void displayTheStack() {
        int increment = 0;
        for (int m = 0; m < 3; m++) {
            increment += 10;
        }
        for (int n = 0; n < 71; n++) {
            System.out.print("-");
        }
        System.out.println();

        for (int n = increment - 10; n < increment; n++) {
            System.out.format("| %3s " + " ", n);
        }
        System.out.println("|");

        for (int n = 0; n < 71; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = increment - 10; n < increment; n++) {
            if (theArray[n].equals("-1")) {
                System.out.print("|    ");
            } else {
                System.out.print(String.format("| %3s " + " ", theArray[n]));
            }
            System.out.println("|");
            for (int m = 0; m < 71; m++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
