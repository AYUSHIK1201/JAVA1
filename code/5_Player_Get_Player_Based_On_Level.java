/*
Create a class Player with below attributes: playerId - int skill - String level - String points - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findPointsForGivenSkill and getPlayerBasedOnLevel in Solution class.

findPointsForGivenSkill method: This method will take two input parameters - array of Player objects and string 
parameter skill. The method will return the sum of the points attribute from player objects for the skill passed as 
parameter. If no player with the given skill is present in the array of player objects, then the method should return 0.

getPlayerBasedOnLevel method: This method will take two String parameters level and skill, along with the array of 
Player objects. The method will return the player object, if the input String parameters matches with the level and skill
 attribute of the player object and its point attribute is greater than or equal to 20. If any of the conditions are not
  met, then the method should return null.

Note : No two player object would have the same value for skill and level attribute. All player object would have the
 points greater than 0. All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.

For findPointsForGivenSkill method - The main method should print the points as it is if the returned price is greater 
than 0, or it should print "The given Skill is not available".

For getPlayerBasedOnLevel method - The main method should print the playerId of the returned player object. If the 
returned value is null then it should print "No player is available with specified level, skill and eligibility points".

Before calling these static methods in main, use Scanner object to read the values of four Player objects referring 
attributes in the above mentioned attribute sequence. Next, read the value for skill and level. Please consider the 
skill value read above as skill parameter for both the static methods.
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
	        Player[] a = new Player[4];
	        for(int i = 0;i <4;i++)
	        {
	            int playerId= sc.nextInt();sc.nextLine();
	            String skill  = sc.nextLine();
	             String level= sc.nextLine();
	            int points= sc.nextInt();sc.nextLine();  
	          
	        
	            a[i] = new Player(playerId,skill ,level,points);
	        }
	        String skill2  = sc.nextLine();
	        String level2= sc.nextLine();
	        sc.close();
	        
	        int  result1 = findPointsForGivenSkill(a,skill2);
	        System.out.println(result1);
	        
	        Player result2 = getPlayerBasedOnLevel(a, skill2 ,level2);
	      
	        	if(result2.getpoints()>=20)
	        	{
	        		System.out.println(result2.getplayerId());
	        	}
	        
	     
	        
	       
	 }
	 
	 public static int findPointsForGivenSkill(Player[] a, String skill2)
	 { 
		 int totalpoint=0;
		 for(int i = 0;i <4;i++)
		 {
			 if(skill2.equalsIgnoreCase(a[i].getskill()))
			 {
				 totalpoint= totalpoint +a[i].getpoints();
			 }
		 }
		return totalpoint;
		 
		 
		 
	 }
	 

	  public static Player getPlayerBasedOnLevel(Player[] a, String skill2 , String level2)
	      {
	          for(int i=0;i<4;i++)
	          {
	              if((skill2.equalsIgnoreCase(a[i].getskill())) && (level2.equalsIgnoreCase(a[i].getlevel())))
	              {
	                  return a[i];
	              }
	          }
	          return null;   
	          
	      }
	 
	
}

class Player
{
	int	playerId,points;
	String skill,level ;
	
	
	   public Player(int playerId, String skill , String level, int points) 
	   {
	        this.playerId = playerId;
	        this.skill  = skill ;
	        this.level= level;
	        this.points= points;
	       
	    }
		
	   int getplayerId()
		{
			return playerId;
		}
	   

		String getskill()
		{
			return skill;
		}
		
	   String getlevel ()
		{
			return level ;
		}
	
	int getpoints()
	{
		return points;
	}
	

	
}


//==============================================================================================================================================
//==============================================================================================================================================

/*

Input==>

101
Cricket
Basic
20
102
Cricket
Intermediate
25
111
Football
Intermediate
50
113
BaseBall
Advanced
100
Cricket
Intermediate

Output=>

45
102

*/