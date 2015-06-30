package model;

public class Movie {
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
	

}
