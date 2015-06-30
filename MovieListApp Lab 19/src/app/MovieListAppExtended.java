package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import model.Movie;
import model.MovieIO;
import model.Validator;

public class MovieListAppExtended {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Movie> movies = new ArrayList<Movie>(100);		
		HashMap<Integer,String> map = new HashMap<>();	
		
		createMap(map);		
		populateList(movies);
		//displayByCategory(sc, movies);
		displayByNumber(sc,movies,map);
		sortandDisplayByCategory(sc,movies,map);
		sc.close();
	}


	private static void createMap(HashMap<Integer, String> map) {
		map.put(1,"animated");
		map.put(2, "drama");
		map.put(3, "horror");
		map.put(4,"scifi");
	}

	private static void populateList(ArrayList<Movie> movies) {
		for (int i = 0; i < 100; i++) {
			Movie m = MovieIO.getMovie(i + 1);
			movies.add(m);

		}
	}	
/*
	private static void displayByCategory(Scanner sc, ArrayList<Movie> movies) {
		String cat;
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			cat = Validator.getString(sc,
					"Enter the category you are looking for: ");
			for (Movie movie : movies) {
				if (movie.category.equalsIgnoreCase(cat))
					System.out.println(movie.title);
			}
			choice = Validator.getChoice(sc, "Continue (y/n):", "y", "n");

		}
	}*/
	
	private static void displayByNumber(Scanner sc, ArrayList<Movie> movies,HashMap<Integer, String> map) {
		int num;
		String choice = "y";
		String cat ="";
		while (choice.equalsIgnoreCase("y")) {
			num = Validator.getIntInRange(sc, "Enter the category you are looking for:1 -animated, 2-drama, 3-horror, 4-scifi ",1,4);
			cat = map.get(num);
			for (Movie movie : movies) {
				if (movie.category.equalsIgnoreCase(cat))
					System.out.println(movie.title);
			}
			choice = Validator.getChoice(sc, "Continue (y/n):", "y", "n");

		}
	}
	
	private static void sortandDisplayByCategory(Scanner sc,
			ArrayList<Movie> movies, HashMap<Integer, String> map) {
		
		HashMap<String,ArrayList<String>> moviesByCategory= sortSaveByCategory(sc, movies, map);
		int num;
		String choice = "y";
		String cat ="";
		while (choice.equalsIgnoreCase("y")) {
			num = Validator.getIntInRange(sc, "View sorted titles for:1 -animated, 2-drama, 3-horror, 4-scifi ",1,4);
			cat = map.get(num);
			for (String s: moviesByCategory.get(cat)) {
				System.out.println(s);;
			}
			choice = Validator.getChoice(sc, "Continue (y/n):", "y", "n");

		}
	}
	
	private static HashMap<String, ArrayList<String>> sortSaveByCategory(Scanner sc,
			ArrayList<Movie> movies, HashMap<Integer, String> map) {
		
		HashMap<String,ArrayList<String>> moviesByCategory = new HashMap<String,ArrayList<String>>();
		
		for(String category :map.values()){
			ArrayList<String> titles = new ArrayList<String>();
			for(Movie m:movies){
				if(m.category.equalsIgnoreCase(category))
					titles.add(m.title);
			}
			Collections.sort(titles);
			moviesByCategory.put(category, titles);
		}
		return moviesByCategory;
		
	}

	

}
