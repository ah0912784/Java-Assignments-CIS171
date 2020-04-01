
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rocke
 */
public class shuffleArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        shuffle(list);
        System.out.println(list);
    }
    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int random = (int) (Math.random() * list.size());
            E temp = list.get(random);
            list.set(random, list.get(i));
            list.set(i, temp);
        }
    }
}
