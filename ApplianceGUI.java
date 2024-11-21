import javax.swing.*; 
import java.awt.*;

public class ApplianceGUI {
    private SortedApplianceList refrigerators;
    private SortedApplianceList dishwashers;
    private SortedApplianceList microwaves;
    private JTextArea fridgeArea;
    private JTextArea dishWasherArea;
    private JTextArea microwaveArea;
        public ApplianceGUI(SortedApplianceList refrigerators, SortedApplianceList dishwashers, SortedApplianceList microwaves){
        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(1, 3)); 
        frame.setTitle("Project 3 - Appliance List w Modified GUI and Exception for Illegal Appliances"); 

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File"); 
        
        JTextArea fridgeArea = new JTextArea();
        ApplianceNode current = refrigerators.head.next;
        while (current != null){
            fridgeArea.append(current.data.toString() + "\n");
            current = current.next;
        }
        frame.add(new JScrollPane(fridgeArea));

        JTextArea dishWasherArea = new JTextArea();
        ApplianceNode current2 = dishwashers.head.next; 
        while(current2 != null){
            dishWasherArea.append(current2.data.toString()+"\n");
            current2 = current2.next; 
        }
        frame.add(new JScrollPane(dishWasherArea));

        JTextArea microwaveArea = new JTextArea();
        ApplianceNode current3 = microwaves.head.next;
        while(current3 != null){
            microwaveArea.append(current3.data.toString() + "\n");
            current3=current3.next;
        }
        frame.add(new JScrollPane(microwaveArea));

        frame.setSize(900, 400);
        frame.setVisible(true);
    }   
}
