import org.fluentlenium.core.FluentPage;
import org.junit.Test;

import play.test.TestBrowser;

public class ToDoListPage extends FluentPage {
 
  public String getUrl() {
    return "tasks";
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
