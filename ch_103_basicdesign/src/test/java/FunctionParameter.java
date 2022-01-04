/**
 * 方法参数：方法是按值传递还是按引用传递
 *
 */
public class FunctionParameter {
    public static void main(String[] args) {
        Employee jack = new Employee("jack", 30, "Man");
        System.out.println(jack.getGender());
        FunctionParameter fp = new FunctionParameter();
        fp.changeGender(jack);
        System.out.println(jack.getGender());
        System.out.print("\n\n\n");
        int num = 10;
        fp.raiseByPercent(num);
        System.out.println(num);
    }

    public void changeGender(Employee e) {
        e.setGender("Women");
    }

    public void raiseByPercent(int num) {
        num *= 3;
    }
}
