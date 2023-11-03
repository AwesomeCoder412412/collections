
/**
 * A Castaway from the show Gilligan's Island
 *
 * @author Jack Segil
 * @version 1.0
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
    
    /**
     * Compares the first and last name.
     *
     * @param other castaway to compare
     * @return a negative integer, zero, positive integer 
     */
    @Override
    public int compareTo(Castaway other) {
        if (lastName.equals(other.lastName)) {
            return firstName.compareTo(other.firstName);
        } else {
            return lastName.compareTo(other.lastName);
        }
    }
    
    /**
     * Returns whether the first and last names are equal.
     *
     * @param other castaway to compare
     * @return true if they're equal, false if they're not
     */
    public boolean equals(Castaway other) {
        return compareTo(other) == 0;
    }
    
    /**
     * Returns the first and last name of the castaway.
     *
     * @return the first and last name of the castaway
     */
    public String toString() {
        return firstName + " " + lastName;
    }
    
    
    
    

}
