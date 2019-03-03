pubblic class menu
{
 
 public static void main(String[] args){
  char c; 
  int numLetters; 
  int count=0
  int length; 
  char startingletter; 
  Scanner s= new Scanner(System.in); 

  while(c!='q'){ 
    System.out.println("Press i insert values"); 
    System.out.println("Press r to restart"); 
    System.out.println("Press q to quit"); 
    c=s.next(); 
  if(c=='i'){
    while(count==0){
    System.out.println("Number of letters:");
    numLetters=s.next(); 
    if(numLetters!<8&&numLetters!>0){
      System.out.println("Must be less than or equal to seven and greater than 0"); 
      continue; 
      }
      count=1; 
      break;  
    }
    System.out.print("Letters: ");
    String str=s.next();
    char []array= new char[i+1]; 
    for(int n=0; n<i+1; n++){
      array[n]=s[n]; 
    }
    System.out.println("Enter the letter you would like the word to start with");
    char startingletter=next(); 
    System.out.println("Enter the length of the word you would want to place on the board"); 
    length=s.next(); 


  }

  
  
  }
 }