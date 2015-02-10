package exception;

public class Demo {
	 public int method(int[] arr, int index) throws NegIndex
	 {
    	 if (index<0)
    		 throw new NegIndex("The Index of arr can't be negative!!!");
    	  return arr[index];
	 }
}