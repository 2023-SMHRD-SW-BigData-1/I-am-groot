package MiniProject;

public class PlayerDTO {


	
	private String ID;
	private String PW;
	private int POINT ; 
	
	
	public int getPOINT() {
		return POINT;
	}


	public void setPOINT(int pOINT) {
		POINT = pOINT;
	}


	public PlayerDTO(int pOINT) {
		super();
		POINT = pOINT;
	}


	public PlayerDTO(String iD, String pW) {
		super();
		ID = iD;
		PW = pW;
		
	}
	


	public PlayerDTO(String iD, int pOINT) {
		super();
		ID = iD;
		POINT = pOINT;
	}


	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}


	
	
	
	
	
}
