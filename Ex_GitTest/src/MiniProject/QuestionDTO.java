package MiniProject;

import java.util.Objects;

public class QuestionDTO {

	private String QS ; 
	private String ANSWER;
	
	

	public QuestionDTO(String qS, String aNSWER) {
		super();
		QS = qS;
		ANSWER = aNSWER;
	}

	public String getQS() {
		return QS;
	}

	public void setQS(String qS) {
		QS = qS;
	}

	public String getANSWER() {
		return ANSWER;
	}

	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	} 
	
	
}
