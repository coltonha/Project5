package project5;

public class Person extends KeyedItem{
    private String name;
    private String phoneNumber;


public Person(String name, String phoneNumber){
    super(name); // searchKey=name
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
