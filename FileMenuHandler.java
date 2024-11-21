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
    private void openFile(){
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            System.out.println("File chosen: " + filePath);
            refrigerators.clear();
            dishwashers.clear();
            microwaves.clear();
            try {
                TextFileInput fileInput = new TextFileInput(filePath);
                String line;
                while ((line = fileInput.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length < 3) continue;
                    String serial = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    try {
                        if (serial.charAt(0) == 'R') {
                            int cubicFeet = Integer.parseInt(parts[2]);
                            refrigerators.add(new Refrigerator(serial, price, cubicFeet));
                        } else if (serial.charAt(0) == 'M') {
                            int watts = Integer.parseInt(parts[2]);
                            microwaves.add(new Microwave(serial, price, watts));
                        } else if (serial.charAt(0) == 'D') {
                            boolean undercounterInstallation = parts[2].equalsIgnoreCase("Y");
                            dishwashers.add(new Dishwasher(serial, price, undercounterInstallation));
                        }
                    } catch (IllegalApplianceException ex) {
                        System.out.println("Invalid appliance: " + ex.getMessage());
                    }
                }
                fileInput.close();
            } 
            catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        updateDisplay();
    }
private void updateDisplay(){
    fridgeArea.setText("");
    dishWasherArea.setText("");
    microwaveArea.setText("");
    ApplianceNode current = refrigerators.head.next;
    while (current != null) {
        fridgeArea.append(current.data.toString() + "\n");
        current = current.next;
    }
    
}

}
