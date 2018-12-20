package chainresponsibility2.handler;

import chainresponsibility2.Handler;
import chainresponsibility2.Hand;

@Hand(order = 1)
public class Handler1 implements Handler {

    public Handler next;
    @Override
    public int handlerRequest(int number) {
        if(number < 0)
            return -number;
        else{
            if(next == null){
                throw new NullPointerException("next 不能为空");
            }
         return  next.handlerRequest(number);
        }
    }



    @Override
    public void setNext(Handler handler) {
        next = handler;
    }


}
