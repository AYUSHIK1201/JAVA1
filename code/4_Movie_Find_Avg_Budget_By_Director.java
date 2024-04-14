/*

Create a class Movie with the below attributes: movieId - int director - String rating - int budget - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findAvgBudgetByDirector and getMovieByRatingBudget in Solution class.

findAvgBudgetByDirector method: This method will take two input parameters - array of Movie objects and string parameter
 director. The method will return the average of the budget attribute from Movie objects directed by the director passed
  as parameter. If no movie with the given director is present in the array of movie objects, then the method should 
  return 0.

getMovieByRatingBudget method: This method will take two int parameters rating and budget, along with the array of movie 
objects. The method will return the movie object, if the input parameters rating and budget, matches with the rating and 
budget attribute of the movie object respectively.

Also check if rating is a factor of budget (eg: 3 is a factor of 12 because 3 divides 12 without leaving a remainder). 
If any of the conditions are not met, then the method should return null.

Note : No two movie object would have the same value for rating and budget attributes. All the searches should be case 
insensitive. The budget mentioned are in crores and in INR.

These above mentioned static methods should be called from the main method.

For findAvgBudgetByDirector method - The main method should print the average budget as it is if the returned value is 
greater than 0, or it should print "Sorry - The given director has not yet directed any movie".

For getMovieByRatingBudget method - The main method should print the movieId of the returned movie object. If the 
returned value is null then it should print "Sorry - No movie is available with the specified rating and budget 
requirement".

Before calling these static methods in main, use Scanner object to read the values of four Movie objects referring 
attributes in the above mentioned attribute sequence. Next, read the value for director, rating and budget.

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
	        Movie[] a = new Movie[4];
	        for(int i = 0;i <4;i++)
	        {
	            int movieId= sc.nextInt();sc.nextLine();
	            String director = sc.nextLine();
	            int rating= sc.nextInt();sc.nextLine();
	            int budget= sc.nextInt();sc.nextLine();  
	          
	        
	            a[i] = new Movie(movieId,director,rating,budget);
	        }
	        String director2 = sc.nextLine();
	        int rating2 = sc.nextInt(); sc.nextLine();
	        int budget2 = sc.nextInt(); sc.nextLine();
	        sc.close();
	        
	        int avgBudget = findAvgBudgetByDirector(a, director2);
	        if (avgBudget>0)
	        System.out.println(avgBudget);
	        else
	        System.out.println("Sorry - The given director has not yet directed any movie");
	        Movie resultMovie = getMovieByRatingBudget(a,rating2,budget2);
	        if(resultMovie == null)
	        System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
	        else
	        System.out.println(resultMovie.getmovieId());

	        
	       
	 }
	 
	 public static int findAvgBudgetByDirector(Movie[] a, String director2)
	 {
		 int avg,s=0,j=0;
         for(int i=0;i<4;i++)
         {              
             if(director2.equalsIgnoreCase(a[i].getdirector()))
             {
                 s = s+a[i].getbudget();
                 j++;
             }
         }
             if(j>0)
             {
                 avg = s/j;
                 return avg;
             }          
             else 
             return 0;
		 
	 }
	 

	  public static Movie getMovieByRatingBudget(Movie[] a, int rating2, int budget2)
	      {
	          for(int i=0;i<4;i++)
	          {
	              if((rating2 == a[i].getrating()) && (budget2 == a[i].getbudget()) && (a[i].getbudget() % a[i].getrating() == 0))
	              {
	                  return a[i];
	              }
	          }
	          return null;   
	          
	      }
	 
	
}

class Movie
{
	int	movieId,rating,budget;
	String director;
	
	
	   public Movie(int movieId, String director, int rating, int budget) 
	   {
	        this.movieId =movieId;
	        this.director = director;
	        this.rating = rating;
	        this.budget= budget;
	       
	    }
		
	   int getmovieId()
		{
			return movieId;
		}
	   

		String getdirector()
		{
			return director;
		}
		
	   int getrating ()
		{
			return rating ;
		}
	
	int getbudget()
	{
		return budget;
	}
	

	
}

//==============================================================================================================================================
//==============================================================================================================================================

/*
Input==>

1101
GVM
4
100
1201
Shankar
5
500
1301
Shankar
3
50
1401
GVM
5
300
GVM
5
300

Output==>

200
1401

*/