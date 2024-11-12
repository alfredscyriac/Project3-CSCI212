public class SortedApplianceList extends ApplianceList{
    public SortedApplianceList() {
        super();
    }

    public void add(Appliance appliance) {
        ApplianceNode newNode = new ApplianceNode(appliance);
        ApplianceNode current = head;
        while (current.next != null && current.next.data.compareTo(appliance) < 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == null) {
            last = newNode;
        }
        length++;
    }
}
