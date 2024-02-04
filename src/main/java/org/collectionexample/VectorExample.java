package org.collectionexample;

import java.util.List;
import java.util.Vector;

public class VectorExample implements Runnable{
    List<Integer> vector;

    public VectorExample(List<Integer> vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for(int range = 0; range < vector.size(); range++){
            vector.set(range, vector.get(range) + 1);
        }
    }
}
