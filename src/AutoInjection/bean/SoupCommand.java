package AutoInjection.bean;

public class SoupCommand implements Command{
    @Override
    public void operation() {
        System.out.println("来玩汤。。。。");
    }
}
