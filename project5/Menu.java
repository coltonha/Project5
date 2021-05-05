package project5;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Menu {
    public static void main(String[] args) throws Exception {
        PhoneBook aTree=new PhoneBook();
        File phonebookFile= new File("Phonebook.txt");
        Scanner phonebookScanner= new Scanner(phonebookFile);


        while(phonebookScanner.hasNext()){
            String phonenumber=phonebookScanner.next();
            String name=phonebookScanner.next();
            Person temp=new Person(name,phonenumber);
            aTree.insert(temp);
        }
        
        phonebookScanner.close();
        PhoneBook bTree=new PhoneBook();
        Person A=new Person("atuwy", "213583456");
        Person B= new Person("rqwe","123912");
        Person C= new Person("uqweyqweb","12371874");

        bTree.insert(A);  
        bTree.insert(C);
        bTree.insert(B);
        System.out.println(bTree.retrieve("rqwe").toString());
        bTree.change("rqwe", "1234567");
        System.out.println(bTree.retrieve("rqwe").toString());
        System.out.println(aTree.retrieve("aopiernlkw").toString());
    }
}
