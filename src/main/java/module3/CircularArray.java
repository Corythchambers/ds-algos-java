package module3;

public class CircularArray {

    public static void main(String[] args) {
        String[] letters = {"A", "B", "C", "D"};
        int length = letters.length;
        for (int i = 0; i <= 7; i++) {
            System.out.print(letters[i % length] + " ");
        }
    }
}
