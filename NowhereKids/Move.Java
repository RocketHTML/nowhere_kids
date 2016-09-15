public enum Move { // Move.ATTACK means new Move(0)? 
	NONE(0),
	ATTACK (1), 
	SPECIAL(2)
	;

	public final int move;

	Move(int moveCode){

		this.move = moveCode;
	}
}