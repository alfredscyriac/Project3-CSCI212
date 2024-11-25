/*
 * This class is a linked list for appliance
 * It has instance variables with protected access
 * .head returns the first element in the linked list 
 * .last returns the last element in the linked list 
 * .length returns the length of the linked list
 */
public abstract class ApplianceList {
    protected ApplianceNode head;
    protected ApplianceNode last;
    protected int length;

    /*
     * Constructs an empty linked list with a dummy node as the head 
     */
    public ApplianceList(){
        this.head = new ApplianceNode(null);
        this.last = head; 
        this.length = 0;
    }

    /*
     * Adds a node to the end of the linked list 
     * Increments the length of the linked list by 1
     * @param appliance needs to be of the Appliance class, this object is used to create a node 
     * This new node becomes the node we add to the end of the linked list 
     */
    public void append(Appliance appliance){
        ApplianceNode new_node = new ApplianceNode(appliance);
        last.next = new_node; 
        last = new_node;
        length += 1;
    }
}