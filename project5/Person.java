/**
 *  Project: #5
 *  Source Code File:Person.java
 *  Author: Sungwoong Ha
 *  Description: This is java implementation of ADT Person.
 *  Due: 5/13/21
 */
package project5;

public class Person{
    private String name;
    private String phoneNumber;


public Person(String name, String phoneNumber){
    this.name=name;
    this.phoneNumber=phoneNumber;
} //end constructor

public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getPhoneNumber(){
    return phoneNumber;
}
public void setPhoneNumber(String phone){
    this.phoneNumber = phone;
}//set&get method:

public String toString(){
    return getPhoneNumber()+" "+getName();
}
}
