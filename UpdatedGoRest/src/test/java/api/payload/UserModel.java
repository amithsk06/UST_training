package api.payload;


public class UserModel {

	    private long id;
	    private String name;
	    private String email;
	    private String gender;
	    private String status;

	    // Default constructor
	    public UserModel() {
	    }

	    // Parameterized constructor
	    public UserModel(long id, String name, String email, String gender, String status) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.gender = gender;
	        this.status = status;
	    }

	    // Getters and Setters
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", email='" + email + '\'' +
	                ", gender='" + gender + '\'' +
	                ", status='" + status + '\'' +
	                '}';
	    }
	}


	
	

