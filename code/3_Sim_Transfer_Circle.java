/*
Create class Sim with below attributes: 
simId - int customerName - String balance - double ratePerSecond - double circle - String

Create class Solution and implement static method "transferCircle" in the Solution class. This method will take array 
of Sim objects, circle1 String and circle2 string as parameters. And will return another Sim array where the circle1 
matches with the circle parameter of the original Sim array and the circle parameter of the new array is set to circle2 
and is also sorted by means of ratePerSecond attribute in desending order.

Write necessary getters and setters.

Before calling "transferCircle" method in the main method, read values for five Sim objects referring the attributes in 
above sequence along with a String circlee1 and circle2. Then call the "transferCircle" method and write logic in main 
method to print all the attributes of the result obtained.

*/
//==============================================================================================================================================
//==============================================================================================================================================
package javacode;

import java.util.*;
public class myclass2
{
	 public static void main(String[] args)
	 {
	        Scanner sc = new Scanner(System.in);
	        Sim[] a = new Sim[5];
	        
	        for(int i = 0;i < 5;i++){
	            int simId = sc.nextInt();
	            sc.nextLine();
	            String customerName = sc.nextLine();
	            double balance = sc.nextDouble();
	            double ratePerSecond = sc.nextDouble();
	            sc.nextLine();
	            String circle = sc.nextLine();
	            a[i] = new Sim(simId,customerName,balance,ratePerSecond,circle);
	        }
	        /*for(int i=0;i<5;i++)
	        {
	        	a[i] = new Sim(sc.nextInt(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextLine());
	        }*/
	        String circle1 = sc.nextLine();
	        String circle2 = sc.nextLine();
	       sc.close();
	       
	        Sim[] result = transferCircle(a,circle1,circle2);
	        for(int i = 0;i < result.length;i++){
	            System.out.println(result[i].getsimId() +" "+ result[i].getcustomerName() +" "+ result[i].getcircle() +" "+ result[i].getratePerSecond());
	        }
	 }
	 
	public static Sim[] transferCircle(Sim[] a,String circle1,String circle2)
	{
		 Sim[] refined = new Sim[0];
	        for(int i=0;i<5;i++)
	        {
	            if(a[i].getcircle().equals(circle1))
	            {
	                refined=Arrays.copyOf(refined,refined.length+1);
	                refined[refined.length-1]=a[i];
	                refined[refined.length-1].setCircle(circle2);
	            }
	         }
	            
	            for(int i=0;i<refined.length-1;i++)
	            {
	                for(int j=0;j<refined.length-1-i;j++)
	                {
	                    if(refined[j].getratePerSecond()<refined[j+1].getratePerSecond())
	                    {
	                      Sim temp=refined[j];
	                      refined[j]=refined[j+1];
	                      refined[j+1]=temp; 
	                    }             
	                }
	             }
	             return refined;
	         
	}
	        
	       
	
}

class Sim
{
	int	simId ;
	String customerName,circle ;
	double balance,ratePerSecond ;
	
	   public Sim(int simId , String customerName, double balance, double ratePerSecond, String circle) 
	   {
	        this.simId = simId;
	        this.customerName = customerName;
	        this.balance = balance;
	        this.ratePerSecond = ratePerSecond;
	        this.circle = circle;
	       
	    }
		
	
	int getsimId()
	{
		return simId ;
	}
	
	String getcustomerName()
	{
		return customerName;
	}
	
	String getcircle()
	{
		return circle;
	}
	
	double getbalance()
	{
		return balance ;
		
	}
	
	double getratePerSecond()
	{
		return ratePerSecond;
		
	}
	public void setCircle(String circle){
        this.circle=circle;
    }
	
}


//==============================================================================================================================================
//==============================================================================================================================================

/*input==>

1
raju
130
1.32
mum
2
sachin
120
2.26
ahd
3
ram
200
2.54
kol
4
shubham
640
3.21
ahd
5
kalpesh
150
1.8
ahd
ahd
kol

output=>

4 shubham kol 3.21
2 sachin kol 2.26
5 kalpesh kol 1.8
*/