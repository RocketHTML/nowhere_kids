public class Toolbox {
	// helps with timing, printing (probably), but mostly timing

	public static void print(String text){
		System.out.println(text);
		System.out.println();
		sleep(2);
	}

	public static void sleep(int sec){
		try{
		int mili = sec * 1000;
		Thread.sleep(mili);
		}
		catch(InterruptedException e){

		}
	}


}