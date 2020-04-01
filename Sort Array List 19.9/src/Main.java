
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rocke
 */
public class Main {
    public static void main(String[] args) {
	 	// Create a  list of Integers
	 ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            int z = randomFill();
            list.add(z);
        }
        System.out.println("random list "+list);
        SortArrayList.sort(list);
       System.out.println("sorted list "+list);
}

 public static int randomFill(){
        Random rand = new Random();
        int randomNum = rand.nextInt();
        return randomNum;
    }
}