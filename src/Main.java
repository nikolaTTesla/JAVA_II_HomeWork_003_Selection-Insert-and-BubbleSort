import java.util.ArrayList;
import java.util.Collections;
/*
QUESTIONS:
1. Why do we really need "throws InterruptedException"
*/
public class Main{

    //throws InterruptedException is added because of timer
    //(not sure why really, but it is forcing me to do it, please tell me why?)


    //Conditioning data, from array to arraylist
    static ArrayList<Integer> intUnsortedCollectionArrayList = new ArrayList<Integer>() ;
    static int iMMultiplayerOfArraySize = 5;
    public static void main(String[] args) throws InterruptedException {

        array_to_ArrayList();

        //These three functions are related to the different sorting methods
        //Comment what you don't want to be testing
        bubbleSort();
        selectionSort();
        insertionSort();
    }

    static void bubbleSort() throws InterruptedException {


        System.out.println("Bubble Sort, timer STARTS NOW!");
        // finding the time before the operation is executed
        long start = System.currentTimeMillis();
        for (int i = 0; i <5; i++) {
            Thread.sleep(60);
        }

        //Inner loop decides which member of arraylist is the smallest on the period
        //"i-to-intUnsortedCollectionArrayList.size()"
        //and it is making sure that every time smallest member is discovered is swapped with the "i" location of arraylist
        for(int i = 0; i < intUnsortedCollectionArrayList.size(); i++)
        {
            //With shrinking arraylist length range, we always start with hypothesis that first member is smallest
            //at the given new interval "i-to-intUnsortedCollectionArrayList.size()"
            int iMin = intUnsortedCollectionArrayList.get(i);
            for(int j = i; j < intUnsortedCollectionArrayList.size(); j++)
            {
                if(iMin>intUnsortedCollectionArrayList.get(j))
                {
                    iMin=intUnsortedCollectionArrayList.get(j);
                    Collections.swap(intUnsortedCollectionArrayList, i, j);
                }
            }
        }

         System.out.println("Bubble Sort, timer STOPS NOW!");
         // finding the time after the operation is executed
         long end = System.currentTimeMillis();
         //finding the time difference and converting it into seconds
         float sec = (end - start) / 1000F; System.out.println(sec + " seconds");

    }

    static void selectionSort() throws InterruptedException {
        System.out.println("Selection Sort, timer STARTS NOW!");
        // finding the time before the operation is executed
        long start = System.currentTimeMillis();
        for (int i = 0; i <5; i++) {
            Thread.sleep(60);
        }


        //For selection sort we need to declare one extra variable to memorize location of the element that will
        //have to be sorted (bubble waste time on swapping so many times)
        int iLocationToBeSwapped = 0;
        //Inner loop decides which member of arraylist is the smallest on the period
        //"i-to-intUnsortedCollectionArrayList.size()"
        for(int i = 0; i < intUnsortedCollectionArrayList.size(); i++)
        {
            //With shrinking arraylist length range, we always start with hypothesis that first member is smallest
            //at the given new interval "i-to-intUnsortedCollectionArrayList.size()"
            int iMin = intUnsortedCollectionArrayList.get(i);
            for(int j = i; j < intUnsortedCollectionArrayList.size(); j++)
            {
                if(iMin>intUnsortedCollectionArrayList.get(j))
                {
                    iMin=intUnsortedCollectionArrayList.get(j);
                    iLocationToBeSwapped = j;
                }
            }
            Collections.swap(intUnsortedCollectionArrayList, i, iLocationToBeSwapped);
        }

        System.out.println("Select Sort, timer STOPS NOW!");
        // finding the time after the operation is executed
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
    }

    static void insertionSort() throws InterruptedException {
        System.out.println("Insertion Sort, timer STARTS NOW!");
        // finding the time before the operation is executed
        long start = System.currentTimeMillis();
        for (int i = 0; i <5; i++) {
            Thread.sleep(60);
        }

        //System.out.println(intUnsortedCollectionArrayList.size());
        for(int i = 0; i < intUnsortedCollectionArrayList.size(); i++)
        {
            //Checking is the new member of the array whose turn is to be manipulated greater than member before it.
            if(i!=0 && intUnsortedCollectionArrayList.get(i)<intUnsortedCollectionArrayList.get(i-1))
            {
                //When group of data is getting bigger and bigger, probability for numbers in the array to be
                //repeated grows. This means that search for index where to insert specific data is better to be
                //from left han side
                for(int j = 0; j < i ; j++)
                {
                    //Is current number smaller or equal to the currently examined number in the
                    //restricted mini loop that goes from 0-i
                    if(intUnsortedCollectionArrayList.get(i)<=intUnsortedCollectionArrayList.get(j))
                    {
                        intUnsortedCollectionArrayList.add(j,intUnsortedCollectionArrayList.get(i));//Inserting
                        intUnsortedCollectionArrayList.remove(i+1); //Removing member that was cloned and inserted
                        break;
                    }
                }
            }
        }
        System.out.println("Insertion Sort, timer STOPS NOW!");
        // finding the time after the operation is executed
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        float sec = (end - start) / 1000F; System.out.println(sec + " seconds");

    }


    //This method creates instance of the class that holds our data, and multiply it "x" times because array can fit so much
    //and because we need experiment to last long enough, so we can see results clearly.
    //(we could do random insertion in to the arraylist as well, nex time)
    static void array_to_ArrayList()
    {
        //Preparing for calling Int_array_with_numbers_location
        //by crating object of Int_array_with_numbers_location class
        Int_array_with_numbers_location intUnsortedArray = new Int_array_with_numbers_location();

        for(int i = 0; i < iMMultiplayerOfArraySize; i++)
        {
            for(int j = 0; j < intUnsortedArray.intUnsortedCollectionArray.length; j++)
            {
                intUnsortedCollectionArrayList.add(intUnsortedArray.intUnsortedCollectionArray[j]);
            }
        }
    }


}