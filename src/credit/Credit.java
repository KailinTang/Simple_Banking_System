package credit;

public class Credit {
	int ID;
	boolean creStat;
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public boolean isCreStat() {
		return creStat;
	}
	public void setCreStat(boolean creStat) {
		this.creStat = creStat;
	}
	@Override
	public String toString() {
		return "Credit [ID=" + ID + ", creStat=" + creStat + "]";
	}
	
}
