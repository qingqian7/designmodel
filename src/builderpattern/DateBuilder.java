package builderpattern;

public interface DateBuilder {
    DateBuilder buildDate(int y,int m,int d);
    String getDate();
}
