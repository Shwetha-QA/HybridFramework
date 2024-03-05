package com.ots.testcases;

import org.testng.annotations.Test;

import com.ots.base.BaseClass;
import com.ots.pages.CoursePage;
import com.ots.pages.HomePage;
import com.ots.pages.LoginPage;
import org.testng.Assert;

public class ManageCourses extends BaseClass
{
	@Test
	public void createCourse() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		
		HomePage home=login.loginToApplicationAsAdminUser("admin@email.com", "admin@123");
		
		home.clickOnManageCourses();
		
		CoursePage course = new CoursePage(driver);
		
		course.addCourse(System.getProperty("user.dir")+"/TestData/Java.png", "Java", "Java Course", "Shwetha Sushruth", "15000");
		
		Assert.assertTrue(course.checkCoursePresence());		
	}
	
	@Test(priority=1)
	public void deactivateCourse() throws InterruptedException
	{
	
		CoursePage course = new CoursePage(driver);
		
		course.courseDeactivate();
		
		Thread.sleep(10000);

		
	}
	
	@Test(priority=2,dependsOnMethods = "deactivateCourse")
	public void activatedCourse()
	{
		// complete this method
		
	}
	
	@Test(priority=3,dependsOnMethods = "createCourse")
	public void deletCourse()
	{
		
		// complete this method
	}

}
