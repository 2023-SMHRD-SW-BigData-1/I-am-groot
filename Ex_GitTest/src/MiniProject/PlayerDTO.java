package MiniProject;

public class PlayerDTO {


	
	private String ID;
	private String PW;
	private int POINT ; 
	
	private String path_url;
	private String path;
	private String title;
	private String spell;
	
	
	public String getPath_url() {
		return path_url;
	}


	public void setPath_url(String path_url) {
		this.path_url = path_url;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSpell() {
		return spell;
	}


	public void setSpell(String spell) {
		this.spell = spell;
	}


	public int getPOINT() {
		return POINT;
	}


	public void setPOINT(int pOINT) {
		POINT = pOINT;
	}


//	public PlayerDTO(String string) {
//		super();
//		POINT = string;
//	}


	public PlayerDTO(String iD, String pW) {
		super();
		ID = iD;
		PW = pW;
		
	}
	

	// POINT_INFO 테이블용
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


	
	// 노래를 받아와서 배열에 넣어주는용
	public PlayerDTO(String title) {
		super();
		this.title = title;
	
		
	}


	public PlayerDTO(String path, String title, String spell) {
		super();
		
		this.path = path;
		this.title = title;
		this.spell = spell;
	}


	

	


	
	
	
	
	
}
