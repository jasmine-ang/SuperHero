public class SuperheroTester 
{
    public static void main (String [] args) 
    {
        Superhero default1 = new Superhero (); 
        System.out.println (default1);
        System.out.println ("Iron Man's nickname is: " + default1.getName().substring(0,1) + "-Dog"); 
        Superhero Thor = new Superhero ("Thor", "Avengers", 10.0, 100, false, "God of Thunder"); 
        System.out.println (Thor); 
        System.out.println ("Thor's nickname is: " + Thor.getName().substring(0,1) + "-Dog"); 
    }
}


