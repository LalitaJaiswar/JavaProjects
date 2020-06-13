public class Video {
	String videoName;
	boolean checkOut;
	int rating;
	Video(){}
	Video(String name){
		this.videoName=name;
	}
	String getName() {
		return this.videoName;
	}
	void doCheckOut() 
	{
		this.checkOut=true;
		System.out.println("Video "+this.videoName+" checked out successfully");
	}
	void doReturn() {
		System.out.println("Video "+this.videoName+" returned successfully");
	}
	void recieveRating(int rating) 
	{
		this.rating=rating;
	}
	int getRating() {
	return this.rating;	
	}
	boolean getCheckOut() {
		return this.checkOut;
	}
}