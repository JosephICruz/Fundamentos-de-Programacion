package Automation;

public class JavaBasicProgram2 {

	public static void main(String[] args) {

		try {

			String[] list = { "string1", "string2", "string3" };

			for (int i = 0; i < 3; i++) {
				System.out.println(list[i]);
			}

			for (String str : list) {
				System.out.println(str);
			}
			System.out.println(list[4]);
		} catch (Exception e) {
			System.out.println("StackTrace:");
			e.printStackTrace();
		}

	}

}
