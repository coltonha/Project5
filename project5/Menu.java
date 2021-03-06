/**
 *  Project: #5
 *  Source Code File:Menu.java
 *  Author: Sungwoong Ha
 *  Description: This is java implementation of menu.
 *  Due: 5/13/21
 */
package project5;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



public class Menu {
    public static void main(String[] args) throws Exception {
        PhoneBook bTree=new PhoneBook();
        bTree=load();
        Scanner scnr =new Scanner(System.in);
        String userOption;
        do{
            System.out.println("Choose An Option: ");
            System.out.println("(a)dd");
            System.out.println("(d)elete");
            System.out.println("(f)ind");
            System.out.println("(c)hange");
            System.out.println("(q)uit");
            userOption=scnr.next();
            
            if(userOption.equals("a")){
                System.out.println("Enter the name to add: ");
                String name=scnr.next();
                System.out.println("Enter Phone number of the person: ");
                String Number=scnr.next();
                Person newItem=new Person(name,Number);
                bTree.insert(newItem);
            }
            else if(userOption.equals("d")){
                System.out.println("Enter the name to delete: ");
                String name=scnr.next();
                bTree.delete(name);
            }
            else if(userOption.equals("f")){
                System.out.println("Enter the name to find: ");
                String name=scnr.next();
                System.out.println(bTree.retrieve(name).toString());
            }
            else if(userOption.equals("c")){
                System.out.println("Enter the name: ");
                String name=scnr.next();
                System.out.println("Enter new Phone number: ");
                String Number=scnr.next();
                bTree.change(name,Number);
            }
            else{
            System.out.println();
            }

        }while(!userOption.equals("q"));
        scnr.close();
        FileOutputStream clear=new FileOutputStream("Phonebook.txt",false);
		PrintWriter pwclear=new PrintWriter(clear);
        pwclear.close();   //since data is already stored in bst, clear txt file
        bTree.printInorder();    //write in txt file using inorder traverse
        System.out.println(); 
    }
    
    static PhoneBook load() throws Exception{
        PhoneBook aTree=new PhoneBook();
        ArrayList<Person> arr= new ArrayList<Person>();
        File phonebookFile= new File("Phonebook.txt");
        Scanner phonebookScanner= new Scanner(phonebookFile);
        
        while(phonebookScanner.hasNext()){
            String phonenumber=phonebookScanner.next();
            String name=phonebookScanner.next();
            Person temp=new Person(name,phonenumber);
            arr.add(temp);
        } 
        phonebookScanner.close();
        aTree.readtree(arr, 0,arr.size()-1);
        System.out.println();
    return aTree;
    }
}
