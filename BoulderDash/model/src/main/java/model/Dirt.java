package model;


/**
 * <h1> Diamond Class</h1>
 * @version 1.0
 */

class Dirt extends Element {

    /** Variable who will use for seek sprite **/
    private final static String STRING = "2";


    /**
     * Instantiate a new dirt
     * @param positon
     * 		The position to set the new dirt
     * @param mine
     * 		The mine where set the new dirt
     */
    public Dirt(Position positon, Mine mine){
        super(positon, STRING, mine);
        behaviour = new Fix(this);
    }		
}
