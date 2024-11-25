// Author: Alfred Siby Cyriac
// CSCI212 Lab Section: 121E
/*
 * This java file is the entry point to this project 
 * To compile the entirety of this project, once navigated inside the directory through the terminal..
 * You run commands: javac Project3.java then java Project3
 * This program initializes 3 sorted appliance list by the use SortedApplianceList.java and..
 * passes them to ApplianceGUI.java
 */
public class Project3 {
    public static void main(String[] args) {
        SortedApplianceList refrigerators = new SortedApplianceList();
        SortedApplianceList dishwashers = new SortedApplianceList();
        SortedApplianceList microwaves = new SortedApplianceList();

        new ApplianceGUI(refrigerators, dishwashers, microwaves);
    }
}