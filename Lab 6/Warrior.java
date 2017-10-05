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

public class Warrior extends Character{
  private String dodge;
  private Random temp = new Random();
  private String damageType = "Slash";

  public Warrior(){
    //construvtor that calculates the amount of HP the WArrior has between 20 and 40.
    int health = temp.nextInt(20) + 20;
    super.InitalHp(health);
  }

  /*
  Attack method finds who has the highest health and isn't himself.
  it begins by marking himself as null, it then finds the contestent in aliveContestants
  with the highest, maximum health. And lastly if the attackTarget is neither
  null and this it will attack it.
  */
  public void Attack(ArrayList<Character> aliveContestants){
    Character attackTarget = this;
    while(attackTarget == null || attackTarget.deadness() || attackTarget == this){
      if(aliveContestants.size() == 1){
        if(aliveContestants.get(0) == this){
          attackTarget = null;
          break;
        }
        else if(aliveContestants.size() == 2){
          if(aliveContestants.get(0) == this && aliveContestants.get(1).deadness()
          || aliveContestants.get(1) == this && aliveContestants.get(0).deadness()){
            attackTarget = null;
            break;
          }
        }
      }
      else{
        int max = 0;
        for(Character contestent: aliveContestants){
          if(contestent != this && contestent.getHpAmount() > max){
            max = contestent.getHpAmount();
            attackTarget = contestent;
          }
        }
      }
    }
    if(attackTarget != null && attackTarget != this){
      System.out.println("Warrior <" + getHpAmount() + "> attacks " + attackTarget + " <" + attackTarget.getHpAmount() + ">");
      attackTarget.damageDone(this, temp.nextInt(7) + 10, damageType);
    }
  }

  public void damageDone(Character other, int number, String damageType){
    //amount of damage taken, if smash or slash, has 25% chance to dodge.
    if((damageType == "Smash") || (damageType == "Slash")){
      //gives a random value between 1 and 0.
      double chanceToDodge = Math.random();
      //if greater then 0.75 it will dodge
      if(chanceToDodge > 0.75){
        number = 0;
        dodge = " dodged and ";
      }
      //else it will fail to dodge.
      else{
        number = number;
        dodge = " failed to dodge and ";
      }
      EditHp(-number);
    }
    else{
      dodge = " ";
      EditHp(-number);
    }
    System.out.println("Warrior <" + getHpAmount() + ">" + dodge + "took " + number + " " + damageType + " damage, from " + other + " <" + other.getHpAmount() + ">.\n");
  }

  //gives the Character a name.
  public String toString(){
    return "Warrior";
  }
}
