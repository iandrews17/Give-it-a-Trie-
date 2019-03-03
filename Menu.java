import java.io.*;
import java.util.*;


public class Menu extends Trie
{

 public static void main(String[] args){
  char c = 'a';
  int numLetters = 0;
  int count=0;
  int length;
  String startingletters;

  Scanner s= new Scanner(System.in);

  System.out.println("Press i insert values");
  System.out.println("Press q to quit");
  c=s.next().charAt(0);
  while(c!='q' || c != 'Q'){

  if(c=='i' || c == 'I'){
    while(count==0){
    System.out.println("Number of letters:");
    String numLettersString=s.next();
    numLetters = Integer.parseInt(numLettersString);
    if(!(numLetters<8) && !(numLetters>0)){
      System.out.println("Must be less than or equal to seven and greater than 0");
      continue;
      }
      count=1;
      break;
    }
    System.out.print("Letters: ");
    String str=s.next();
    while (str.length() != numLetters)
    {
      System.out.println("Please give the correct amount of letters: ");
      str = s.next();
    }
    char []array= new char[numLetters];
    for(int n=0; n<numLetters; n++){
      array[n]=str.charAt(n);
      array[n] = Character.toUpperCase(array[n]);
    }
    System.out.println("Enter the letter(s) you would like the word to start with");
    startingletters=s.next();
    startingletters = startingletters.toUpperCase();
    System.out.println("Enter the length of the word you would want to place on the board");
    String lengthString=s.next();
    length = Integer.parseInt(lengthString);


    Trie trie = new Trie();
    trie.createTrie();
    trie.checkForScores(startingletters, array, length, startingletters.length());
  }


  System.out.println("Press i insert values");
  System.out.println("Press r to restart");
  System.out.println("Press q to quit");
  c = s.next().charAt(0);
  }
 }

}
