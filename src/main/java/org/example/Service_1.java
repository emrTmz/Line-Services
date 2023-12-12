package org.example;
public class Service_1 {
    Patient head;
    Patient tail;

    public Service_1() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //This function first builds new patient with the given data
    //than adds it to the LinkedList
    //new nodes are added to the tail of LinkedList
    public void insert(String name) {
        Patient newPatient = new Patient(name);
        if(isEmpty()) {
            head = newPatient;
            tail = newPatient;
        } else {
            tail.next = newPatient;
            newPatient.previous = tail;
            tail = newPatient;
        }
    }

    // overload this method as new nodes are added to given position (int pos)
    // fill the rest
    public void insert(String name, int pos) {
        if(pos == 0) {
            Patient newPatient = new Patient(name);
            newPatient.next = head;
            head.previous = newPatient;
            head = newPatient;
        } else {
            Patient current = head;
            int index = 0;
            while(current != null && index < pos - 1) {
                current = current.next;
                index++;
            }
            if(current == null)
                return;
            Patient newPatient = new Patient(name);
            newPatient.next = current.next;
            newPatient.previous = current;
            current.next = newPatient;
        }
    }

    //This method finds how many patients are exist in LinkedList
    public int size() {
        int count = 0;
        Patient current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // This functions delete a node in the LinkedList by a given "data"
    // parameter name changed as key in order to prevent confusion
    public Patient deleteByName(String name) {
        Patient current = head;
        while(current != null) {
            if(current.getName().equals(name)) {
                if(current.previous != null)
                    current.previous.next = current.next;
                else
                    head = current.next;

                if(current.next != null)
                    current.next.previous = current.previous;
                else
                    tail = current.previous;
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // This functions delete a node in the LinkedList by a given position
    public Patient deleteByPosition(int pos) {
        if(pos == 0) {
            Patient deleted = head;
            head = head.next;
            if(head != null)
                head.previous = null;
            else
                tail = null;
            return deleted;
        } else {
            Patient current = head;
            int index = 0;
            while(current != null && index < pos - 1) {
                current = current.next;
                index++;
            }
            if(current == null || current.next == null)
                return null;
            Patient deleted = current.next;
            current.next = current.next.next;
            if(current.next != null)
                current.next.previous = current;
            else
                tail = current;
            return deleted;
        }
    }

    //This function get the node in the given index
    //*********************DO NOTHING*********************
    public Patient getByPosition(int pos){
        if(this.isEmpty())
            return new Patient("empty");
        Patient current = this.head;
        int index = 0;

        while (current != null){
            if(index++ == pos)
                break;
            current = current.next;
        }

        if(current == null)
            return new Patient("empty");

        return current;
    }

    // This function prints  the LinkenList
    //*********************DO NOTHING*********************
    public void print() {

        if(this.isEmpty())
            return;
        Patient patient = this.head;  // make a copy of head
        int index = 1;

        // never operate on "head", otherwise you will lost the linkedlist
        //unless you want to change "head"
        while (patient != null) {
            System.out.println(index++ + ". " + patient.getName());

            patient = patient.next;  // iterate to next node
        }

    }

}
