package com.ji.oop.objectpool;

public class EmployeeDriver {
    public static void main(String[] args) {
        Employee e1 = Employee.getEmployeeInstance();
        Employee e2 = Employee.getEmployeeInstance();
        Employee e3 = Employee.getEmployeeInstance();
        Employee e4 = Employee.getEmployeeInstance();
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);


    }

}
