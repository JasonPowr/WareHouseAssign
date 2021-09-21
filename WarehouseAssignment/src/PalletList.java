public class PalletList {
    public PalletNode head;

    public void addPallet(Pallet p) {
        PalletNode pN = new PalletNode();  //instanciating the palletNode class
            pN.setContents(p);   //setting the contents of the pallet through the setter in PalletNode
            pN.next = head;   //Making the next Node in the List the new head
            head = pN; //making the head to be palletNode
        }

    public String listPallet() {
        if (numberOfPallets() == 0) {
            return "No floors in the system";
        }
        PalletNode node = head; //creating a variable called node and letting it equal to the current node
        String palletList = ""; //creating an empty list called palletList

        while (node != null) { //while theres pallets in the list
            palletList += node.getContents().toString(); // build a list of the toStrings and add them to palletList
            node = node.next; //moving the list on by making the head equal to the next node
        }
        return palletList; //returning palletList
    }

    public Pallet findPallet(int palletNumber) {
        PalletNode tempPallet = head;
        for (int i = 0; i < listPallet().length() && tempPallet != null; i++) {
            if (palletNumber == head.getContents().getPalletNumber()) {     //finds a pallet by its number
                return head.getContents();
            }
        }
        return head.getContents();
    }

    public int numberOfPallets() {
        PalletNode node = head;
        int numberOfPallets = 0;

        while (node != null) {  //counts the number of pallets
            numberOfPallets++;
            node = node.next;
        }
        return numberOfPallets;
    }

    public void deletePallet(int palletNumber) {
        if(palletNumber != head.getContents().getPalletNumber()){
            System.out.println("No pallets in System by this number");
        }
        PalletNode tempPallet = head;
        int i = 0;      //deletes a pallet by the pallet number
        while (i < numberOfPallets() && tempPallet != null) {
            if (palletNumber == head.getContents().getPalletNumber()) {
                head = head.next;
                tempPallet = tempPallet.next;
            }
            i++;
        }
        if (tempPallet != null && tempPallet.next != null) {
            tempPallet.next = tempPallet.next.next;
        }
    }
}




