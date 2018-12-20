package chainresponsibility2;

import factorymethod.LinkedList;

import java.util.LinkedHashMap;

public class Chain {
    private static LinkedHashMap<Integer,Handler> map = new LinkedHashMap<Integer, Handler>();
    public LinkedHashMap<Integer,Handler> getMap(){
        return map;
    }
}
