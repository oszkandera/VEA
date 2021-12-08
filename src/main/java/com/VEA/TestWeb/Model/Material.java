package com.VEA.TestWeb.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "[Material]")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int id;

    @Column(name = "Code")
    public String code;

    @Column(name = "Name")
    public String name;
}
