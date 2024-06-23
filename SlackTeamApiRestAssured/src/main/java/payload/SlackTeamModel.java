package payload;

public class SlackTeamModel {
	
	public int id;
    public String name;
    public String lastName;
    public String email;
    public String city;
    
    public SlackTeamModel(String name, String lastName, String email, String city) {
    	this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }
    
    public SlackTeamModel(int id) {
    	this.id = id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
    public String toString() {
        return "Usermodel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName'" + lastName + '\'' +
                ", email=" + email +
                ", city='" + city + '\'' +
               
                '}';
    }

	
}
