
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
public class SortArrayList {
   
    
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E currentMin;
		int currentMinIndex;

		for (int i = 0; i < list.size() - 1; i++) {
			// Find the minimum in the ArrayList
			currentMin = list.get(i);
			currentMinIndex = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}

			// Swap list.get(i) wtih list.get(currentMinIndex) if necessary;
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
}
}
