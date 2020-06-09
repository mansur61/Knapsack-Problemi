package com.mycompany.javaodev;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
 public class Item<E> implements Comparable {

	private double EdegerAlan;
	private double EAgirlikAlan;
       
	public double getWeigh(){return EAgirlikAlan;}
	public void setWeight(double weight){
		this.EAgirlikAlan=weight;
	}
	public double getValue(){return EdegerAlan;}

	public void setValue(double weight){
		this.EdegerAlan = weight;
	}

	public Item(double value, double weight){
		this.EdegerAlan = value;
		this.EAgirlikAlan = weight;

	}

	
	public ArrayList<Item> sort(ArrayList<Item> itemL){
          
            Collections.sort(itemL); // elemanlarına göre sıralama yapar küçükten büyüğe
             /* for(Item item : itemL){ 
                 System.out.println(item); 
              }*/ 
             for(int i=0;i<itemL.size();i++){
                    for(int j=0;j<itemL.size();j++){
                        
                      if (itemL.get(i).getWeigh() < itemL.get(j).getWeigh()){
                          
                        double temp = itemL.get(i).getWeigh();
                        itemL.get(i).setValue(itemL.get(j).getWeigh());
                        itemL.get(j).setValue(temp);                      
                        
                      }  
                    }
                } 
             System.out.println("Ağırlıklarına göre sıralanma"); 
             for(int i=0;i<itemL.size();i++){
               System.out.println(itemL.get(i).getWeigh());
           }
             
             
            return itemL;
	}

    @Override
    public int compareTo(Object itemOb) {
            
        Item digerItem = (Item)itemOb;
		int Sonuc = 0;
		if (digerItem != null)
		{
			if (this.EdegerAlan > digerItem.EdegerAlan)
				Sonuc = 1;
			else if (this.EdegerAlan == digerItem.EdegerAlan)
				Sonuc = 0;
			else
				Sonuc = -1;
		}
		
		return Sonuc;
    
        
    }
	
	
    



}