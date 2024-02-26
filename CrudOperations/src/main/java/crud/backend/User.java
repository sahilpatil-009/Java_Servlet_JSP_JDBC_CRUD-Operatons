package crud.backend;

public class User {
	
	    private int id;
	    private String name;
	    private int age;
	    private String email;
	    private String password;
	    
		public User(int id, String name, int age, String email, String password) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.name = name;
			this.age = age;
			this.email = email;
			this.password = password;
		}
		
		public User() {
	        // Default constructor with no arguments
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	    
}
