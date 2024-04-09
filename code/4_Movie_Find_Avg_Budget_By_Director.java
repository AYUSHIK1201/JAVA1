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

