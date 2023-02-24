package practise;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@Setter
public class PageObjModel {

    public PageObjModel(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "6565")
    private List<WebElement> countriesDropdown;
}
