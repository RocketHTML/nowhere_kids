public class World {
	Character[] C = new Character[2];	int[] power = {1,1};	
	int[] charges = {0,0};	int[] HP = {20,20};
	boolean blocked = false; 

	public World(Character one, Character two)	
	{C[0] = one; C[1] = two;}

	public void init(){
		Move c1_move = C[0].move(0, Move.NONE, 0);
		Move c2_move = C[1].move(0, Move.NONE, 0);

		while (HP[0] > 0 && HP[1] > 0){

			changeState(c1_move, c2_move);
			printHP();
			if(HP[0] <= 0 || HP[1] <= 0) break;
			Move c1_last_move = c1_move; Move c2_last_move = c2_move;
			c1_move = C[0].move(HP[0], c2_last_move, HP[1]);
			c2_move = C[1].move(HP[1], c1_last_move, HP[0]);
		}
		int x = (HP[0] <= 0) ? 0 : 1;
		Toolbox.print(C[x].name() + " has fainted...");
		
	}


	private void changeState(Move c1_move, Move c2_move){
		//reset defences;	nothing > blocks > charge == attacks;	discharge;
		if(c1_move == Move.BLOCK || c2_move == Move.BLOCK) blocked = true;
		changeState(c1_move, 0);
		changeState(c2_move, 1);
		blocked = false;
	}

	private void changeState(Move move, int me){
		switch(move){
			case ATTACK : 
				int x = (me + 1) % 2;
				int dmg = (!blocked)? power[me] + charges[me]-- : 
				(power[me] + charges[me]--)/4;
				HP[x] -= dmg;
				if (charges[me] < 0) charges[me] = 0;
				break;
			case CHARGE :
				charges[me]++;
				if(charges[me] >= 3){
					if(charges[me] > 3)
						System.out.println(C[me].name() + " has max charge");
					charges[me] = 3;
				}
				break ;
		}
	}


	private void printHP() {
		Toolbox.print(C[0].name() + " HP: "+HP[0]
			+ "\n" + C[1].name() + " HP: "+HP[1]);
	}



	
	




}