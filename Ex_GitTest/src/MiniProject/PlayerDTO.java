package MiniProject;

public class PlayerDTO {

	private String ID;
	private String PW;
	private String NICK;
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


	public PlayerDTO(String iD, String pW, String nICK) {
		super();
		ID = iD;
		PW = pW;
		NICK = nICK;
		
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

	public String getNICK() {
		return NICK;
	}

	public void setNICK(String nICK) {
		NICK = nICK;
	}

	
	
	
	
	
}
