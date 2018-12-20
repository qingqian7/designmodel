package chainresponsibility2.handler;

import chainresponsibility2.Handler;
import chainresponsibility2.Hand;

@Hand(order = 3)
public class Handler3 implements Handler{
    private int order;
    private Handler next;

    @Override
    public int handlerRequest(int number) {
        if(number > 10 && number <20){
            return 10;
        }else{
            if(next == null){
                throw new NullPointerException("next  不能为空");
            }
            return next.handlerRequest(number);
        }
    }

    @Override
    public void setNext(Handler handler) {
        next = handler;
    }

}
