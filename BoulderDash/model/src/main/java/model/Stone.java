package model;

/**
 * <h1>The Class Element</h1>
 *
 * @version 1.1
 */
class Stone extends Element{

    /** Variable who will use for seek sprite **/
    private final static String STRING = "6";

    /** constructor of Stone */
    public Stone(Position position, Mine mine){
        super(position, STRING, mine);
        behaviour = new Gravity(this);
    }
}
