package com.example.springdemo.user_account;

//Jakarta Imports
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
//Java Imports
//Project Imports

/*
 * We build this entity with @Entity and have to declare 
 * Getters, Setters and Constructors, we could add more 
 * powerful Decorators, but in this case is to clarify the work they do.
 * 
 *  @RequiredArgsConstructor .- creates Constructor with Required Arguments
 *  @EqualsAndHashCode .- creates comparator and HashCode for serialization
 *  @ToString .- creates the ToString Method
 *  @Setter .- creates the Setters
 *  @Getter .- creates the Getters
 *  @Data .-  encapsulates (@RequiredArgsConstructor, @ToString, @Getter, @Setter, @EqualsAndHashCode)
 */
@Entity
@Table(name="UserAccount")
public class UserAccount {
    
    @Id
    @GeneratedValue
    @Column(name="Id")
    private Long id;
    
    @Column(name="FirstName", length = 50, nullable=false)
    private String firstName;
    
    @Column(name="LastName", length = 50)
    private String lastName;

    @Column(name="Active")
    private Boolean active;

    //@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    //private List<UserMessage> userMessages;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    
    public String getFirstName() {return firstName;}
    public void setFirstName(String name) {this.firstName = name;}
    
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    
    public Boolean getActive() {return active;}
    public void setActive(Boolean active) {this.active = active;}

    public UserAccount(){}
    public UserAccount(Long id){this.id=id;}
    public UserAccount(Long id, String firstName, String lastName, Boolean active){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.active=active;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("{");
        buffer.append("id:"+id);
        buffer.append(", firstName:\""+firstName+"\"");
        buffer.append(", lastName:\""+lastName+"\"");
        buffer.append(", active:\""+active+"\"");
        buffer.append("}");
        return buffer.toString();
    }
}