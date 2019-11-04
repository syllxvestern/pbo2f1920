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
public class Barrier implements Destroyable{
 private int strength;
 
 public Barrier(int strength){
     this.strength = strength;
 }
 
 public void setStrength(int strength){
     this.strength = strength;
 }
 
 public int getStrength(){
     return strength;
 }
 
    @Override
    public void destroyed() {
    this.strength = this.strength - (this.strength*11/100);    
    }
    
 public String getBarrierInfo(){
     return "Barrier Strength = "+strength+"\n";
     
 }
    
}
