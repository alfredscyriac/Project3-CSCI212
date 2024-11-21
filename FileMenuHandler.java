import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileMenuHandler implements ActionListener{
    private JFrame frame;
    private SortedApplianceList refrigerators;
    private SortedApplianceList dishwashers;
    private SortedApplianceList microwaves;
    private JTextArea fridgeArea;
    private JTextArea dishWasherArea;
    private JTextArea microwaveArea;
    public FileMenuHandler(JFrame frame, SortedApplianceList refrigerators, SortedApplianceList dishwashers, SortedApplianceList microwaves,
                           JTextArea fridgeArea, JTextArea dishWasherArea, JTextArea microwaveArea) {
        this.frame = frame;
        this.refrigerators = refrigerators;
        this.dishwashers = dishwashers;
        this.microwaves = microwaves;
        this.fridgeArea = fridgeArea;
        this.dishWasherArea = dishWasherArea;
        this.microwaveArea = microwaveArea;
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Open")) {
            openFile();
        } else if (command.equals("Quit")) {
            System.exit(0);
        }
    }
    
}
