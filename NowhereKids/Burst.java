public class Burst implements Character{
	String name;

	public Burst(String name){
		this.name = name;
	}

	public Burst(){
		this.name = "Bull";
	}

	public Move move(int dmg_taken, Move enemy_move, int enemy_dmg){
		Move choice = Move.ATTACK;
		Toolbox.print(this.name + " rams hard!!");
		return choice;
	}


	public String name(){
		return this.name;
	}
}