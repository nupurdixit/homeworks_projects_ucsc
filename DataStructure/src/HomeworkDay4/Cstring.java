package HomeworkDay4;
/**

 * File Name: Cstring.java 
 * Implements C String
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: CharArray.java Cstring
 */

class Cstring {
  private CharArray d; //Infinte array of char
  static IntUtil u = new IntUtil();
  
 
  //Cannot add any more data fields
  
  //WRITE ALL FUNCTIONS SO THAT ALL TESTS WILL PASS
  
  public Cstring(){
	  d=new CharArray();
  }
  
  public Cstring(char ch){
	  this();
	  d.set(0, ch);
	  d.set(1, '\0');
  }
  
  public Cstring(String str){
	  this();
	  strToCharArray(str);
  }
  
  public void strToCharArray(String str){
		
		char[] chArray=str.toCharArray();
		int chArrayLength=chArray.length;
		//System.out.println("Array length is: "+chArrayLength);
		for(int i=0;i<chArrayLength;i++){
			//System.out.println("chArray["+i+"] is: "+chArray[i]);
			d.set(i,chArray[i]);
		}
		d.set(chArrayLength, '\0');
  }
  
  
  public void pLn(String t){
	  System.out.println();
	  char[] ch=t.toCharArray();
	  for(int i=0;i<t.length();i++){
		  System.out.print(ch[i]);
	  }
	 
	  for(int i=0;i<d.size();i++){
		  System.out.print(d.get(i));
	  }
  }
  
  
  public void reverse(){
	  int i = 0 ;
	    int j = d.size() - 1 ;
	    while (i < j) {
	      d.swap(i,j) ;
	      ++i ;
	      --j ;
	    }
	  
  }
  
  /*
  public Cstring add(String string){
	  
  }
  
  public void append(String string ){
	  
  }
  
  public boolean isEqual(){
	  
  }
  
   public Cstring clone(){
	   Cstring c=new Cstring();
	   Cstring d=c;   
	   return d;
   }
 
  */
  //CANNOT CHANGE ANYTHING BELOW 
  private static void testBasic() {
    Cstring a = new Cstring('b') ;
    a.pLn("a = ") ;
    Cstring b = new Cstring('7') ;
    b.pLn("b = ") ;
    Cstring c = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    c.pLn("c = ") ;
    Cstring d = c.clone() ;
    d.pLn("d = ") ;
    Cstring e = new Cstring("A quick brown fox junped over a lazy dog") ;
    e.pLn("e = ") ;
    Cstring f = new Cstring("Gateman sees name garageman sees nametag") ;
    f.pLn("f =  ") ;
    f.reverse() ;
    f.pLn("f' = ") ;
  }
  
  
  private static void testAdd() {
    Cstring a = new Cstring("UCSC") ;
    Cstring b = new Cstring("Extension") ;
    Cstring c = a.add(b) ;
    a.pLn("a = ") ;
    b.pLn("b = ") ;
    c.pLn("c = ") ;
    Cstring d = c.add("USA") ;
    d.pLn("d = ") ;
    a.append(b) ;
    a.pLn("a+b = ") ;
    a.append("World") ;
    a.pLn("a+b+World = ") ;
  }
  
  private static void testEqual() {
    Cstring a = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    a.pLn("a = ") ;
    Cstring b = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    b.pLn("b = ") ;
    u.myassert(a.isEqual(b)) ;
    Cstring c = new Cstring("12345678901234567890123456789012345678901234567890123456789") ;
    c.pLn("c = ") ;
    u.myassert(a.isEqual(c) == false) ;
  }
  
  private static void testBench() {
    System.out.println("-----------Basic----------------");
    testBasic() ;
    System.out.println("-----------Addition----------------");
    testAdd() ;
    System.out.println("-----------Equal----------------");
    testEqual() ;
  }
  
  public static void main(String[] args) {
    System.out.println("Cstring.java");
    testBench();
    System.out.println("Done");
  }
}