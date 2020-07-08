package Exceptions;

public class InvalidObject extends Exception {
    public InvalidObject(String expectedObject, Object receivedObject) {
        super("The received object is invalid! Was expecting a " + expectedObject +
                " class and received a " + receivedObject.getClass().getName());
    }
}
