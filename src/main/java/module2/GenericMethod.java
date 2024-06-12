package module2;

public class GenericMethod {

    public <T> void genericMethod(T data) {
        System.out.println(data);
    }

    public static void main(String[] args) {
        GenericMethod gMethod = new GenericMethod();
        gMethod.genericMethod(1);
        gMethod.genericMethod("yes");
    }
}
