package model;

public class Movie implements Comparable<Movie>{
	public String title;
	public String category;
	
	public Movie(String title, String category){
		this.title = title;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", category=" + category + "]";
	}

	@Override
	public int compareTo(Movie m) {		
		return this.title.compareToIgnoreCase(m.title);		
	}
	

}
