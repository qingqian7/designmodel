package chainresponsibility2;

public class Client {
    private HandlerContext context;
    public static void main(String [] args) throws ClassNotFoundException {
        HandlerContext context = new HandlerContext();
        context.initContext();
        Handler handler =context.getHandler();
        if(handler != null){
            System.out.println(handler.handlerRequest(15));
        }
    }
}
