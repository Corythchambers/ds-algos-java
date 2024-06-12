package module2;

// create a generic class
public class GenericClass<T> {
    //variable of type T
    private T data;

    public GenericClass(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public static void main(String[] args) {
        GenericClass<Integer> intObj = new GenericClass<>(5);
        System.out.println(intObj.getData());

        GenericClass<String> stringObj = new GenericClass<>("Yes");
        System.out.println(stringObj.getData());
    }
}
