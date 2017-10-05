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

abstract public class Character{
  private int health;

  public abstract void damageDone(Character other, int number, String damageType);
  public abstract void Attack(ArrayList<Character> aliveContestants);



  //gets the hp amount of any given Character.
  public int getHpAmount(){
    return this.health;
  }

  //sets the inital hp of any given Character.
  public void InitalHp(int number){
    this.health = number;
  }

  //also you to edit the hp of any given Character
  public void EditHp(int number){
    this.health += number;
  }

  //determines if a Character is dead or not.
  public boolean deadness(){
    if(this.health <= 0){
      return true;
    }
    else{
      return false;
    }
  }

  //gives our match a kick-starts
  public static void main(String[] args){
    Arena game = new Arena();
    game.beginMatch();
  }
}
