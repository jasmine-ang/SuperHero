import java.util.ArrayList; 
import java.util.Scanner; 
public class InfinityWar 
{
    private ArrayList <Superhero> avengers; 
    private Superhero [] justiceleague; 
    private Superhero Thanos; //same variables, just not a superhero but using same class
    private int groupCombo = 0; //useful in fightVillain 
    public InfinityWar ()
    {
        avengers = new ArrayList <Superhero> (); 
        avengers.add(new Superhero()); //main team 
        avengers.add(new Superhero ("Captain America", "Avengers", 8, 100, false , "Super strong"));
        avengers.add(new Superhero ("Hulk", "Avengers", 9.5, 100, false , "Turns into big green guy"));
        avengers.add(new Superhero ("SpiderMan", "Avengers", 7.5, 100, false , "Super strong")); 
        avengers.add(new Superhero ("Thor", "Avengers", 10.0, 100, false , "Super strong")); 
        
        justiceleague = new Superhero [4]; //backup team 
        justiceleague [0] = new Superhero ("Batman", "DC", 7.0, 100, false, "Planning"); 
        justiceleague [1] = new Superhero ("The Flash", "DC", 9.0, 100, false, "Super speed");
        justiceleague [2] = new Superhero ("Wonderwoman", "DC", 8.0, 100, false, "Planning");
        justiceleague [3] = new Superhero ("Superman", "DC", 7.0, 100, false, "Planning"); 
        
        Thanos = new Superhero("Thanos", "Villain", 20, 2000, false, "Big bad guy"); 
        //again not sure if the last is necessary 
    }
    public String toString ()
    {
        String output = new String (); 
        output += "Our four Avengers in this class are... " + "\n";
        for (int i = 0; i < avengers.size(); i++)
        {
            output += avengers.get(i) + "\n";
        }
        output += "\n" + "Our DC members in this class are... " + "\n"; 
        for (Superhero s: justiceleague) 
        {
            output += s + "\n" + "\n";
        }
        output += "The hero with the greatest strength is: "; 
        double maxStrength = justiceleague[0].getStrength(); 
        int index1 = 0; 
        for (int i = 0; i < justiceleague.length; i++) 
        {
            if (justiceleague[i].getStrength() > maxStrength)
            {
                maxStrength = justiceleague[i].getStrength(); 
                index1 = i; 
            }
        }
        output += justiceleague[index1] + "\n"; 
        output += "The longest name is: "; 
        int nameMax = 0;
        int index2 = 0; 
        for (int i = 0; i < justiceleague.length; i++)
        {
            if (justiceleague[i].getName().length() > nameMax)
            {
                nameMax = justiceleague[i].getName().length(); 
                index2 = i; 
            }
        }
        output += justiceleague[index2].getName() + "\n";
        return output; 
    }
    public boolean superheroesAlive () 
    {
        int alive = 0; 
        for (int i = 0; i < avengers.size(); i++)
        {
            if (avengers.get(i).getHealth()>0)
            {
                alive ++; 
            }
        }
        if (alive == avengers.size())
        {
            return true; 
        }
        return false; 
    }
    public boolean fightVillain () 
    {
        String turn = "Player"; 
        while (Thanos.getHealth() > 0) //don't want to fight someone who is dead 
        {
            if (superheroesAlive() == false)
            {
                return false; 
            }
            for (int s = 0; s < avengers.size(); s++) //give each one hero a turn 
            {
                for (int i = 0; i < 2; i++) //two so that one i is attack and one is either block i want to switch so Thanos gets a change to attack 
                {
                    if (turn.equals("Player")) 
                    {
                        System.out.println("Group combo: " + groupCombo); //let the user know where they're at
                        Scanner input = new Scanner (System.in); 
                        System.out.println ("Do you want to hit or use special attack? (Type in 1 or 2 respectively.)"); 
                        int choice = input.nextInt();
                        switch (choice) 
                        {
                           case 1: 
                           avengers.get(s).hitVillain(Thanos); //a hero in the slot will attack Thanos  
                           turn = "Thanos"; 
                           groupCombo += avengers.get(s).getCombo(); 
                           break;
                           case 2: 
                           avengers.get(s).SpecialAttack(Thanos, groupCombo); 
                           turn = "Thanos"; 
                           groupCombo = 0; 
                           break; 
                        }
                    }
                    else 
                    {
                        boolean blockSuccessful = avengers.get(s).blockVillain(Thanos); //get a status using a method and setting it to a variable 
                        if (blockSuccessful) 
                        {
                            Thanos.setHealth(Thanos.getHealth()-5); 
                            System.out.println (Thanos.getHealth()); 
                            turn = "Player"; //to make sure it switches turns 
                        }
                        else 
                        {
                            Thanos.hitVillain(avengers.get(s)); 
                            turn = "Player"; 
                        }
                    }
                }
            }
        }
        return true; //Thanos will be dead if health is not greater than zero 
    }  
}




    


    
    
    
