package com.jeeproject.renocraft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User")
public class User {
    private String name;
    @Id
    private String username;//nom profil
    private String email;
    private String phone;
    private String password;
    private String cpassword;//confirmation
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Commande> commandes;

    public int getOrderCount() {
        return commandes != null ? commandes.size() : 0;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", cpassword='" + cpassword + '\'' +
                '}';
    }
}
