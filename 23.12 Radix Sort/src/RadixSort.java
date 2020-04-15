/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rocke
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RadixSort {
   public static void main(String[] args) {
       //holds the rando numbers
    int[] randint=new int[1000000];
    Random rn=new Random();

    //loads them in here
    for(int i=0;i<1000000;i++)
    {
            //output configuration
        randint[i]=rn.nextInt(1000);//you can change the max vlue of random number here
        System.out.print(randint[i]+" ");
    }//end of for loop
    rdxsort(randint);//function call
    System.out.println("\nSorted Radix List Is As Follows:\n\n");//funky fresh sorted list output

    for(int i=0;i<1000000;i++)
    {
        System.out.print(randint[i]+" ");
    }//end of for loop
}//end of main
   
   
    public static void rdxsort(int[] a) {
        final int RADIX = 1000000;//constant
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];


        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }//end of for loop
        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {//while maxlength is false
            maxLength = true;
            // split input between lists
            for (Integer i : a) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                maxLength = false;//continues while loop until broken 
                }//end of if
            }//end of for
            // empty lists into a array
            int ax = 0;
            for (int b = 0; b < RADIX; b++) {
                //start of a for-each loop
                for (Integer i : bucket[b]) {
                a[ax++] = i;
                }//end of nested for loop
            bucket[b].clear();
            }//end of for loop
            // move to next digit
            placement *= RADIX;
        }//end of while loop
    }
    }
