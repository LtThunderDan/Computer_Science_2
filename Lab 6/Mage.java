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

public class Mage extends Character{

  private Random temp = new Random();
  private String damageType = "Fire";
  public Mage(){
    //calculates the amount of HP the mage has. between 10 and 50.
    int health = temp.nextInt(50) + 10;
    super.InitalHp(health);
  }

  public void Attack(ArrayList<Character> aliveContestants){
    //calculates the amount damage between 0-6. and attacks everyone in the arena. even himself.
    System.out.println("Mage <" + getHpAmount() + "> attacks everyone alive");
    for(Character attackTarget: aliveContestants){
      attackTarget.damageDone(this, temp.nextInt(7), damageType);
    }
  }

  public void damageDone(Character other, int number, String damageType){
    //amount of damage taken
    EditHp(-number);
    System.out.println("Mage <" + getHpAmount() + "> took " + number + " " + damageType + " damage, from " + other + " <" + other.getHpAmount() + ">.\n");
  }

  //gives the Character a name.
  public String toString(){
    return "Mage";
  }
}
