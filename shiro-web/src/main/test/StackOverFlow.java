/*
 *用户：sky-吴
 *日期：2019/8/28
 */
public class StackOverFlow {

	public static String callMe(String str) {
		System.out.println(str);
		callMe(str);
		return str;
	}

	public static void main(String[] args) {
		StackOverFlow.callMe("StackOverFlow");
	}

}
