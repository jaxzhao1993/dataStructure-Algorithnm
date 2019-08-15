package circleLinkedList;

public class GameBoy {
	private int number;
	private GameBoy nextBoy;
	public GameBoy(int number)
	{
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public GameBoy getNextBoy() {
		return nextBoy;
	}
	public void setNextBoy(GameBoy nextBoy) {
		this.nextBoy = nextBoy;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ð¡º¢"+number;
	}
}

