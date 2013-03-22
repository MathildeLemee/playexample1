import org.fluentlenium.core.FluentPage;
 import org.openqa.selenium.WebDriver;
import play.test.TestBrowser;

public class ToDoListPage extends FluentPage {
  public ToDoListPage(WebDriver webDriver) {
    super(webDriver);
  }

  public String getUrl() {
    return "http://localhost:3333/tasks";
  }
  
  public void isAt() {
    //assert(title()).equals("Todo list");
  }
  
  public void fillAndSubmitForm(String task) {
    fill("#label").with(task);
    submit("#submit");
  }

}
