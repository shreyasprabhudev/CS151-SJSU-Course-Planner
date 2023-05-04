package courseplanner;

public class PlannerTest {
	public static void main(String[] args) {
		Controller con = new Controller();
		User student = new Student("Natalie", "Kao", "SS-0000","Natalie123!");
		con.addUser(student);

	}
}
