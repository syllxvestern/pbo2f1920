/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.percobaan3;

/**
 *
 * @author RuminazVlntine
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
public class DemoHashMap {
    public static void main(String[] args) {
        HashMap hMapItem = new HashMap();
        hMapItem.put("1","Biskuit");
        hMapItem.put("2","Shampoo");
        hMapItem.put("3","Soap");
        System.out.println(hMapItem);
        
//        Collection mCollection = hMapItem.values();
//        Iterator mIterator = mCollection.iterator();
//        while (mIterator.hasNext()){
//            System.out.println(mIterator.next());
//        }
        
        System.out.format("HashMap Item Total : %d\n\n",hMapItem.size());
        
        
        Object mObject = hMapItem.remove("1");
        System.out.format("%s remove from Hashmap\n",mObject);
        System.out.format("HashMap Item Total : %d\n",hMapItem.size());
        System.out.println(hMapItem);
        
        hMapItem.clear();
        System.out.format("HashMap Item Total : %d\n",hMapItem.size());
    }
}
