package chainResponsibility;

import chainresponsibility2.Hand;

@Hand
public class Handler2 implements Handler {
    private int order;
    private Handler next;
    @Override
    public int handleRequest(int number) {
        if(number >0 && number <10){
            return number;
        }else{
            if(next == null){
                throw new NullPointerException("next 不能为空");
            }
            return next.handleRequest(number);
        }
    }

    @Override
    public void setNext(Handler handler) {
        next = handler;
    }
}
