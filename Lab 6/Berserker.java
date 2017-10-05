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

public class Berserker extends Character{
  private String damageType = "Smash";

  public Berserker(){
    //calculates the amount of HP the Berserker has. which is 35.
    int health = 35;
    super.InitalHp(health);
  }

  public void Attack(ArrayList<Character> aliveContestants){
    //calculates the amount damage, which is 20, and finds which target to attack.
    //can be any even himself.
    Random temp1 = new Random();
    Character attackTarget = aliveContestants.get(temp1.nextInt(aliveContestants.size()));
    while(attackTarget == null || attackTarget.deadness()){
      attackTarget = aliveContestants.get(temp1.nextInt(aliveContestants.size()));
    }
    System.out.println("Berserker <" + getHpAmount() + "> attacks " + attackTarget + " <" + attackTarget.getHpAmount() + ">");
    attackTarget.damageDone(this, 20, damageType);
  }

  public void damageDone(Character other, int number, String damageType){
    //amount of damage taken, if Fire takes half dmg, else if slash takes double dmg
    if(damageType == "Fire"){
      number = number / 2;
      EditHp(-number);
    }
    else if(damageType == "Slash"){
      number = number * 2;
      EditHp(-number);
    }
    else{
      EditHp(-number);
    }
    System.out.println("Berserker <" + getHpAmount() + "> took " + number + " " + damageType + " damage, from " + other + " <" + other.getHpAmount() + ">.\n");
  }

  //gives the Character a name.
  public String toString(){
    return "Berserker";
  }
}
