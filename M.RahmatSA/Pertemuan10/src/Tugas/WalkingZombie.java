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
public class WalkingZombie extends Zombie{
    
 public WalkingZombie(int health, int level){
     this.health = health;
     this.level = level;
 }
 
 @Override
 public void heal(){
     if (level == 1){
     this.health = this.health + (this.health*20/100); 
     }else if (level == 2){
         this.health = this.health + (this.health*30/100);
     }else if (level ==3){
         this.health = this.health + (this.health*40/100);
     }
     
 }
 
 @Override
     public void destroyed() {
     this.health = this.health - (this.health*20/100);   
    }
 
 @Override
 public String getZombieInfo(){
     String info = "Walking Zombie Data "+ "\n";
     info += super.getZombieInfo()+"\n";
     return info;
 }
}
