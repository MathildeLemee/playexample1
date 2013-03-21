package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

//import play.data.validation.Constraints.*;
//import play.db.ebean.*;
//import play.data.validation.Constraints.*;
//import javax.persistence.*;

@Entity
public class Task extends Model {

  private static final long serialVersionUID = 1L;

  @Id
  public Long id;
  
  @Required
  public String label;
  
  public static Finder<Long,Task> find = new Finder<Long,Task>(Long.class, Task.class);
  
  public static List<Task> all() {
    return find.all();
  }
  
  public String toString() {
    return String.format("<Task %s %d>", this.label, this.id);
  }
  
  public static void create(Task task) {
    task.save();
  }
  
  public static void delete(Long id) {
    find.ref(id).delete();
  }
    
}
