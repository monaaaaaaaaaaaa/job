import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

public class TestCasesEmp {

	@Before
	public void BeforeAll() {
		System.out.println("Started executing testcases for employee testing");
	}
	@After
	public void AfterAll() {
		System.out.println("Execution Completed");
	}
	@Test
	public void allOps() {
		String res=EmployeeTest.addEmp(1, "mona");
		String res1=EmployeeTest.addEmp(2,"ramya");
		String res2=EmployeeTest.addEmp(3,"nathira");
		String upd=EmployeeTest.updateEmp(2,"divya");
		String fetch=EmployeeTest.fetchEmp(3);
		int size=EmployeeTest.fetchAllEmps();
		String del=EmployeeTest.deleteEmp(3);
		int size1=EmployeeTest.fetchAllEmps();
		assertEquals(null,res);
		assertEquals("divya",upd);
		assertEquals("nathira",fetch);
		assertEquals(3,size);
		assertEquals("nathira",del);
		assertNotEquals(4,size1);
	}
	@Ignore
	public void add() {
		String res=EmployeeTest.addEmp(5, "mona");
		assertEquals("mona",res);
	}
}
