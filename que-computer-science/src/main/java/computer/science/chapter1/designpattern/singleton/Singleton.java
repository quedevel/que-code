package computer.science.chapter1.designpattern.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Singleton {

    private static class SingleInstanceHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static synchronized Singleton getInstance(){
        return SingleInstanceHolder.INSTANCE;
    }
}
