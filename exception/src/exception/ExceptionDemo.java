package exception;

public class ExceptionDemo {
            public static void main(String[] args)
            {
            	int[] arr = new int[3];
            	Demo d = new Demo();
            	try{
            	int num = d.method(arr,-1);
            	System.out.println("num="+num);
            	}
            	catch(NegIndex e)
            	{
            		System.out.println("负数角标异常");
            		System.out.println(e);
            	}
            	System.out.println("over");
            	System.out.println("");
            }
}
