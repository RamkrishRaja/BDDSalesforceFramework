package testPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BDConnector {
	protected static WebDriver driver;

	public static void launch() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
	}
	
	public BDConnector(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	@CacheLookup
	public static WebElement username;

	@FindBy(id="password")
	@CacheLookup
	public static WebElement password;
	
	public static WebElement getUsername() {
		return username;
	}

	public static WebElement getPassword() {
		return password;
	}
	public static String dbInputs(String location, String name) throws Exception {
		String value = null;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/NewSample", "root", "7708");
		Statement statement = connection.createStatement();
		String query = "select * from "+location+";";
		ResultSet executeQuery = statement.executeQuery(query);
		while(executeQuery.next()) {
			if(executeQuery.getString("Fieldnames").contains(name)) {
				 value = executeQuery.getString("Filedvalues");
				break;
			}else {
				System.out.println("Nothing");
			}
		}
		System.out.println(value);
		return value;
	}

	public static void main(String[] args) throws Exception {
		launch();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys(dbInputs("LeadInfor","Company"));
	}
}

//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/newsample", "root", "7708");
//		Statement statement = connection.createStatement();
//		ResultSet executeQuery = statement.executeQuery("select * from LeadInfor;");
//
//		while(executeQuery.next()) {
//			if(executeQuery.getString("Fieldnames").contains("Company")) {
//				String annualrevenue =executeQuery.getString("Filedvalues");
//				Thread.sleep(4000);
//				driver.findElement(By.id("username")).sendKeys(annualrevenue);
//				Thread.sleep(4000);
//				System.out.println(annualrevenue);
//				break;
//			}else {
//				System.out.println("Nothing");
//			}
//		}
//			
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://login.salesforce.com/");
//
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/newsample", "root", "7708");
//		if (connection.isClosed()) {
//			System.out.println("Not Connected");
//		} else {
//			System.out.println("Successfully Connected");
//		}
//		Statement statement = connection.createStatement();
//		ResultSet executeQuery = statement.executeQuery("select * from LeadInfor;");
//
//		while(executeQuery.next()) {
//			if(executeQuery.getString("Fieldnames").contains("Company")) {
//				String annualrevenue =executeQuery.getString("Filedvalues");
//				Thread.sleep(4000);
//				driver.findElement(By.id("username")).sendKeys(annualrevenue);
//				Thread.sleep(4000);
//				System.out.println(annualrevenue);
//			}else {
//				System.out.println("Nothing");
//			}
//			//System.out.println(executeQuery.getString("Filedvalues"));
//		}
