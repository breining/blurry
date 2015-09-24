package lab06client;
import java.util.*;

public class Lab06Client
{

    /**
    * The first method typically executed within a Lab06Client object.
    * This method calls helper methods to practice using some of the
    * interfaces (that is, abstract data types) in the Java Collection Framework.
    */
    private void useJCF() 
    {
        useDequeStringElement();
        useDequeClassificationElement();
    }

    /** A class to be an element of a collection */
    private class Classification
    {
        /** the genus of the organism */
        private final String genus;

        /** the species of the organism */
        private final String species;

        /** the constructor */
        public Classification(String genus, String species)
        {
            this.genus = genus;
            this.species = species;
        }

        @Override
        public String toString()
        {
            return "(" + this.genus + ", " + this.species + ")";
        }
    }

    /** A client for the Deque collection interface that has the
    * element in the collection being of type String.
    */
    private void useDequeStringElement()
    {
        // declare a variable (called one) of type Deque<String>
        Deque<String> myDeque;// = new ArrayDeque<>();

        // create an object of class ArrayDeque and assign its reference
        // to the variable one
       // Deque<Classification> myClassification = new ArrayDeque<Classification>();
        myDeque = new ArrayDeque<>();
        // add "red", "blue", "white" to the front of the deque in that sequence
        myDeque.add("white");
        myDeque.add("blue");
        myDeque.add("red");
        // call the toString method of Deque and display the result on the console
        System.out.println(myDeque);
        // add "red", "white" and "green" to the rear of the deque in that sequence
        myDeque.offerLast("red");
        myDeque.offerLast("white");
        myDeque.offerLast("green");
        // call the toString method of Deque and display the result on the console
        System.out.println(myDeque);
        // use getFirst to return the element at the front of the deque
        // and display the result on the console
        System.out.println(myDeque.getFirst());
        // use getLast to return the element at the rear of the deque
        // and display the result on the console
        System.out.println(myDeque.getLast());
        // use removeFirstOccurrence to remove a "white" element, 
        // then call toString and display the result to the console
        myDeque.removeFirstOccurrence("white");
        System.out.println(myDeque);
        // use removeLastOccurrence to remove a "red" element, 
        // then call toString and display the result to the console
        myDeque.removeLastOccurrence("red");
        System.out.println(myDeque);
        // use removeFirst and then call toString and display the 
        // result to the console
        myDeque.removeFirst();
        System.out.println(myDeque);
        // use removeLast and then call toString and display the 
        // result to the console
        myDeque.removeLast();
        System.out.println(myDeque);
        // use push of the string "orange" and use toString to 
        // display the deque on the console
        myDeque.push("orange");
        System.out.println(myDeque);
        // use pop and display on the console the value popped
        System.out.println(myDeque.pop());
        // use peek and display on the console the value returned
        System.out.println(myDeque.peek());
        // create an iterator variable and iterate over the deque and display
        // on the console each value 
        Iterator iter = myDeque.iterator();
        while (iter.hasNext()){
            String str = (String)iter.next();
            System.out.println(str);
    }
    }


    /** A client for the Deque collection interface that has the
    * element in the collection being of type Classification.
    */
    private void useDequeClassificationElement()
    {
        // create a Deque variable that holds a reference to an
        // ArrayDeque of Classification elements
        ArrayDeque<Classification> arrayDeque = new ArrayDeque<>();
        // push a Classification element with genus "Homo" and species "sapien"
        arrayDeque.push("Homo", "sapien");
        // push a Classification element with genus "Malus" and species "domestica"
        arrayDeque.push("Malus", "domestica");
        // create an iterator variable and iterate over the deque and display
        // on the console each value
        Iterator iter = arrayDeque.iterator();
        while (iter.hasNext()){
        System.out.println(Classification.toString());
        }
        /*Iterator iter = arrayDeque.iterator();
        while (iter.hasNext()){
            String str = (String)iter.next();
            System.out.println(str);*/
    }
    }

    /** 
     * Provides the entry point for this application.  This method creates
     * a <code>Lab06Client</code> and executes the
     * useJCF() method.
     *
     * @param args Unused.
    */
    public static void main(String[] args) 
    {
        Lab06Client client = new Lab06Client();
        client.useJCF();
    }
}