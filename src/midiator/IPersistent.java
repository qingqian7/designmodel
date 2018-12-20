package midiator;

public interface IPersistent {
    void getData(Object data);
    void getData(Object data,Midiator midiator);
    void saveData(Object data);
}
