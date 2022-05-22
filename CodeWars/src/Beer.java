import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Beer {
    private int value;

    public int getValue() {
        return value;
    }

    public Beer() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Beer(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println();
        for (int iter = 0; iter < 10; iter++) {

            System.out.println("iter = " + iter);
        }

        if (true) System.out.println("Beer.main");
        else {
        }
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("args = " + Arrays.deepToString(args));
        if (2 > 1) {
            System.out.println("args = " + args);
        }

        fdnsalkf();
        // fdnsal2kf();

        try (PrintStream printStream = System.out.printf("")) {
        }


//        за_лупа();
    }

//    public static void за_лупа(){
//
//    }

    private static void fdnsalkf() {
    }

    List<String> names = Arrays.asList("Roman", "Andrey");

}
