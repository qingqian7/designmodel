package midiator;
/*
中介者模式，相当于让中间件拥有两个解耦的对象，然后一个对象通过调用中间件的函数来间接触发另一个对象的方法
 */
public class MidiatorTest {
    public static void main(String [] args){
        PersistentDB persistentDB = new PersistentDB();
        PersistentFile persistentFile = new PersistentFile();
        Midiator midiator = new Midiator();
        midiator.setPersistentDB(persistentDB).setPersistentFile(persistentFile);
        persistentDB.getData("lijun",midiator);
    }
}
