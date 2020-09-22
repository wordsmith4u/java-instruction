
public class Album extends Product {

	// Fields
	private String artist;

	// Constructor
	public Album() {
		super();
		artist = "";
		count++;
	}

	// Getters and Setters
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return super.toString() + " (" + artist + ")";
	}
}