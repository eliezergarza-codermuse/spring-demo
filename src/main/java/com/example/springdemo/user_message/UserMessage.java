package com.example.springdemo.user_message;
//Jakarta Imports
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
//Hibernate Actions
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
//Lombok annotations
//Project Imports
import com.example.springdemo.user_account.UserAccount;

/*
 * We build this entity with @Entity and @Data to avoid declaring
 * Getters, Setters and Constructors.
 * 
 *  @Data .-  encapsulates (@RequiredArgsConstructor, @ToString, @Getter, @Setter, @EqualsAndHashCode)
 *  @RequiredArgsConstructor .- creates Constructor with Required Arguments
 *  @EqualsAndHashCode .- creates comparator and HashCode for serialization
 *  @ToString .- creates the ToString Method
 *  @Setter .- creates the Setters
 *  @Getter .- creates the Getters
 */
@Entity
public class UserMessage {
    @Id
    @GeneratedValue
    @Column(name="Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="UserAccountId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserAccount userAccount;
    
    @Column(name="Message")
    private String message;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public UserAccount getUserAccount() {return userAccount;}
    public void setUserAccount(UserAccount userAccount) {this.userAccount = userAccount;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public UserMessage(){}
    public UserMessage(Long id, UserAccount userAccount, String message){
        this.id=id;
        this.userAccount=userAccount;
        this.message=message;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserMessage other = (UserMessage) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (userAccount == null) {
            if (other.userAccount != null)
                return false;
        } else if (!userAccount.equals(other.userAccount))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userAccount == null) ? 0 : userAccount.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        return result;
    }
}