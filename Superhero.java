import java.util.Scanner; 
public class Superhero 
{
    private String name; 
    private String group; 
    private double strength; 
    private int health; 
    private boolean isDead; 
    private String power; 
    private int combo = 0;  
    public Superhero ()
    {
        name = "Iron Man"; 
        group = "Avengers"; 
        strength = 7.5; 
        health = 100;  
        isDead = false; 
        power = "Fly and Suit"; //not necessary, but nice to know 
    }
    public Superhero (String name, String group, double strength, 
                        int health, boolean isDead, String power)
    {
        this.name = name; 
        this.group = group; 
        this.strength = strength;
        this.health = health; 
        this.isDead = isDead; 
        this.power = power; 
    }
    public void setPower (String power) 
    {
        this.power = power; 
    }
    public void setStrength (double strength) 
    {
        this.strength = strength; 
    }
    public void setHealth (int health)
    {
        this.health = health; 
    }
    public String getPower ()
    {
        return power;
    }
    public double getStrength ()
    {
       return strength; 
    }
    public int getHealth ()
    {
        return health; 
    }
    public String getName ()
    {
        return name; 
    }
    public void hitVillain (Superhero villain)  
    {
        String update = new String (); 
        Scanner input = new Scanner (System.in); 
        System.out.println ("How do you want inflict damage on the villain? (hit or kick)"); //see which method of attack 
        String method = input.next();
        if (method.toUpperCase().equals("HIT")) //change to switch statements 
        {
            villain.setHealth(villain.getHealth()-((int)Math.pow(strength, 2)*5)); 
            //how do i make it so it is whatever superhero is up next 
            combo++; 
            System.out.println ("Thanos Health: " + villain.getHealth()); //show Thanos's health as an update
        }
        else if (method.toLowerCase().equals("kick"))
        {
            villain.setHealth(villain.getHealth()-20);
            combo+=2; 
            System.out.println("Thanos Health: " + villain.getHealth());
        }
    }
    //do for block attack you ask the user a question if they guess a number
    //two tries, give a hint after an answer
    public void hitVillain (Superhero helper, Superhero villain) 
    {
        villain.setHealth(villain.getHealth()-((int)Math.pow(strength + helper.getStrength(), 2)* 2));
    }
    public boolean blockVillain (Superhero villain)  
    {
        Scanner input = new Scanner(System.in);
        System.out.println ("To block an attack, you need to guess the right number.");
        int numberToGuess = (int)(Math.random()*11) +1; //random number for user to guess 
        for (int i = 0; i < 2; i++) //two guesses //i guess i can do a do while loop here OPINIONS PLS
        {
            System.out.println ("Guess a number between 1 and 10"); 
            int guess = input.nextInt(); 
            if (guess == numberToGuess)
            {
                System.out.println ("You blocked him! Good job!");
                return true;  
            }
            else if (guess > numberToGuess) 
            {
                System.out.println ("The number is less than that. Here's a hint: "); //give user a 2nd chance
                if (guess % 2 == 0)
                {
                    System.out.println ("Your number is even"); 
                }
                else 
                {
                    System.out.println ("Your number is odd");
                }
            }
            else if (guess < numberToGuess) 
            {
                System.out.println ("The number is greater than that. Here's a hint: ");
                if (guess % 2 == 0)
                {
                    System.out.println ("Your number is even");
                }
                else 
                {
                    System.out.println ("Your number is odd");
                }
            } 
        }
        System.out.println ("Block unsuccessful. Sucks." + "\n"); 
        return false; 
    }
    public void training()
    {
        int minutes = 100; 
        do 
        {
            System.out.println ("Nice muscles. Keep going!");
            minutes -= 10; 
        }
        while (minutes > 0);
    }
    public void SpecialAttack (Superhero villain, int groupCombo) //cause a lot more damage than normal 
    {
        if(groupCombo == 5 ||groupCombo == 6 || groupCombo == 7 || groupCombo == 8 || groupCombo == 9)
        {
            System.out.println ("Double damage."); 
            villain.setHealth(villain.getHealth()-40); //want to make his health 40 lower (kick is originally 20)
            System.out.println ("Thanos health :" + villain.getHealth()); 
            groupCombo = 0; //want to reset since it is used up 
        } 
        else if(groupCombo == 1 || groupCombo == 2 || groupCombo == 3 || groupCombo == 4) //ensure they can't use it all the time
        {
            System.out.println ("Your combo value is too little. You need at least five to activate.");
            System.out.println ("Tip: get your combo to 10 and you get to inflict triple damage.");
            System.out.println ("Damage will only be inflicted until combo 15."); 
            System.out.println ("Thanos health:" + villain.getHealth());
        } 
        else if(groupCombo >= 10 && groupCombo <= 15) //limit on how much build up 
        {
            System.out.println ("Triple damage!!!"); 
            villain.setHealth(villain.getHealth()-30); 
            groupCombo = 0;
        }
        
    }
    public void callForHelp () //if everyone is dying, call the backup justiceleague
    {
        help += 2; 
    }
    public int getCombo () //this was needed in order to execute the Special attack later on 
    {
        return combo; 
    }

    public String toString ()
    {
        String output = new String (); 
        output += name + " is part of the " + group + " group." + "\n" +
                  "Strength: " + strength + "\n" + "Health: " + health + "\n"
                  + "Power: " + power; 
                  if (isDead ==false)
                  {
                      output += "This hero is alive."; 
                  }
                  else 
                  {
                      output += "Welp, this hero is dead.";
                  }
       return output;             
    }  
}

