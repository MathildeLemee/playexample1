import models.Task;
import org.junit.*;
import play.data.Form;
import play.mvc.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {
  
  static Form<Task> taskForm = Form.form(Task.class);

    @Test 
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }
    
    @Test
    public void renderTemplate() {
      running(fakeApplication(), new Runnable() {
        public void run() {
          Content html = views.html.index.render(Task.all(), taskForm);
          assertThat(contentType(html)).isEqualTo("text/html");
          assertThat(contentAsString(html)).contains("Todo");
        }
      });
    }
}
