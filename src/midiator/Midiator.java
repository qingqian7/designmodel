package midiator;

public class Midiator {
    PersistentFile persistentFile;
    PersistentDB persistentDB;

    public Midiator setPersistentFile(PersistentFile persistentFile){
        this.persistentFile = persistentFile;
        return this;
    }
    public Midiator setPersistentDB(PersistentDB persistentDB){
        this.persistentDB = persistentDB;
        return this;
    }
    public void notifyOthers(IPersistent persistent,Object data){
        if(persistent instanceof PersistentDB){
            persistentFile.getData(data);
        }
        if(persistent instanceof PersistentFile){
            persistentDB.getData(data);
        }
    }

}
