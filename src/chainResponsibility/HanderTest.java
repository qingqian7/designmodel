package chainResponsibility;



public class HanderTest {
    public void run(){
        System.out.println(this.getClass().getResource("").getFile());
        System.out.println(this.getClass().getResource("/chainResponsibility/test").getFile());
    }

    public static void main(String [] args){
        Handler1 h1 = new Handler1();
        Handler2 h2 = new Handler2();
        Handler3 h3 = new Handler3();
        h1.setNext(h2);
        h2.setNext(h3);
        System.out.println(h1.handleRequest(-5));
        System.out.println(h1.handleRequest(4));
        System.out.println(h1.handleRequest(13));
        //System.out.println(h1.handleRequest(21));
        new HanderTest().run();
    }

}
