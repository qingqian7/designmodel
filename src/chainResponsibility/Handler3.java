package chainResponsibility;

import chainresponsibility2.Hand;

@Hand
public class Handler3 implements Handler{

    private Handler next;

    @Override
    public int handleRequest(int number) {
        if(number > 10 && number <20){
            return 10;
        }else{
            if(next == null){
                throw new NullPointerException("next  不能为空");
            }
            return next.handleRequest(number);
        }
    }

    @Override
    public void setNext(Handler handler) {
        next = handler;
    }


}
