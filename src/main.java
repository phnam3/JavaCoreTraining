import java.io.IOException;

public class main {
    public static void main(String[] args){
        // Exception not being handled but Son1 can still be initialized (runtime exception) -> code still compiled
//        Son son1 = new Son();

        // Exception being handle inside try/catch block (catch runtime exception)
        try {
            Son son2 = new Son();
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        // Exception not being handled hence cannot compile these lines (compile-time exception)
//        Son son3 = new Son(true);
//        Son son4 = new Son(false);

        // Exception being handled inside try/catch block
        try {
            Son son5 = new Son(true);
            // Comment out because son5 already throws another exception -> redundant
//            Son son6 = new Son(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
