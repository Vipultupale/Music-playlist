 package song.com;

public class Song {
	private String title;
	private double duration;
	
	public Song(String title, double duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	
	public Song() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setName(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
	    return "Title: " + title + ", Duration: " + duration;
	
		
		
}
}
