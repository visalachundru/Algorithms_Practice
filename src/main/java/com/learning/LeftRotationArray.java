package com.learning;

/**
 * Hello world!
 *
 */
public class LeftRotationArray 
{
    public static void main( String[] args )
    {
    	int[] initialArray = {1,2,3,4,5};
    	int rotationNum =2;
       	for(int i=0; i<rotationNum; i++)
    	{
    		rotateArray(initialArray);
    	}
    	String newNumber ="";
		for(int i=0; i<initialArray.length; i++)
		{
			newNumber = newNumber + initialArray[i] + " ";
		}
    	System.out.println(newNumber);
        
    }

	private static void rotateArray(int[] initialArray) {
		
		int temp = initialArray[0];
		int length = initialArray.length;
		for(int i=0; i<initialArray.length-1; i++)
		{
			initialArray[i] = initialArray[i+1];
		}
		initialArray[length-1] = temp;
	
		
		
	}
}
