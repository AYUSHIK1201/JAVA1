
/*
Create class Movie with below attributes: movieName - String company - String genre - String budget - int

Create class Solution and implement static method "getMovieByGenre" in the Solution class. This method will take array 
of Movie objects and a searchGenre String as parameters. And will return another array of Movie objects where the 
searchGenre String matches with the original array of Movie object's genre attribute (case insensitive search).

Write necessary getters and setters.

Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the attributes
 in above sequence along with a String searchGenre. Then call the "getMovieByGenre" method and write logic in main method
  to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else print "Low Budget Movie".

*/
//==============================================================================================================================================
//==============================================================================================================================================


package javacode;
import java.util.*;
public class myclass2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Movie[] movies = new Movie[4];
        for(int i = 0;i < 4;i++){
            movies[i] = new Movie(sc.next(),sc.next(),sc.next(),sc.nextInt());
            sc.nextLine();
        }
        String searchGenre = sc.nextLine();
        sc.close();
        Movie[] result = getMovieByGenre(movies,searchGenre);
        for(int i = 0;i < result.length;i++){
            if(result[i].getBudget() > 80000000)
                System.out.println("High Budget Movie");
            else
                System.out.println("Low Budget Movie");
        }
    }
    
    public static Movie[] getMovieByGenre(Movie[] movies,String searchGenre){
        Movie[] refined = new Movie[0];
        for(int i = 0;i < 4;i++){
            if(movies[i].getGenre().equals(searchGenre)){
                refined=Arrays.copyOf(refined, refined.length+1);
                refined[refined.length-1] = movies[i];   
            }
        }
        return refined;
    }
}

class Movie{
    String movieName;
    String company;
    String genre;
    int budget;
    
    public String getGenre(){
        return genre;
    }

    public int getBudget(){
        return budget;
    }

    Movie(String movieName, String company, String genre, int budget){
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }
}


//==============================================================================================================================================
//==============================================================================================================================================

/*

Input==>

aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output==>

High Budget Movie
High Budget Movie

*/