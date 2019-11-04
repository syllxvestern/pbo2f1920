/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RuminazVlntine
 */
public class Owner {
    public void pay(Payable p){
        System.out.println("Total payment = "+p.getPaymentAmount());
        if(p instanceof ElectricityBill){
            ElectricityBill eb = (ElectricityBill) p;
            System.out.println(""+eb.getBillInfo());
            
        }else if(p instanceof PermanentEmployee){
            PermanentEmployee pe = (PermanentEmployee) p;
            pe.getEmployeeInfo();
            System.out.println(""+pe.getEmployeeInfo());
        }
    }
    
    public void showMyEmployee(Employee e){
        System.out.println(""+e.getEmployeeInfo());
        if(e instanceof PermanentEmployee)
            System.out.println("You Have to pay her/him monthly!!!");
        else
            System.out.println("No need to pay him/her :)");
    }
}
