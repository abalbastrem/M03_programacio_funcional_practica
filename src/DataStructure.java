import java.util.function.Function;

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
    
    /*
     * 2.1. EXERCICI
     */
    public void print(DataStructureIterator iterator) {
    	while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    /*
     * 2.3. EXERCICI
     */
    public void print2(Function<Integer, Boolean> iterator) {
    	for (int i = 0; i < SIZE; i++) {
    		if (iterator.apply(i)) {
    			System.out.print(i + " ");
    		}
        }
    	System.out.println();
    }
    
    /*
     * 2.4. EXERCICI
     */
    public static boolean isEvenIndex(int i) {
    	if (i % 2 == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }

    public static boolean isOddIndex(int i) {
    	if (i % 2 == 0) {
    		return false;
    	} else {
    		return true;
    	}
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
    	System.out.println("0.0");
    	
        DataStructure ds = new DataStructure();
        ds.printEven();
        
        /*
         * 2.1. Defineix un mètode dit print(DataStructureIterator iterator).
         * Invoca aquest mètode amb una instància de la classe EvenIterator 
         * per tal de què es comporti igual que el mètode printEven.
         * TERCERA APROXIMACIÓ
         */
        System.out.println("2.1");
        
        ds.print(ds.new EvenIterator());
        
        /*
         * 2.2. Invoca el mètode print(DataStructureIterator iterator) 
         * per a què imprimeixi els elements que tenen un índex de valor impar. 
         * Fes servir una classe anònima com a argument del mètode en lloc 
         * d’una instància de l’interfície DataStructureIterator.
         * QUARTA APROXIMACIÓ
         */
        System.out.println("2.2");
        
        ds.print(new DataStructureIterator() {
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

        /*
         * 2.3. Defineix un mètode nomenat print(java.util.Function<Integer, Boolean> iterator)
         * que faci la mateixa funció que print(DataStructureIterator iterator). 
         * Invoca aquest mètode amb una expressió lambda per a imprimir elements 
         * que tinguin un índex de valor par. Invoca aquest mètode un altre cop 
         * amb una expressió lambda per a imprimir elements que tinguin un índex impar.
         * SISENA APROXIMACIÓ
         */
        
        System.out.println("2.3");
        
        ds.print2(
        		i -> i % 2 == 0
        		);
        
        ds.print2(
        		i -> i % 2 == 1
        		);
        
        /*
         * 2.4. Defineix dos mètodes per a què les següents ordres imprimeixin elements que tenen 
         * un índex de valor par i elements que el tinguin impar:
		 * DataStructure ds = new DataStructure()
		 * // ...
		 * ds.print2(DataStructure::isEvenIndex);
		 * ds.print2(DataStructure::isOddIndex);
         */
        System.out.println("2.4");
        
        ds.print2(DataStructure::isEvenIndex);
        ds.print2(DataStructure::isOddIndex);
        
    }
}