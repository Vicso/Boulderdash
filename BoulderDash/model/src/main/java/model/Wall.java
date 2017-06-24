package model;

 /**
 * <h1>The Class Element</h1>
 *
 * @version 1.0
 */

 class Wall extends Element{

    /** Variable who will use for seek sprite **/
    private final static String STRING = "7";

    /**
     * Instantiate a new wall
     * @param position
     *      the position of the wall
     * @param mine
     *      the actual mine
     */
    public Wall(Position positon, Mine mine){
        super(positon, STRING, mine);
        behaviour = new Fix(this);
    }
}
