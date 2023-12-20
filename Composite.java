import java.util.*;
interface Component{
    public String getName();
}
class Employee implements Component{
    public String name;
    public Employee(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
class Department implements Component{

    private String name;
    private List<Component> children;
    public Department(String name, List<Component> children){
        this.name = name;
        this.children = children;
    }
    public String getName(){
        return this.name;
    }
    public List<Component> getChildren(){return children;}

    public void view() {
        System.out.println("Department: " + getName());
        viewHelper(this, 1);
    }

    private void viewHelper(Component component, int depth) {
        // Indent based on depth
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        // Print the name of the current component
        System.out.println(component.getName());

        if (component instanceof Department) {
            List<Component> children = ((Department) component).getChildren();
            for (Component child : children) {
                // Recursive call for each child
                viewHelper(child, depth + 1);
            }
        }
    }
}
public class Composite {
    public static void main(String []args){
        Employee emp1 = new Employee("Employee1");
        List<Component> dep1Children = new LinkedList<>();

        dep1Children.add(new Employee("emp2"));
        dep1Children.add(new Employee("emp3"));

        Department dep1 = new Department("Department1",dep1Children);


        List<Component> dep2Children = new LinkedList<>();
        dep2Children.add(new Employee("emp4"));
        dep2Children.add(dep1);

        Department dep2 = new Department("Department2", dep2Children);
        dep2.view();

    }
}
