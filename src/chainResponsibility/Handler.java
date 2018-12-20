package chainResponsibility;

public interface Handler {
    public int handleRequest(int number);
    public void setNext(Handler handler);
}
