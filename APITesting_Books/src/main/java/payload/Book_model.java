package payload;

public class Book_model {

	private long id;
	private String title;
	private String description;
	private int pageCount;
	private String excerpt;
	private String publishDate;

	// Default constructor
	public Book_model() {
	}

	// Parameterized constructor
	public Book_model(long id, String title, String description, int pageCount, String excerpt, String publishDate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.pageCount = pageCount;
		this.excerpt = excerpt;
		this.publishDate = publishDate;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	@Override
	public String toString() {
		return "Book_model [id=" + id + ", title=" + title + ", description=" + description + ", pageCount=" + pageCount
				+ ", excerpt=" + excerpt + ", publishDate=" + publishDate + "]";
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

}
