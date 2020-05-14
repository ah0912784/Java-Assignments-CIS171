import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Integer.parseInt;


public class BlackJackFunctions {
    
    private final String[] baseDeck = {"c1","c2","c3","c4","c5","c6","c7","c8","c9","c10","cj",
    "cq","ck","s1","s2","s3","s4","s5","s6","s7","s8","s9","s10","sj","sq","sk",
    "d1","d2","d3","d4","d5","d6","d7","d8","d9","d10","dj","dq","dk","h1","h2",
    "h3","h4","h5","h6","h7","h8","h9","h10","hj","hq","hk"};
    
    private ArrayList<String> shuffledDeck = new ArrayList<>();
    private ArrayList<String> playerHand = new ArrayList<>();
    private ArrayList<String> dealerHand = new ArrayList<>();
    int baseDeckLength = baseDeck.length; 
    int pPoints = 0;
    int dPoints = 0;
    int wins = 0;
    int losses = 0;
   
    
    public void Deal() {
       
        for(int i = 0; i <= 1; i++) {
           String t = addCard();
           dealerHand.add(t);
           System.out.println("this is t "+t);
        }
            for(int i = 0; i <= 1; i++) {
                
           String s = addCard();
           System.out.println("this is s "+s);
           playerHand.add(s);
           
        }


    }
    public int calculatePoints(ArrayList<String> array, int points)
   {
       ArrayList ary = array;
       
        for (int i = 0; i < ary.size(); i++ ){
            System.out.print(ary);
            String s = (String) ary.get(i);
            char a = s.charAt(s.length()-1);
            String b = Character.toString(a);
           switch (a) {
               case '1':
                   points += 11;
                   break;
               case '0':
               case 'j':
               case 'q':
               case 'k':
                   points += 10;
                   break;
               default:
                   points += parseInt(b);
                   break;
           }
        }
        points = oneOrEleven(ary, points);
        return points;
    }
    public void newRound() {
        shuffledDeck.clear();
        playerHand.clear();
        dealerHand.clear();
    }
    public void Reset() {
        shuffledDeck.clear();
        playerHand.clear();
        dealerHand.clear();
        wins = 0;
        losses = 0;
    }
    public void Stay(){
        int cond;
        while (pPoints > dPoints ) {
            String a = addCard();
            dealerHand.add(a);
            cond = CheckForWin();
            
            if (dPoints > pPoints && dPoints <=21) {
                break;
            }
            
           
            
            
            
        }
    }
    
    public void Hit() {
        String s = addCard();
        playerHand.add(s);
        pPoints = calculatePoints(playerHand, pPoints);
   
    }
    public String addCard() {
        String s = new String();
        Random r = new Random();
   
        int x = r.nextInt(shuffledDeck.size());
           System.out.print(x);
        s = shuffledDeck.get(x);
        //System.out.println(shuffledDeck);
        shuffledDeck.remove(x);
        //System.out.println(shuffledDeck);
        System.out.println(s);
        return s;
    }
    public int CheckForWin() {
       
        int a = 0;
        if (pPoints > dPoints && pPoints <= 21) {
          wins++; 
          a = 0;
        }
        else if (pPoints < dPoints || pPoints > 21) {
          losses++;
          a = 1;
        } 
        else if ( pPoints > 21 && dPoints > 21) {
            //draw but both busted
          a = 2;
        }
        else if (dPoints == pPoints) {
            //draw
          a = 2;
        }
        else {
          a = 3;
            
        }
        
        return a;
    }
    public ArrayList loadDeck(){
        shuffledDeck.clear();
        for (int i = 0; i <= baseDeck.length-1; i++) {
            String s = baseDeck[i];
            shuffledDeck.add(s);
        }
        System.out.println(shuffledDeck);
        return shuffledDeck;
    }
    public ArrayList shuffle() {
       loadDeck();
        
        Collections.shuffle(shuffledDeck);
        return shuffledDeck;
    }
    public int hasAce(ArrayList ary) {
        int aces = 0;
        for (int i = 0; i < ary.size(); i++) {
            String s = (String) ary.get(i);
            char a = s.charAt(s.length()-1);
            if (a == '1') {
                aces++;
            }
        }
        return aces;
    }
    
    public int oneOrEleven(ArrayList<String> array, int points) {
        
        int aceNum = hasAce(array); 
        while (aceNum > 0 && points > 21) {
            points -= 10;
        }
             
         
        
        return points;
    } 
   
    public String getCardImage(int x, ArrayList<String> ary) {
       //System.out.println(ary);
       String s =  ary.get(x);
       String line = "cards_png/"+s+".png";
        return line;
    }
    public ArrayList<String> getDealerHand() {
        return dealerHand;
    }
    
    public ArrayList<String> getPlayerHand() {
        return playerHand;
    }
    public ArrayList<String> getshuffledDeck() {
        return shuffledDeck;
    }
}
