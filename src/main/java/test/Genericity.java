package test;

public class Genericity<T> {

    private T key ;

    public Genericity(T key) {
        this.key = key;
    }

    public T getKey(){
        return this.key;
    }

    public static void main(String[] args){
        Genericity genericity = new Genericity("string");
        Genericity genericity1 = new Genericity(123);

    }
}
