package org.corejavavolume.objectclass;

import java.util.logging.Logger;

/**
 * 昨天面试，死在这里了
 * Java传参方式测试
 */
public class ParamTest {
    private static final Logger logger = Logger.getLogger("ParamTest");

    public static void main(String[] args) {
        /**
         * 测试方法修改基本数据类型的参数：无法修改
         */
        logger.info("Testing tripleValue:");
        double percent = 10;
        logger.info("before percent = " + percent);
        tripleValue(percent);
        logger.info("after percent = " + percent);
        logger.info("******************************\n");

        /**
         * 测试方法修改对象参数的状态
         */
        logger.info("Testing object property, triple salary:");
        Employee harry = new Employee("Harry", 5000);
        logger.info("befor salary is " + harry.getSalary());
        tripleSalary(harry);
        logger.info("after salary is " + harry.getSalary());
        logger.info("******************************\n");

        /**
         * 方法给一个对象参数重新赋予新的对象引用：无法
         */
        logger.info("Testing swap:");
        Employee a = new Employee("a", 70000);
        Employee b = new Employee("b", 40000);
        logger.info("before a name is :" + a.getName());
        logger.info("before b name is ：" + b.getName());
        swap(a,b);
        logger.info("after a name is :" + a.getName());
        logger.info("after b name is " + b.getName());
    }

    private static void swap(Employee a, Employee b) {
        Employee x = a;
        a = b;
        b = x;
        logger.info("end of method swap a = " + a.getName());
        logger.info("end of method swap b = " + b.getName());
    }

    private static void tripleSalary(Employee employee) {
        employee.raiseSalary(200);
        logger.info("end of method tripleSalary = " + employee.getSalary());
    }

    static class Employee {
        private String name;
        private double salary;

        public Employee(String n, double s) {
            name = n;
            salary = s;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public void raiseSalary(double byPercent) {
            double raise = salary * byPercent / 100;
            salary += raise;
        }
    }

    private static void tripleValue(double p) {
        p = 3 * p;
        logger.info("end of method tripleValue, p = " + p);
    }
}
/**
 * 信息: Testing tripleValue:
 * 信息: before percent = 10.0
 * 信息: end of method tripleValue, p = 30.0
 * 信息: after percent = 10.0
 * [总结]方法不能修改基本数据类型的参数
 * **********************************************
 *
 */
