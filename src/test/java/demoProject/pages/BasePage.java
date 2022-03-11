package demoProject.pages;

import demoProject.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
          public BasePage() {
              PageFactory.initElements(Driver.getDriver(), this);


          }
}
