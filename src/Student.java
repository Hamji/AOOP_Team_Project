
public class Student {
	// 출석
	int attendance[];
	
	// 중간고사
	double midtermExamScore;
	
	// 기말고사
	double finalExamScore;
	
	// 기타점수
	double etcScore;
	
	// 퀴즈점수
	double quizScore;
	
	// 발표점수
	double announcementScore;
	
	// 보고서 점수
	double reportScore;
	
	// 아무런 매개변수 없을시
	public Student() {
		this.attendance = new int[16];
		for(int i = 0; i < attendance.length;i++)
			attendance[i] = -1;
			
		this.setMidtermExamScore(0);
		this.setFinalExamScore(0);
		this.setEtcScore(0);
		this.setQuizScore(0);
		this.setAnnouncementScore(0);
		this.setReportScore(0);
	}

	public Student(int[] attendance, double midtermExamScore, double finalExamScore, double etcScore, double quizScore, double announcementScore, double reportScore) {
		this.setAttendance(attendance);
		this.setMidtermExamScore(midtermExamScore);
		this.setFinalExamScore(finalExamScore);
		this.setEtcScore(etcScore);
		this.setQuizScore(quizScore);
		this.setAnnouncementScore(announcementScore);
		this.setReportScore(reportScore);
	}
	
	public void setAttendance(int[] attendance) {
		this.attendance = attendance;
	}

	public void setMidtermExamScore(double midtermExamScore) {
		this.midtermExamScore = midtermExamScore;
	}

	public void setFinalExamScore(double finalExamScore) {
		this.finalExamScore = finalExamScore;
	}

	public void setEtcScore(double etcScore) {
		this.etcScore = etcScore;
	}

	public void setQuizScore(double quizScore) {
		this.quizScore = quizScore;
	}

	public void setAnnouncementScore(double announcementScore) {
		this.announcementScore = announcementScore;
	}

	public void setReportScore(double reportScore) {
		this.reportScore = reportScore;
	}

	public int[] getAttendance() {
		return attendance;
	}

	public double getMidtermExamScore() {
		return midtermExamScore;
	}

	public double getFinalExamScore() {
		return finalExamScore;
	}

	public double getEtcScore() {
		return etcScore;
	}

	public double getQuizScore() {
		return quizScore;
	}

	public double getAnnouncementScore() {
		return announcementScore;
	}

	public double getReportScore() {
		return reportScore;
	}
	
	
}
