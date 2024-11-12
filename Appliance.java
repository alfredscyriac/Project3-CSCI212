import java.util.regex.Pattern;

public class Appliance {
    public Appliance(String serialNumber) throws IllegalApplianceException{
        if (!isValid(serialNumber)) {
            throw new IllegalApplianceException("Invalid serial number: " + serialNumber);
        }
        this.serialNumber = serialNumber;
    }
    public static boolean isValid(String serialNumber) {
        return Pattern.matches("^[RDW][A-Z0-9]{11}$", serialNumber);
    }
    
    private String serialNumber; 

    public String getSerialNumber () {  
        return serialNumber;
    }

    public void setSerialNumber (String serialNumber) {  
        this.serialNumber = serialNumber;
    }

    public char getApplianceType () {   
        return serialNumber.charAt(0);  
    }

    public String toString() { 
        return serialNumber;
    }

    public int compareTo (Appliance other) {  // Compare two serial numbers to help order them numerically later on
        return this.serialNumber.compareTo(other.serialNumber);
    }

    public boolean equals (Appliance other) {
        return this.serialNumber.equals(other.serialNumber); // boolean to check if two serial numbers are equal, passing the compared serial number as a parameter
    }
}
