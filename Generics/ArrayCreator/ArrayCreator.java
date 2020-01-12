package Generics.ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item){

        //Array.newInstance();
        T[] o = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < o.length; i++) {
            o[i] = item;
        }

        return o;
    }

    public static <T> T[] create(Class<T> tclass, int length, T item){
        T[] o = (T[]) Array.newInstance(tclass, length);
        for (int i = 0; i < o.length; i++) {
            o[i] = item;
        }

        return  o;
    }


}
