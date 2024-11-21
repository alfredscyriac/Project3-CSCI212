import javax.swing.*;
import java.awt.*;

public class ApplianceGUI {
    private SortedApplianceList refrigerators;
    private SortedApplianceList dishwashers;
    private SortedApplianceList microwaves;
    private JTextArea fridgeArea;
    private JTextArea dishWasherArea;
    private JTextArea microwaveArea;

    public ApplianceGUI(SortedApplianceList refrigerators, SortedApplianceList dishwashers, SortedApplianceList microwaves) {
        this.refrigerators = refrigerators;
        this.dishwashers = dishwashers;
        this.microwaves = microwaves;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Project 3 - Appliance List with Linked Lists");

        // Initialize text areas
        fridgeArea = new JTextArea();
        dishWasherArea = new JTextArea();
        microwaveArea = new JTextArea();

        // Create a FileMenuHandler and pass the initialized components
        FileMenuHandler fmh = new FileMenuHandler(frame, refrigerators, dishwashers, microwaves, 
        fridgeArea, dishWasherArea, microwaveArea);

        // Create menu
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

        // Add text areas to the GUI
        JPanel appliancePanel = new JPanel(new GridLayout(1, 3));
        appliancePanel.add(new JScrollPane(fridgeArea));
        appliancePanel.add(new JScrollPane(dishWasherArea));
        appliancePanel.add(new JScrollPane(microwaveArea));

        frame.add(appliancePanel, BorderLayout.CENTER);

        frame.setSize(900, 400);
        frame.setVisible(true);
    }
}

