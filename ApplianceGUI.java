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
        this.refrigerators = refrigerators;
        this.dishwashers = dishwashers;
        this.microwaves = microwaves;
        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new BorderLayout());
        frame.setTitle("Project 3 - Appliance List w Modified GUI and Exception for Illegal Appliances"); 

        createMenu(frame);
        
        fridgeArea = new JTextArea();
        dishWasherArea = new JTextArea();
        microwaveArea = new JTextArea();

        JPanel appliancePanel = new JPanel(new GridLayout(1, 3));
        appliancePanel.add(new JScrollPane(fridgeArea));
        appliancePanel.add(new JScrollPane(dishWasherArea));
        appliancePanel.add(new JScrollPane(microwaveArea));

        frame.add(appliancePanel, BorderLayout.CENTER);

        frame.setSize(900, 400);
        frame.setVisible(true);
    } 
    private void createMenu(JFrame frame) {
        
    }  
}
