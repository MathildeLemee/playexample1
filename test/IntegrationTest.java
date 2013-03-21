import org.junit.*;
import play.test.*;
import play.libs.F.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class IntegrationTest {

  /**
   * add your integration test here
   * in this example we just check if the welcome page is being shown
   */   
  @Test
  public void test() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.title()).isEqualTo("Todo list");
        browser.fill("#label").with("Buy Milk");
        browser.submit("#submit");
        assertThat(browser.$("h1").first().getText()).isEqualTo("1 task(s)");
      }
    });
  }

  @Test
  public void testWithPage() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        ToDoListPage todopage = new ToDoListPage();
        browser.goTo(todopage);
        todopage.fillAndSubmitForm("Get Milk");
        todopage.isAt();
        assertThat(browser.$("h1").first().getText()).isEqualTo("1 task(s)");
      }
    });
  }

}
