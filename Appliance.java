public class Appliance {
    private String serialNumber; 

    public Appliance (String serialNumber) {  
        this.serialNumber = serialNumber;
    }

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
