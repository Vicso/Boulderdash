package model;

/**
 * <h1> Background Class</h1>
 * 
 * @version 1.0
 */
class Background extends Element {

	 /** Variable who will use for seek sprite **/
    private final static String STRING = "0";
	
	public Background(Position position, Mine mine) {
		super(position, STRING, mine);
		behaviour = new Fix(this);
	}

}
