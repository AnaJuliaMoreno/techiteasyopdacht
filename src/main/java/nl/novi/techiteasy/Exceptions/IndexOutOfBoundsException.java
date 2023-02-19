package nl.novi.techiteasy.Exceptions;

public class IndexOutOfBoundsException extends RuntimeException{

    public IndexOutOfBoundsException(){
        super();
    }

    public IndexOutOfBoundsException(String message){
        super(message);
    }
}
