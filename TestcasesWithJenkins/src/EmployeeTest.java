import java.util.HashMap;

public class EmployeeTest {

	static HashMap<Integer, String> emp = new HashMap<Integer, String>();

	public static String addEmp(int empid, String empname) {
		String res = emp.put(empid, empname);
		//System.out.println(res);
		return res;
	}

	public static String updateEmp(int empid, String empname) {
		String res = emp.put(empid, empname);
		System.out.println(res);
		return res;
	}

	public static String deleteEmp(int empid) {
		String res = emp.remove(empid);
		System.out.println(res);
		return res;
	}

	public static String fetchEmp(int empid) {
		String res = emp.get(empid);
		System.out.println(res);
		return res;
	}

	public static int fetchAllEmps() {
		return emp.size();
	}
//check
}