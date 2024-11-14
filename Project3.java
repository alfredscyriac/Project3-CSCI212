public class Project3 {
    public static void main(String[] args) {
        SortedApplianceList refrigerators = new SortedApplianceList();
        SortedApplianceList dishwashers = new SortedApplianceList();
        SortedApplianceList microwaves = new SortedApplianceList();

        new ApplianceGUI(refrigerators, dishwashers, microwaves);
    }
}