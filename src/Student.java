
public class Student {
	
	String name;
	
	String major;
	
	String number;
	
	String gender;
	
	
	// 출석
	int attendance[] = new int[16];
	
	// 중간고사
	int midtermExamScore;
	
	// 기말고사
	int finalExamScore;
	
	// 기타점수
	int etcScore;
	
	// 퀴즈점수
	int quizScore;
	
	// 발표점수
	int announcementScore;
	
	// 보고서 점수
	int reportScore;
	
	// 총점
	int totalScore;
	
	

	// 아무런 매개변수 없을시
	public Student() {
		this.attendance = new int[16];
			
		this.setMidtermExamScore(0);
		this.setFinalExamScore(0);
		this.setEtcScore(0);
		this.setQuizScore(0);
		this.setAnnouncementScore(0);
		this.setReportScore(0);
	}
	
	public Student(String name, String major, String number, String gender) {
		this.name = name;
		this.major = major;
		this.number = number;
		this.gender = gender;
		
			
		this.setMidtermExamScore(0);
		this.setFinalExamScore(0);
		this.setEtcScore(0);
		this.setQuizScore(0);
		this.setAnnouncementScore(0);
		this.setReportScore(0);
	}
	
	public void SetScore(int[] attendance, int midtermExamScore, int finalExamScore, int etcScore, int quizScore, int announcementScore, int reportScore) {
		this.setAttendance(attendance);
		this.setMidtermExamScore(midtermExamScore);
		this.setFinalExamScore(finalExamScore);
		this.setEtcScore(etcScore);
		this.setQuizScore(quizScore);
		this.setAnnouncementScore(announcementScore);
		this.setReportScore(reportScore);
	}
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public String getNumber() {
		return number;
	}

	public String getGender() {
		return gender;
	}

	public void setAttendance(int[] attendance) {
		this.attendance = attendance;
	}

	public void setMidtermExamScore(int midtermExamScore) {
		this.midtermExamScore = midtermExamScore;
	}

	public void setFinalExamScore(int finalExamScore) {
		this.finalExamScore = finalExamScore;
	}

	public void setEtcScore(int etcScore) {
		this.etcScore = etcScore;
	}

	public void setQuizScore(int quizScore) {
		this.quizScore = quizScore;
	}

	public void setAnnouncementScore(int announcementScore) {
		this.announcementScore = announcementScore;
	}

	public void setReportScore(int reportScore) {
		this.reportScore = reportScore;
	}

	public int[] getAttendance() {
		return attendance;
	}

	public int getMidtermExamScore() {
		return midtermExamScore;
	}

	public int getFinalExamScore() {
		return finalExamScore;
	}

	public int getEtcScore() {
		return etcScore;
	}

	public int getQuizScore() {
		return quizScore;
	}

	public int getAnnouncementScore() {
		return announcementScore;
	}

	public int getReportScore() {
		return reportScore;
	}
	
	
}
