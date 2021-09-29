package com.VEA.TestWeb.Model;

import javax.persistence.*;

@Entity
@Table(name = "[User]")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    @Column(name = "[Name]")
    public String Name;

    @Column(name = "[LastName]")
    public String LastName;

    public User() { }

    public User(String name, String lastName)
    {
        Name = name;
        LastName = lastName;
    }

    public int GetId() {
        return Id;
    }

    public String GetName() {
        return Name;
    }

    public String GetLastName() {
        return LastName;
    }

    public void SetName(String name) {
        Name = name;
    }

    public void SetLastName(String lastName) {
        LastName = lastName;
    }
}
