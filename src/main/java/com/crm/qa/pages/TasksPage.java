package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
public class TasksPage extends TestBase{

	public TasksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksPageLevel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newTasksLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksTitle;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement NewTaskTitle;
	
	@FindBy(xpath="//div[@name='status']")
	WebElement taskStatus;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveTasksLink;

	public boolean verifytasksPageLevel() {
		return tasksPageLevel.isDisplayed();
	}
	
	public void creatNewTask(String title) throws InterruptedException {
		newTasksLink.click();
		NewTaskTitle.sendKeys(title);
		taskStatus.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@name='status']//div[3]"));
		Thread.sleep(2000);
		saveTasksLink.click();
		
	}
}
//Shakir