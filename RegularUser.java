
package com.mycompany.librarysystem;


public class RegularUser extends User{
     private static final int MAX_POINTS_LIMIT = 10;
    private int points;

    public RegularUser(String username, String password) {
        super(username, password);
        this.points = 0;
    }
    
    // Empty constructor
    public RegularUser() {
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
    
    @Override
    public String toString() {
        return "RegularUser{" +
                "points=" + points +
                "} " + super.toString();
    }

}
