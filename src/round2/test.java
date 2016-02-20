package round2;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class test {
    public static void main(String[] args) {
    }

    void qSort(int[] num, int s, int e) {
        if (s < e) {
            int pivot = partition(num, s, e);
            qSort(num, s, pivot - 1);
            qSort(num, pivot + 1, e);
        }
    }

    /**
     * 3,1,2,2
     *
     * @param num
     * @param s
     * @param e
     * @return
     */
    private int partition(int[] num, int s, int e) {
        int tmp = num[s];
        while (s < e) {
            while (s < e && num[e] >= tmp)
                e--;
            num[s] = num[e];
            while (s < e && num[s] <= tmp)
                s++;
            num[e] = num[s];
        }
        num[s] = tmp;
        return s;
    }
}
