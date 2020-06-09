/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaodev;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author mansureminkaya
 */
public class Main{

	public static void main(String args[]){
                  
                 Knapsack cantaKapasite=new Knapsack(120.6);
                 System.out.println("Çantanın Kapasitesi : "+cantaKapasite.getCapacity());
                 Item parcalar= new Item(12.12,45.45);
                  ArrayList<Item> itemEkle=  new ArrayList<Item>();
                  itemEkle.add(new Item(3.5,69.7));
                  itemEkle.add(new Item(37.5,1.7));
                  itemEkle.add(new Item(34.5,10.7));
                  itemEkle.add(new Item(2.5,90.7));
                  
                  cantaKapasite.setItems(itemEkle); //Çantaya eleman ekle
                 
                  boolean durum =cantaKapasite.pushItem(new Item(34.5,4.7));
                 // System.out.println("durum :"+durum);
                  if(!durum){System.out.println("Kapasite Yetmiyor.");}
                 
                 double kontrol = cantaKapasite.getMaximumValue(itemEkle);
                 //System.out.println("kontrol :"+kontrol);                
                  if ( kontrol == cantaKapasite.getCapacity() ){
                      System.out.println("EŞİT");                      
                  }else if (kontrol > cantaKapasite.getCapacity() ){
                      System.out.println("Çanta Dolu.");
                  }else{
                      System.out.println("Çantaya Eklenebilir.");
                                    
                  }
                  //Çanta Elemanları göster
                  cantaElemanları(cantaKapasite);
                                 
                  // item elemanları
                  itemElemanları(parcalar,itemEkle);
                   

	}

    private static void cantaElemanları(Knapsack cantaKapasite) {
        
         ArrayList<Item> elemanlar= cantaKapasite.getItems();
            System.out.println("Çanta Elemanlarını Göster ");
             for(int i=0;i<elemanlar.size();i++){
               System.out.println(elemanlar.get(i).getValue() + " - " + elemanlar.get(i).getWeigh());
           }
    }

    private static void itemElemanları(Item parcalar, ArrayList<Item> itemEkle) {
        ArrayList<Item> item_elemanları_sıralı = parcalar.sort(itemEkle);
        System.out.println("Item Elemanlarını Göster Sıralı Halde ");
        for(int i=0;i<item_elemanları_sıralı.size();i++){
           System.out.println(item_elemanları_sıralı.get(i).getValue());
       }
    }
        
}


