package ListenersDemo;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("On Test Finish");	
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("On Test Start");	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("On Test Failed But Within Success Percentage");
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("On Test Failure");
		String path=System.getProperty("user.dir");
		System.out.println(path);
		File f=new File(path+"/Screenshot/"+getDate());
		
		if (f.mkdirs()==true) {
			System.out.println("Folder Created");
		} else {
			System.out.println("Folder not Created");
		}
		File file=new File(f,"/screenshot_"+getDateAndTime()+".png");
		
		try {
			Robot robo=new Robot();
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect=new Rectangle(d);
			BufferedImage image=robo.createScreenCapture(rect);
			ImageIO.write(image, "png", file);
		} catch (AWTException e) {
			System.err.println("unable to take Screenshot");	
			e.printStackTrace();
		}catch(IOException e){
			System.err.println("Unable to take Screenshot");
			e.printStackTrace();
		}
	}
	private static String getDateAndTime() {
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmmss");
		String formatteddate = now.format(date);
		return formatteddate;
	}
	private static String getDate() {
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy_MM_dd");
		String formattedDate1=now.format(date);
		return formattedDate1;
	}
	

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("On Test Skip");
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("On Test Start");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("On Test Success");
		
	}
	

}
