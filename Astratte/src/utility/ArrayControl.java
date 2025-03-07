package utility;

public class ArrayControl {
    /*Given an array, it removes an element by substituting it with a zero.
     * The array passed is directly modified and the index passed is the index
     * of the element to remove.
     * In case the element to remove is outside of the array bounds, the method
     * just returns without modifying. This is also done if the array passed is invalid.
     */
    public static void removeElementReplace(int[] array, int removeIndex) {
        //In case the array is null, return without doing anything
        if(array == null)
            return;
        //Check if the index to remove is in the array, in which case don't remove anything
        if(removeIndex >= array.length || removeIndex < 0)
            return;

        //Remove the element at the index by replacing it with a zero
        array[removeIndex] = 0;
    }

    /*Given an array, it removes an element at the passed index.
     * The new modified array is then returned.
     * If the index passed is not valid, the method returns the
     * passed array.
     * If the passed array is null, return null.
     */
    public static int[] removeElement(int[] array, int removeIndex) {
        //Check if the index passed is out of bounds, in which case return null
        //Also return null if the array itself is null.
        if(array == null || removeIndex < 0 || removeIndex >= array.length)
            return array;
        //Create a new output array shrinked
        int[] output = new int[array.length - 1];

        //Copy data
        for(int copy = 0; copy < array.length; copy++) {
            //Copy all elements except the one to remove
            if(copy < removeIndex)
                output[copy] = array[copy];
            else if(copy > removeIndex)
                output[copy - 1] = array[copy];
        }

        //Return the modified array
        return output;
    }

    /* Given an array, it adds an element at the passed position
     * and returns the modified array.
     * In case the passed position is invalid, the input array is returned.
     * In case the array is null, the method returns null.
     */
    public static int[] addElement(int[] input, int position, int element) {
        //Check if the passed position is valid
        //Also return null if the array itself is null.
        if(input == null || position < 0 || position > input.length)
            //In case it's invalid, then return the input
            return input;

        //Create a new expanded array
        int[] expand = new int[input.length + 1];

        //Copy all data into the new array
        for(int copy = 0; copy < expand.length; copy++) {
            //Copy data from the input array
            if(copy < position)
                expand[copy] = input[copy];
            else if(copy > position)
                expand[copy] = input[copy - 1];
            else //Add the element
                expand[position] = element;
        }

        //Return the modified array
        return expand;
    }

    /* Sort an array using selection sort.
     * In case the array passed is null, the method doesn't do anything
     */
    public static void selectionSort(int[] input) {
        //In case the array passed is null, then return without doing anything
        if(input == null)
            return;

        //Iterate trough all the elements of the array
        for(int sortIterator = 0; sortIterator < input.length; sortIterator++) {
            //These contain the lowest value in the not sorted part of the array
            int minVal = input[sortIterator];
            int minIndex = sortIterator;
            //Search the not sorted part of the array for the minimum values
            for(int search = sortIterator; search < input.length; search++) {
                if(input[search] < minVal)
                {
                    minVal = input[search];
                    minIndex = search;
                }
            }

            //Now substitute the minimum value found at the start of the not sorted part of the array
            int temp = input[sortIterator];
            input[sortIterator] = input[minIndex];
            input[minIndex] = temp;
        }
    }

    /*Given an array and an element, it returns the amount of times
     * that element has been found in the array.
     * If the array passed is null, the method returns -1.
     */
    public static int searchElement(int[] array, int search) {
        //Check if the array passed is null
        if(array == null)
            return -1;

        //The amount of times the element has been found
        int output = 0;

        //Iterate trough all elements of the array
        for(int currentElement : array)
            if(currentElement == search)
                output++;

        //Return the amount of times the element has been found
        return output;
    }

    /*The method, given an array and a value to search, it
     * removes all the instances of that value from the array.
     * In case the element hasn't been found in the array,
     * the method returns null.
     * In case the array passed is null, the method returns null.
     */
    public static int[] removeAll(int[] array, int search) {
        //If the array passed is null
        if(array == null)
            return null; //Return null

        //Find the amount of elements to remove from the array
        int elementsToRemove = searchElement(array, search);
        //In case the amount of elements to remove is 0, return null
        if(elementsToRemove == 0)
            return null;
        //Create a new shrunk array to output
        int[] output = new int[array.length - elementsToRemove];

        //These are the two iterators for the two arrays
        int iteratorArray = 0, iteratorOutput = 0;
        //Iterate trough the elements of both arrays
        while (iteratorArray < array.length && iteratorOutput < output.length) {
            //If the array in the current position has the element to remove
            if(array[iteratorArray] == search) {
                //Increment the iterator of the array
                iteratorArray++;
                //Don't copy the current element
                continue;
            }

            /*If the current element is not the one to remove,
             * copy the element from the input to the output array.
             */
            output[iteratorOutput] = array[iteratorArray];
            //Increment both iterators
            iteratorArray++;
            iteratorOutput++;
        }

        //Return the output array
        return output;
    }

    /*Prints an array in output.
     * In case the array is null or length 0 the method doesn't
     * print anything.
     */
    public static void printArray(int[] input, int numPerLine) {
        //In case the array passed is null or length 0, the method doesn't print anything
        if(input == null || input.length == 0)
            return;

        //Contains the current amount of numbers per line
        int lineNumAmount = 0;
        //Iterate trough all the values in input
        for(int currentValue = 0; currentValue < input.length; currentValue++) {
            //Print the next value
            System.out.print(input[currentValue]);
            //Print a comma if the value isn't the last one
            if(currentValue != input.length - 1)
                System.out.print(", ");
            /* If the amount of numbers per line incremented became the requested amount,
             * add a new line and reset the counter.
             */
            if(++lineNumAmount >= numPerLine) {
                System.out.println("");
                lineNumAmount = 0;
            }
        }
    }

    /*Given an array, removes all repeating values in it */
    public static int[] removeRepeating(int[] input) {
        //Create an output array by cloning the input
        int[] output = input.clone();

        //Now, iterate trough all the elements of the output array
        for(int outputIter = 0; outputIter < output.length - 1; outputIter++) {
            /* Search the amount of times the element at the
             * current position is present in the array.
             */
            int elementsFound = searchElement(output, output[outputIter]);

            //If the element is present more than once, delete all repercussions
            if(elementsFound > 1) {
                //Search in the array all values equal to the current one
                for(int search = outputIter + 1; search < output.length; search++)
                {
                    //If an equal element is found
                    if(output[outputIter] == output[search])
                    {
                        //Remove it
                        output = removeElement(output, search);
                        //Decrement the iterator since the array length shrunk
                        search--;
                    }
                }
            }
        }

        //Return the modified array
        return output;
    }
}