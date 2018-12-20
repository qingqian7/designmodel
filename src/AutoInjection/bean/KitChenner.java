package AutoInjection.bean;

public class KitChenner implements Executor<Command> {
    @Override
    public void executor(Command command) {
        System.out.println("执行命令");
        command.operation();
    }
}
