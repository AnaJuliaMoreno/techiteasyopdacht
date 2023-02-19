package nl.novi.techiteasy.Exceptions;

public class NameLongerThan20Char extends RuntimeException {
    public NameLongerThan20Char() {
        super();
    }
    public NameLongerThan20Char(String message){
        super(message);
    }
}
