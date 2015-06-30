package app;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;



public class MovieListApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Movie> movies = new ArrayList<Movie>(100);
		
		populateList(movies);		
		displayByCategory(sc, movies);	
		
		sc.close();
	}
	
	private static void populateList(ArrayList<Movie> movies) {
		for (int i = 0; i < 100;i++){			
			movies.add(MovieIO.getMovie(i+1));
			
		}
	}

	private static void displayByCategory(Scanner sc,
			ArrayList<Movie> movies) {
		String cat;
		String choice = "y";
		while (choice.equalsIgnoreCase("y")){
			cat = Validator.getString(sc, "Enter the category you are looking for: ");			
			for(Movie movie:movies){
				if(movie.category.equalsIgnoreCase(cat))
					System.out.println(movie.title);				
			}
			choice = Validator.getChoice(sc, "Continue (y/n):", "y", "n");
			
		}		
	}

	

}
