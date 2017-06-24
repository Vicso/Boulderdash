package model;

/**
 * <h1>The Class ExitGate</h1>
 *
 * @version 1.0
 */
public class ExitGate extends Element{

    /** Variable who will use for seek sprite **/
    private final static String STRING = "4";

    /** create DP singleton */
    private static ExitGate EXITGATE;
    
    /**
     * constructor of exitGate
     * @param position
     *      the position of the gate
     * @param mine
     *      the actual mine
     */
    private ExitGate(Position position, Mine mine){
        super(position, STRING, mine);
        behaviour = new Fix(this);
    }


    /**
     * Get the exitGate instance
     * @param position
     *      get the Exit Gate position
     * @param mine
     *      Get the actual mine
     * @return EXITGATE
     */
    public static ExitGate getInstance(Position position, Mine mine){
		if(EXITGATE == null){
			EXITGATE = new ExitGate(position, mine);
		}
		return EXITGATE;
    }
}
