import java.io.IOException;
import java.rmi.server.ExportException;

public class Father {
    //Runtime (unchecked) exceptions can be call without handling
    public Father() {
        throw new RuntimeException();
    }

    //Compile-time (checked) exceptions have to be handled -> caller need to handle checked exception so there is no "catch" block (replaced with "throws" keyword)
    public Father(boolean checkedException) throws IOException,ArithmeticException {
        if(checkedException){
            throw new IOException();
        } else {
            throw new ArithmeticException();
        }
    }
}
