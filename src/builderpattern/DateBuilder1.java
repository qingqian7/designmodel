package builderpattern;

public class DateBuilder1 implements DateBuilder {
    private MyDate myDate;
    public DateBuilder1(MyDate myDate){
        this.myDate = myDate;
    }
    @Override
    public DateBuilder buildDate(int y, int m, int d) {
        myDate.date = y + "-" + m + "-"+ d;
        return this;
    }

    @Override
    public String getDate() {
        return myDate.date;
    }
}
