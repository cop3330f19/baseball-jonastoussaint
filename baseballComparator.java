/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

import java.util.Comparator;

/**
 * Class on how to compare 2 States objects
 * @author Vanessa Coote
 */
public class baseballComparator implements Comparator<baseballClass> {
    
     /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     * @throws NullPointerException if an argument is null and this
     *         comparator does not permit null arguments
     * @throws ClassCastException if the arguments' types prevent them from
     *         being compared by this comparator.
     */
  /*  @Override
    public int compare(States o1, States o2) {
         return o1.getName().compareTo(o2.getName());
    }*/

    @Override
    public int compare(baseballClass o1, baseballClass o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return o1.getTeam().compareTo(o2.getTeam());
    }
    
}
