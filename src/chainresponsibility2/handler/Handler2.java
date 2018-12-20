package chainresponsibility2.handler;

import chainresponsibility2.Handler;
import chainresponsibility2.Hand;

@Hand(order = 2)
public class Handler2 implements Handler {

    private Handler next;
    @Override
    public int handlerRequest(int number) {
        if(number >0 && number <10){
            return number;
        }else{
            if(next == null){
                throw new NullPointerException("next 不能为空");
            }
            return next.handlerRequest(number);
        }
    }

    @Override
    public void setNext(Handler handler) {
        next = handler;
    }

}
