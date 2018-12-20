package chainresponsibility2;

public interface Handler {
    public int handlerRequest(int number);
    public void setNext(Handler next);
}
