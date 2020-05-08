package domain;

import javax.persistence.*;
 
@Entity
@Table(name = "User")
public class User {
    private Long id;
    private Integer uId;
    private String state;
 
    public User() {
    }
    
    public User(Integer uId, String state) {
    	this.uId = uId;
    	this.state = state;
    }
 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

	public Integer getUid() {
		return uId;
	}

	public void setUid(Integer uid) {
		this.uId = uid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
	@Override public String toString() {
		return String.format("User[id=%d, uId=%d, state=%s]\n", id, uId, state);
	}
}
