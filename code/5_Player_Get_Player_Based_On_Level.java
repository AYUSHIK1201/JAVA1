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

