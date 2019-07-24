package hello.value.weather;

public class WeatherResponse {

	private String firstcity;
	private String secondtcity;
	private double firsttemp;
	private double secondtemp;

	public String getFirstcity() {
		return firstcity;
	}

	public void setFirstcity(String firstcity) {
		this.firstcity = firstcity;
	}

	public String getSecondtcity() {
		return secondtcity;
	}

	public void setSecondtcity(String secondtcity) {
		this.secondtcity = secondtcity;
	}

	public double getFirsttemp() {
		return firsttemp;
	}

	public void setFirsttemp(double firsttemp) {
		this.firsttemp = firsttemp;
	}

	public double getSecondtemp() {
		return secondtemp;
	}

	public void setSecondtemp(double secondtemp) {
		this.secondtemp = secondtemp;
	}
}
