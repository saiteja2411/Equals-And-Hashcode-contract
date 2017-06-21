/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equalshashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author Saiteja
 */
public class EqualsHashcode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //--------------------------------
        String s1="nitin";
        String s2="nitn";
        String s3=new String("nitin");
        String s4= new String("nitin");
        
        System.out.println(s1.hashCode()+" "+s2.hashCode());
        System.out.println(s3.hashCode()+" "+s4.hashCode());
        
        //--------------------------------
        StringBuffer sb1=new StringBuffer("nitin");
        StringBuffer sb2=new StringBuffer("nitin");
        StringBuffer sb3= new StringBuffer();
        sb3=sb2;
        
        System.out.println(sb1.hashCode()+" "+sb2.hashCode()+" "+ sb3.equals(sb2));
        
        //----------------------------------
        Integer i = new Integer(50000);
        Integer i2 = new Integer(500);
        
        System.out.println(i.hashCode()+" "+i2.hashCode());
        
        //-----------------------------------
        /*
        below case shows that to diff string buffer objects are created but has same value
        in it. when we put the objects in to hashmap then both are entered [no dupicates]
        even two students are the same. 
        */
        HashMap<StringBuffer, String> hm = new HashMap();
        StringBuffer sb4=new StringBuffer("hellop");
        StringBuffer sb5=new StringBuffer("hellop");
        hm.put(sb4, "sai");
        hm.put(sb5, "sai");
        
        System.out.println(hm);
        System.out.println(sb4.hashCode()+" "+sb5.hashCode()+" "+ sb4.equals(sb5));
        
        //------------------------------------
        /*
        unlike above case here we overrided both equals and hash code so only one is enterd.
        because both objects have same hashcode
        */
        HashMap<student, String> hm1 = new HashMap();
        student st1=new student("hello");
        student st2=new student("hello");
        hm1.put(st1, "sai");
        hm1.put(st2, "sai");
        
        System.out.println(hm1);
        System.out.println(st1.hashCode()+" "+st2.hashCode()+" "+ st1.equals(st2));
        
    }
    
    
}


 class student{
    String name;
    student(String name){
        this.name=name;
    }
    @Override
    public boolean equals(Object obj){
        student s = (student)obj;
        if(this.name.equals(s.name))
            return true;
        return false;
    }
    
    @Override
    public int hashCode(){
        return name.hashCode();
    }
}