package testng;

import utilities.MyBrowserManager;

public class TestResults {

	MyBrowserManager browser;
	String strResult;
	boolean booleanReult;
	int intResult;
	float floatResult;

	public TestResults() {}
	
	public TestResults(MyBrowserManager browser, String strResult) {
		this.browser = browser;
		this.strResult = strResult;
	}
	
	public TestResults(MyBrowserManager browser, boolean booleanReult) {
		this.browser = browser;
		this.booleanReult = booleanReult;
	}
	public TestResults(MyBrowserManager browser, int intResult) {
		this.browser = browser;
		this.intResult = intResult;
	}
	public TestResults(MyBrowserManager browser, float floatResult) {
		this.browser = browser;
		this.floatResult = floatResult;
	}


	public MyBrowserManager getBrowser() {
		return browser;
	}

	public void setBrowser(MyBrowserManager browser) {
		this.browser = browser;
	}

	public String getStrResult() {
		return strResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}

	public boolean isBooleanReult() {
		return booleanReult;
	}

	public void setBooleanReult(boolean booleanReult) {
		this.booleanReult = booleanReult;
	}

	public int getIntResult() {
		return intResult;
	}

	public void setIntResult(int intResult) {
		this.intResult = intResult;
	}

	public float getFloatResult() {
		return floatResult;
	}

	public void setFloatResult(float floatResult) {
		this.floatResult = floatResult;
	}

}
