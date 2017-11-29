public class DataStructure {
    // Create an array
    private final static int SIZE = 15;
    private static int[] arrayOfInts = new int[SIZE];
     
    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
     
    public void printEven() {
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    /**
     * 1. Defineix un mètode dit print(DataStructureIterator iterator).
     * Invoca aquest mètode amb una instància de la classe EvenIterator 
     * per tal de què es comporti igual que el mètode printEven.
     */
    public void print(DataStructureIterator iterator) {
    	while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
     
    interface DataStructureIterator extends java.util.Iterator<Integer> { }
 
    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface
     
    private class EvenIterator implements DataStructureIterator {
        // Start stepping through the array from the beginning
        private int nextIndex = 0;
         
        public boolean hasNext() {
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }    	
         
        public Integer next() {
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
             
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }
     
    public static void main(String s[]) {
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();
        
        /*
         * 1. Defineix un mètode dit print(DataStructureIterator iterator).
         * Invoca aquest mètode amb una instància de la classe EvenIterator 
         * per tal de què es comporti igual que el mètode printEven.
         */
        ds.print(ds.new EvenIterator());
        
        /*
         * 2. Invoca el mètode print(DataStructureIterator iterator) 
         * per a què imprimeixi els elements que tenen un índex de valor impar. 
         * Fes servir una classe anònima com a argument del mètode en lloc 
         * d’una instància de l’interfície DataStructureIterator.
         */
        ds.print(new DataStructureIterator() { // TODO NO ÉS ANÒNIMA!!!
        	// Start stepping through the array from the beginning
            private int nextIndex = 1;
             
            public boolean hasNext() {
                // Check if the current element is the last in the array
                return (nextIndex <= SIZE - 1);
            }    	
             
            public Integer next() {
                // Record a value of an even index of the array
                Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
                 
                // Get the next even element
                nextIndex += 2;
                return retValue;
            }
        });
        
    }
}