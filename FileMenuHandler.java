import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/*
 * This class provides functionality to the menu options in ApplianceGUI.java using ActionListeners
 */
public class FileMenuHandler implements ActionListener{
    private JFrame frame;
    private SortedApplianceList refrigerators;
    private SortedApplianceList dishwashers;
    private SortedApplianceList microwaves;
    private JTextArea fridgeArea;
    private JTextArea dishWasherArea;
    private JTextArea microwaveArea;

    /**
     * Constructor for the FileMenuHandler class which provides functionality to menu items
     *
     * @param frame The main GUI frame containing the menu and display areas
     * @param refrigerators The sorted list of refrigerators to be displayed
     * @param dishwashers The sorted list of dishwashers to be displayed
     * @param microwaves The sorted list of microwaves to be displayed
     * @param fridgeArea The text area for displaying refrigerator data in the GUI
     * @param dishWasherArea The text area for displaying dishwasher data in the GUI
     * @param microwaveArea The text area for displaying microwave data in the GUI
     */
    public FileMenuHandler(JFrame frame, SortedApplianceList refrigerators, SortedApplianceList dishwashers, 
    SortedApplianceList microwaves, JTextArea fridgeArea, JTextArea dishWasherArea, JTextArea microwaveArea) {
        this.frame = frame;
        this.refrigerators = refrigerators;
        this.dishwashers = dishwashers;
        this.microwaves = microwaves;
        this.fridgeArea = fridgeArea;
        this.dishWasherArea = dishWasherArea;
        this.microwaveArea = microwaveArea;
    }

    /**
     * Responds to menu actions triggered by the user click on File, Open, or Quit
     * @param event The action event triggered by a menu item in GUI
     */
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Open")) {
            openFile(); // This a method in this class that gives user the freedom to chose a file
        } 
        else if (command.equals("Quit")) {
            System.exit(0); // Ends the program if user selects quit
        }
    }

    /*
     * Allows the user to select a file from their local device by using built in JFileChooser from import java.io.File
     * Checks if the file is valid txt file, if not exception is thrown 
     * If a valid file is selected by the user then TextFileInput.java is used to read in the txt file, 
     * line by line much like we did in Project2 and the only difference is when each line is read in..
     * we use the isValid method from Appliance.java to ensure it is valid serial number. 
     * If the serial number is valid it gets add to its respectful sorted appliance list and if..
     * the serial number is invalid an exception is thrown
     */
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
    
                    // Use the isValid method for validation
                    if (Appliance.isValid(serial)) { 
                        try {
                            // Process based on appliance type
                            if (serial.charAt(0) == 'R') {
                                int cubicFeet = Integer.parseInt(parts[2]);
                                refrigerators.add(new Refrigerator(serial, price, cubicFeet));
                            } 
                            else if (serial.charAt(0) == 'M') {
                                int watts = Integer.parseInt(parts[2]);
                                microwaves.add(new Microwave(serial, price, watts));
                            } 
                            else if (serial.charAt(0) == 'D') {
                                boolean undercounterInstallation = parts[2].equalsIgnoreCase("Y");
                                dishwashers.add(new Dishwasher(serial, price, undercounterInstallation));
                            }
                        } 
                        catch (Exception ex) {
                            System.out.println("Error adding appliance: " + ex.getMessage());
                        }
                    } 
                    else {
                        System.out.println("Invalid appliance serial number: " + serial);
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
    /**
     * Updates the GUI's data of appliance data by clearing the text areas and then 
     * populating them with the updated data read in from the users select file 
     */
    private void updateDisplay(){
        fridgeArea.setText("");
        dishWasherArea.setText("");
        microwaveArea.setText("");
        // Create a pointer that iterates through each of the sorted appliances list to update data for GUI
        // .append allows the data to be directly added to the GUI in run time
        ApplianceNode current = refrigerators.head.next;
        while (current != null) {
            fridgeArea.append(current.data.toString() + "\n");
            current = current.next;
        }
        current = dishwashers.head.next;
        while (current != null) {
            dishWasherArea.append(current.data.toString() + "\n");
            current = current.next;
        }
        current = microwaves.head.next;
        while (current != null) {
            microwaveArea.append(current.data.toString() + "\n");
            current = current.next;
        }
    }
}
