
/**
 * Write a description of class Castaway here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Castaway implements Comparable<Castaway>
{
    private int score;
    private String firstName;
    private String lastName;
    private String gender;
    
    /**
     * Constructor for objects of class Castaway
     */
    public Castaway(String firstNameInit, String lastNameInit, int scoreInit, String genderInit)
    {
        firstName = firstNameInit;
        lastName = lastNameInit;
        score = scoreInit;
        gender = genderInit;
    }
    
    public int compareTo(Castaway other) {
        if (lastName.equals(other.lastName)) {
            return firstName.compareTo(other.firstName);
        } else {
            return lastName.compareTo(other.lastName);
        }
    }
    
    private boolean equals(Castaway other) {
        return compareTo(other) == 0;
    }
    
    public String toString() {
        return firstName + " " + lastName;
    }
    
    
    
    

}
