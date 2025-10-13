/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao {
    // Instanced variables
    private ArrayList<Composer> composers; // Although the assignment calls for a generic List, a List is an interface and cannot be instantiated, thus we use ArrayList.
    
    /** 
     * Default constructor for the MemComposerDao class.
     * @return returns an instance of MemComposerDao with a List of 5 sample Composer objects.
    */
    MemComposerDao()
    {
        composers = new ArrayList<Composer>();
        composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    } // end constructor

    /** 
     * Override method with no arguments, which is used to return a list of composer objects.
     * @return the list of composer objects, composers.
    */
    @Override
    public List<Composer> findAll() {
        return composers; // Return the currently stored list of composers.
    }

    /** 
     * Override method with one argument, which is used to a single composer matching the input id.
     * @param id Integer
     * @return a single composer object with id equal to argument, if it exists
    */
    @Override
    public Composer findBy(Integer id) {
        // Search through the list of composers.
        for (Composer c : composers)
        {
            // If the ID matches the ID of the iterating composer object, return that object.
            if (id == c.getId()) { return c; }
        }
        return null; // If we fail to find the ID, return a null composer.
    }

    /** 
     * Override method with one argument, which is used to insert a composer into the list of composers.
     * @param Composer composer
    */
    @Override
    public void insert(Composer composer) {
        if (composer == null) { return; } // Ensure the composer input is non-null.
        composers.add(composer); // Add the composer from to the List of composers.
    }
}
