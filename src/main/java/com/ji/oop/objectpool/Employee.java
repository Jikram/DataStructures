package com.ji.oop.objectpool;
// Only create 3 objects.
public class Employee {
    int id;
    int age;
    static int count;
    static Employee obj;

    private Employee() {
        System.out.println("obj number :" + count);
        count++;
    }

    public static Employee getEmployeeInstance() {
        if(count < 3) {
            obj = new Employee();
            return obj;
        } else {
            System.out.println("Cannot create more that 3 objects returning previous object");
            return obj;
        }

    }
}
