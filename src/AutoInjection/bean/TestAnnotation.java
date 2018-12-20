package AutoInjection.bean;

import AutoInjection.AbstractInjection;

public class TestAnnotation {
    @AbstractInjection(value=KitChenner.class)
    private Executor<Command> executor;

    public Executor<Command> getExecutor(){
        return executor;
    }
}
