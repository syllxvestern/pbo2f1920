/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;

/**
 *
 * @author RuminazVlntine
 */
public abstract class Zombie implements Destroyable {
protected int health,level;

public abstract void heal();
public abstract void destroyed();
    
 public String getZombieInfo(){
     return "Health = "+health+"\n"+
             "Level = "+level+"\n";
     
 }    
    
}
