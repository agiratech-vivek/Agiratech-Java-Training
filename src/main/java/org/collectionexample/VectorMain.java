package org.collectionexample;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorMain {
    public static void main(String[] args) {
        List<Integer> vector = new Vector<>(Collections.nCopies(10, 0));
        VectorExample vectorExample = new VectorExample(vector);
        Thread firstThread = new Thread(vectorExample);
        firstThread.start();
        Thread secondThread = new Thread(vectorExample);
        secondThread.start();
    }
}
