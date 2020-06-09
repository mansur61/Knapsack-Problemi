package com.mycompany.javaodev;
import java.util.ArrayList;
import java.util.*;
public class Knapsack {


	private double cantaAgirlik; // Çantanın kapasitesi
	public ArrayList<Item> items = new ArrayList<Item>();
	
	public Knapsack(double capacity){

		this.cantaAgirlik=capacity;
	}

	public double getCapacity(){
		return this.cantaAgirlik;
	}
	public void setCapacity(double capacity){
		this.cantaAgirlik=capacity;
	}

	public ArrayList<Item> getItems(){

		return this.items;
	}
        
	public void setItems(ArrayList<Item> item){
            double ekle=0.0;
            for(int i=0;i<item.size();i++){
                ekle = ekle + item.get(i).getWeigh();
                if (this.cantaAgirlik > ekle ){
                  this.items = item;
                 }
            }
           // System.out.println("setItems ,toplam :"+ekle);
            
		
	}
        
	public boolean pushItem(Item item){   
             double toplam=0.0;
            for(int i=0;i<this.items.size();i++){
                toplam = toplam + this.items.get(i).getWeigh();
            }
           // System.out.println("pushItem ,toplam :"+toplam);
		if(getCapacity() > toplam ){
			this.items.add(item);
			return true;
		}else{
                                      
                       // Aslında buraya item elemanları eklenmeli. Çantaya eklenmese bile.
			return false;	
		}		
	}
        
	public double getMaximumValue(ArrayList<Item> newItems){
            double toplam=0.0;
           // System.out.println("this.items.size() :"+newItems.size());
            for(int i=0;i<this.items.size();i++){
                toplam = toplam + this.items.get(i).getWeigh();
            }
           // System.out.println("toplam :"+toplam);
            if (this.cantaAgirlik > toplam ){
                
                for(int i=0;i<newItems.size();i++){
                    for(int j=0;j<newItems.size();j++){
                        
                      if (newItems.get(i).getValue() < newItems.get(j).getValue()){
                          
                        double temp = newItems.get(i).getValue();
                        newItems.get(i).setValue(newItems.get(j).getValue());
                        newItems.get(j).setValue(temp);                      
                        
                      }  
                    }
                    
                }                
                // Çanta da boş yer varsa, gelen en büyük değeri ekle.
                if(newItems.size() == 1){
                
                     this.setItems(newItems);
                }else{
                    this.items.add(newItems.get(0));
                }
               
                
              //  System.out.println("toplam2 :"+toplam);
                 return toplam;
                
            }else{
                 return toplam;
            }
           
                        
	}
        public ArrayList<Item> getMaximalItemSet(ArrayList<Item> newItems){
            double toplam=0.0;
            for(int i=0;i<this.items.size();i++){
                toplam = toplam + this.items.get(i).getWeigh();
            }
          
            if (this.cantaAgirlik > toplam ){
                
                for(int i=0;i<this.items.size();i++){
                    for(int j=0;j<this.items.size();j++){
                        
                      if (this.items.get(i).getValue() < this.items.get(j).getValue()){
                          
                        double temp = this.items.get(i).getValue();
                        this.items.get(i).setValue(this.items.get(j).getValue());
                        this.items.get(j).setValue(temp);                      
                        
                      }  
                    }
                } 
             
                 // Çanta da boş yer varsa, gelen en büyük değeri ekle.
               if(newItems.size() == 1){
                
                     this.setItems(newItems);
                }else{
                    this.items.add(newItems.get(0));
                }
                            
                 return this.items;
                
            }else{
                 return this.items;
            }
            
           
        }
        
}