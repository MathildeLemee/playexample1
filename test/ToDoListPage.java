import org.fluentlenium.core.FluentPage;
import org.junit.Test;

import play.test.TestBrowser;

public class ToDoListPage extends FluentPage {
  
  TestBrowser browser;
  
  public ToDoListPage(TestBrowser browser) {
    this.browser = browser;
  }

  public String getUrl() {
    return "http://localhost:3333/";
  }
  
  @Test
  public void isAt() {
    //assert(title()).equals("Todo list");
  }
  
  public void fillAndSubmitForm(String task) {
    fill("#label").with(task);
    submit("#submit");
  }

}
