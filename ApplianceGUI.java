import javax.swing.*;
import java.awt.*;
/*
 * This class is the graphical user interface which splits the sorted appliance list into three columns 
 * Majority of its functionality relies on FileMenuHandler.java
 * This GUI is different from Project2 as there is a menu which allows users to upload files and..
 * exit the program
 */
public class ApplianceGUI {
    private SortedApplianceList refrigerators;
    private SortedApplianceList dishwashers;
    private SortedApplianceList microwaves;
    private JTextArea fridgeArea;
    private JTextArea dishWasherArea;
    private JTextArea microwaveArea;

    /**
     * This is the constructor for the ApplianceGUI class and initializes the graphical components
     * Displays three columns, each representing a sorted list of a specific appliance type.
     *
     * @param refrigerators The sorted list of refrigerators to display
     * @param dishwashers The sorted list of dishwashers to display
     * @param microwaves The sorted list of microwaves to display
     * This constructor will be used in FileMenuHandler to pass in the sorted linked list once they..
     * have data 
     */
    public ApplianceGUI(SortedApplianceList refrigerators, SortedApplianceList dishwashers, SortedApplianceList microwaves) {
        this.refrigerators = refrigerators;
        this.dishwashers = dishwashers;
        this.microwaves = microwaves;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Project 3 - Appliance List with Linked Lists");

        // Initialize text areas/column for each appliance category
        fridgeArea = new JTextArea();
        dishWasherArea = new JTextArea();
        microwaveArea = new JTextArea();

        // Create a FileMenuHandler and pass the initialized components
        // This one of the most vital parts of this entire GUI as it is the FileMenuHandler..
        // That allow the items in the menu to function how they truly should
        FileMenuHandler fmh = new FileMenuHandler(frame, refrigerators, dishwashers, microwaves, 
        fridgeArea, dishWasherArea, microwaveArea);

        // Set up the menu bar, when file is clicked it will show the two options Open and Quit
        // The functionality for both these options are created using event driven programming in..
        // FileMenuHandler.java
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(fmh);
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(fmh);

        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Create a panel to display the three columns of appliances
        JPanel appliancePanel = new JPanel(new GridLayout(1, 3));
        appliancePanel.add(new JScrollPane(fridgeArea));
        appliancePanel.add(new JScrollPane(dishWasherArea));
        appliancePanel.add(new JScrollPane(microwaveArea));

        // Add the appliance panel to the frame
        frame.add(appliancePanel, BorderLayout.CENTER);

        // Configure frame size (this could vary i just chose this as it's what i had for Project2) and..
        // make it visible
        frame.setSize(900, 400);
        frame.setVisible(true);
    }
}

