

/* This is the java class which is called 'Film' which is in a package called 'Film'. The constructor method, 'public Film(int id, String title, int year, String director, 
 String stars, Stars review)'.The constructor method begins the fields of the class with the values passed as arguments when an object of the class is created. I've added 6 fields:
  'id', 'title','year','director','stars and 'review'*/

package Film;



public class Film {
	   public Film(int id, String title, int year, String director, String stars,
				String review) {
			super();
			this.id = id;
			this.title = title;
			this.year = year;
			this.director = director;
			this.stars = stars;
			this.review = review;
		}
	   
	   
	public Film() {
		super();
	}


	int id;
	   String title;
	   int year;
	   String director;
	   String stars;
	   String review;

	public int getId() { //getters
		return id;
	}
	public void setId(int id) {  //setters
		this.id = id;
	}
	public String getTitle() { //getters
		return title;
	}
	public void setTitle(String title) { //getters
		this.title = title;
	}
	public int getYear() { //getters
		return year;
	}
	public void setYear(int year) {   //setters
		this.year = year;
	}
	public String getDirector() { //getters
		return director;
	}
	public void setDirector(String director) {   //setters
		this.director = director;
	}
	public String getStars() { //getters
		return stars;
	}
	public void setStars(String stars) {   //setters
		this.stars = stars;
	}
	public String getReview() {        //getters
		return review;
	}
	public void setReview(String review) {   //setters
		this.review = review;
	}
	@Override   /*The code below shows a java method that overrides the default 'toString()' method given by the 'Object' class. It shows a string of an object that
	 contains the values of the 'id','title','year','director','stars', and 'review' fields of the class. This method makes the contents of the object readable.  */
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", year=" + year
				+ ", director=" + director + ", stars=" + stars + ", review="
				+ review + "]";
	}   
	}

