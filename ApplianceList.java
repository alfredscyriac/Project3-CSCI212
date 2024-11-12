public abstract class ApplianceList {
    protected ApplianceNode head;
    protected ApplianceNode last;
    protected int length;

    public ApplianceList(){
        this.head = new ApplianceNode(null);
        this.last = head; 
        this.length = 0;
    }

    public void append(Appliance appliance){
        ApplianceNode new_node = new ApplianceNode(appliance);
        last.next = new_node; 
        last = new_node;
        length += 1;
    }
}