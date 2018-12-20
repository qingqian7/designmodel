package midiator;

public class PersistentFile implements IPersistent {
    private Object data;
    @Override
    public void getData(Object data) {
        this.data = data;
        saveData(data);
    }

    @Override
    public void getData(Object data, Midiator midiator) {
        getData(data);
        midiator.notifyOthers(this,data);
    }

    @Override
    public void saveData(Object data) {
        System.out.println("saved to file :" + data);
    }
}
