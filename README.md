# Project3 - CSCI 212

## Overview

This project is a Java-based application that reads appliance data from a file, categorizes appliances by type, and displays the information in a user-friendly GUI. The program handles multiple appliance types, such as Refrigerators, Dishwashers, and Microwaves, and organizes them in a grid layout for easy viewing.

## Features

- Reads appliance serial numbers from a text file select by the user!
- Ensures the input file is of valid type.
- Categorizes appliances into specific types:
  - Refrigerator
  - Dishwasher
  - Microwave
- Displays categorized data in a graphical user interface (GUI) with a grid layout.
- Handles exceptions, such as invalid serial numbers.

## Project Structure

The project includes the following Java files:

- **Appliance.java**: Defines the base Appliance class.
- **Refrigerator.java**, **Dishwasher.java**, **Microwave.java**: Subclasses for specific appliance types.
- **IllegalApplianceException.java**: Handles invalid appliance data errors.
- **ApplianceList.java**, **SortedApplianceList.java**, **ApplianceNode.java**: Implements data structures for managing appliance lists.
- **ApplianceGUI.java**: The graphical user interface for the application.
- **TextFileInput.java**: Utility for reading data from text files.
- **Project3.java**: Entry point for the program, initializes the GUI.

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/alfredscyriac/Project3-CSCI212.git
   cd Project3-CSCI212
2. Ensure you have Java installed on your system.
3. Compile and run the project:
   ```bash
   javac Project3.java
   java Project3
