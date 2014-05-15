import java.util.Scanner;

public class CastingQuestions {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		CastingQuestions cq = new CastingQuestions();
		System.out.println("Determine whether the following lines are legal or not legal. If they are legal, give the value of the variable.");
		scan.nextLine();
		cq.method1();
		cq.method2();
		cq.method3();
		cq.method4();
		cq.method5();
		cq.method6();
		cq.method7();
		cq.method8();
		cq.method9();
		cq.method10();
		cq.method11();
		cq.method12();
		cq.method13();
		cq.method14();
		cq.method15();
		cq.method16();
		cq.method17();
		cq.method18();
		cq.method19();
		cq.method20();
		cq.method21();
		cq.method22();
		cq.method23();
		cq.method24();
		cq.method25();
	}

	public void method1() {
		System.out.print("int i = 5;");
		scan.nextLine();
		int i = 5;
		System.out.println("i: " + i);
		scan.nextLine();
	}

	public void method2() {
		System.out.print("byte b = 5;");
		scan.nextLine();
		byte b = 5;
		System.out.println("b: " +b);
		scan.nextLine();
	}
	
	public void method3() {
		System.out.print("double d = 5;");
		scan.nextLine();
		double d = 5;
		System.out.println("d: " + d);
		scan.nextLine();
	}
	
	public void method4() {
		System.out.print("long l = 5.0;");
		scan.nextLine();
		System.out.println("error: possible loss of precision.");
		scan.nextLine();
	}

	public void method5() {
		System.out.print("float f = 5.0;");
		scan.nextLine();
		System.out.println("error: possible loss of precision.");
		scan.nextLine();
	}

	public void method6() {
		System.out.print("double d = 5.0;");
		scan.nextLine();
		double d = 5.0;
		System.out.println("d: " + d);
		scan.nextLine();
	}

	public void method7() {
		System.out.print("double d = 5.0f;");
		scan.nextLine();
		double d = 5.0f;
		System.out.println("d: " + d);
		scan.nextLine();
	}

	public void method8() {
		System.out.print("long l = 500;");
		scan.nextLine();
		long l = 500;
		System.out.println("l: " + l);
		scan.nextLine();
	}

	public void method9() {
		System.out.print("char c = 65;");
		scan.nextLine();
		char c = 65;
		System.out.println("c: " + c);
		scan.nextLine();
	}

	public void method10() {
		System.out.print("int i = (int) 5 / 2.0;");
		scan.nextLine();
		System.out.println("error: possible loss of precision.");
		scan.nextLine();
	}

	public void method11() {
		System.out.print("int i = (int) (5 / 2.0);");
		scan.nextLine();
		int i = (int) (5 / 2.0);
		System.out.println("i: " + i);
		scan.nextLine();
	}

	public void method12() {
		System.out.print("double d = 2 / 5;");
		scan.nextLine();
		double d = 2 / 5;
		System.out.println("d: " + d);
		scan.nextLine();
	}

	public void method13() {
		System.out.print("double d = (double) 2 / 5;");
		scan.nextLine();
		double d = (double) 2 / 5;
		System.out.println("d: " + d);
		scan.nextLine();
	}

	public void method14() {
		System.out.print("double d = (double) (2 / 5);");
		scan.nextLine();
		double d = (double) (2 / 5);
		System.out.println("d: " + d);
		scan.nextLine();
	}

	public void method15() {
		System.out.print("int i = 2.0 + 2 * 2;");
		scan.nextLine();
		System.out.println("error: possible loss of precision.");
		scan.nextLine();
	}

	public void method16() {
		System.out.print("float f = (5.5 * 2.0f) + 5 / 2;");
		scan.nextLine();
		System.out.println("error: possible loss of precision.");
		scan.nextLine();
	}

	public void method17() {
		System.out.print("float f = (float) (5.5 * 2.0f) + 5 / 2;");
		scan.nextLine();
		float f = (float) (5.5 * 2.0f) + 5 / 2;
		System.out.println("f: " +  f);
		scan.nextLine();
	}

	public void method18() {
		System.out.print("int i = 5 - 2 * 4 / 2;");
		scan.nextLine();
		int i = 5 - 2 * 4 / 2;
		System.out.println("i: " +  i);
		scan.nextLine();
	}

	public void method19() {
		System.out.print("int i = -5 % 3;");
		scan.nextLine();
		int i = -5 % 3;
		System.out.println("i: " +  i);
		scan.nextLine();
	}

	public void method20() {
		System.out.print("int i = 5 % -3;");
		scan.nextLine();
		int i = 5 % -3;
		System.out.println("i: " +  i);
		scan.nextLine();
	}

	public void method21() {
		System.out.print("int i = 3 % 5;");
		scan.nextLine();
		int i = 3 % 5;
		System.out.println("i: " +  i);
		scan.nextLine();
	}

	public void method22() {
		System.out.print("int i = 4 + 3 % 5;");
		scan.nextLine();
		int i = 4 + 3 % 5;
		System.out.println("i: " +  i);
		scan.nextLine();
	}

	public void method23() {
		System.out.print("int i = (int) (7.0 / 3) + (int) 3 * 5.0;");
		scan.nextLine();
		System.out.println("error: possible loss of precision.");
		scan.nextLine();
	}

	public void method24() {
		System.out.print("int i = 100 % 500 % 9 % 4 / 2;");
		scan.nextLine();
		int i = 100 % 500 % 9 % 4 / 2;
		System.out.println("i: " +  i);
		scan.nextLine();
	}

	public void method25() {
		System.out.print("double d = (int) 5.0d + 2f / 3;");
		scan.nextLine();
		double d = (int) 5.0d + 2f / 3;
		System.out.println("d: " +  d);
		scan.nextLine();
	}
}