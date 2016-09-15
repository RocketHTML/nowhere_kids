public class TomatoMan implements Character{
	String name = "AppleJack";
	String[] flavorText = {
		"*plants tomato seeds*",
		"*waters tomato plant*",
		"*picks a tomato*"
	};
	String attackText = "*chunks a tomato*";
	int charge = 0;

	public TomatoMan(String name){
		this.name = name;
		intro();
	}

	public TomatoMan(){
		intro();
	}

	public Move move(int dmg_taken, Move enemy_move, int enemy_dmg){
		Move choice = Move.CHARGE;
		if(charge < 3){
			Toolbox.print(name + ": "+flavorText[charge++]);
		}
		else{
			Toolbox.print(name + ": "+attackText);
			choice = Move.ATTACK;
			charge--;
		}
		return choice;
	}


	public String name(){
		return this.name;
	}

	private void intro(){
		Toolbox.print("\n"+name+": I put my heart into these tomatos you know....");
		Toolbox.sleep(2);
	}
}