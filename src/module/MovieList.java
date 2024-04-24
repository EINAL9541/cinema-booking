package module;

public class MovieList {
	private int mId;
	private String mTitle,mGenre,mSummary,mImage;
	private int mDuratin;
	private String Date;
	
	public MovieList(int mId, String mTitle, String mGenre, String mSummary, String mImage, int mDuratin, String date) {
		super();
		this.mId = mId;
		this.mTitle = mTitle;
		this.mGenre = mGenre;
		this.mSummary = mSummary;
		this.mImage = mImage;
		this.mDuratin = mDuratin;
		Date = date;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmGenre() {
		return mGenre;
	}

	public void setmGenre(String mGenre) {
		this.mGenre = mGenre;
	}

	public String getmSummary() {
		return mSummary;
	}

	public void setmSummary(String mSummary) {
		this.mSummary = mSummary;
	}

	public String getmImage() {
		return mImage;
	}

	public void setmImage(String mImage) {
		this.mImage = mImage;
	}

	public int getmDuratin() {
		return mDuratin;
	}

	public void setmDuratin(int mDuratin) {
		this.mDuratin = mDuratin;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
	
	
}
