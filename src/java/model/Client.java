/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Client {
    private int clientID;
    private String username;
    private String password;
    private String email;
    private String address;

    public Client(int clientID, String username, String password, String email, String address) {
        this.clientID = clientID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    // Getters and setters

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" + "clientID=" + clientID + ", username=" + username + ", password=" + password + ", email=" + email + ", address=" + address + '}';
    }
    
}

