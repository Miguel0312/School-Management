package people;
import java.io.Serializable;

public class Student implements Serializable{
	private String name, id, eMail, major;
	private boolean tuition;
	
	public Student(String n, String i, String e, String m, boolean t) {
		this.name = n;
		this.id = i;
		this.eMail = e;
		this.major = m;
		this.tuition = t;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getEMail() {
		return this.eMail;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public boolean getTuition() {
		return this.tuition;
	}
}
