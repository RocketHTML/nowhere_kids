public interface Character {
	public String version = "Nowhere Kids Character Build 1.0";

	public Move move(int dmg_taken, Move enemy_move, int enemy_dmg);

	public String name();
}