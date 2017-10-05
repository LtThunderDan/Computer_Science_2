/*
Created by Cassandra Graham and Daniel Williamson
CS 136L - Lab 6 - RPG
4/1/16

This Lab uses the abstract methods to create mutiple characters, some of the same type,
but all different from one another. This code creates a new Match each time it is ran.
It loops through several fights and after each searches for a last one standing and
declares it the winner, if there is one. If in the final fight the last attack ends up killing everyone
in the Arena, the last contestant to be alive will be declared winner.

The Character class contains the main method.
*/

import java.util.*;

public class Arena {
  //creation of ArrayList's
  //one to store our alive contestants, aliveContestants
  //one to store our dead contestants deadContestants
  //one to store our contestants and use to iterate through. workingContestants
  public ArrayList<Character> aliveContestants = new ArrayList<Character>();
  public ArrayList<Character> deadContestants = new ArrayList<Character>();
  public ArrayList<Character> workingContestants = new ArrayList<Character>();

  public Arena(){
    //creates 2 of each character and announces their arrival.
    Character b1 = new Berserker();
    System.out.println("A Berserker <" + b1.getHpAmount() + "> has joined!");
    Character b2 = new Berserker();
    System.out.println("A Berserker <" + b2.getHpAmount() + "> has joined!");
    Character w1 = new Warrior();
    System.out.println("A Warrior <" + w1.getHpAmount() + "> has joined!");
    Character w2 = new Warrior();
    System.out.println("A Warrior <" + w2.getHpAmount() + "> has joined!");
    Character m1 = new Mage();
    System.out.println("A Mage <" + m1.getHpAmount() + "> has joined!");
    Character m2 = new Mage();
    System.out.println("A Mage <" + m2.getHpAmount() + "> has joined!\n");

    //adds each contestant to our alive and working ArrayList's
    aliveContestants.add(b1);
    workingContestants.add(b1);
    aliveContestants.add(b2);
    workingContestants.add(b2);
    aliveContestants.add(w1);
    workingContestants.add(w1);
    aliveContestants.add(w2);
    workingContestants.add(w2);
    aliveContestants.add(m1);
    workingContestants.add(m1);
    aliveContestants.add(m2);
    workingContestants.add(m2);
}

  //while aliveContestants has more then one, it will begin a new fight.
  public void beginMatch(){
    while(aliveContestants.size() > 1){
      beginFight();
    }
  }

  //for each person in workingContestants, it will either attack, or if they are dead
  //it will add them to the deadContestants ArrayList and then remove them from our aliveContestants.
  public void beginFight(){
    for(Character person : workingContestants){
      if(person.deadness()){
        deadContestants.add(person);
        aliveContestants.remove(person);
      }
      else{
        person.Attack(getAliveContestants());
      }
    }
    System.out.println("**************END ROUND*****************");
    //then for each dude in deadContestants it will remove it from workingContestants
    //to match it to the aliveContestants ArrayList.
    for (Character dude : deadContestants){
      workingContestants.remove(dude);
      aliveContestants.remove(dude);
    }
    //called after each fight, endMatch will determine if the fight continues or ends.
    endMatch();
  }

  //ArrayList needed to keep track of who can be attacked that isn't already dead.
  private ArrayList<Character> getAliveContestants(){
    ArrayList<Character> aliveFighters = new ArrayList<Character>();
    for(Character contestant: aliveContestants){
      if(contestant.deadness() == false){
         aliveFighters.add(contestant);
       }
      else{
        continue;
      }
    }
    return aliveFighters;
  }

  /*
  endMatch is called after each fight and determines if there is only one person alive
  left in aliveContestants. If there is they are declared the winner. else if,
  there is more than one the fight will continue. and lastly else if there is no one
  left alive, it will find the last person added to the aliveContestants ArrayList
  which would be the last person to be alive.
  */
  public void endMatch(){
    if(aliveContestants.size() == 1){
      System.out.println("The winner is the " + aliveContestants.get(0) + "\n");
      //prints out each dead person after declaring the winner.
      for(Character person: deadContestants){
        System.out.println("The " + person + " is dead!");
      }
      System.out.println("\nGame over! Go home!\n");
      return;
    }
    else if(aliveContestants.size() > 1){
      System.out.println("The fight continues! ");
      //beginFight();
    }
    else if(aliveContestants.size() == 0){
      System.out.println(deadContestants.get( deadContestants.size() - 1 ) + " is the winner, but they all died!");
      System.out.println("\nGame over! Go home!\n");
      return;
    }
  }
}
