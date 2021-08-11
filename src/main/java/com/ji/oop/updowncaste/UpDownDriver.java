package com.ji.oop.updowncaste;

public class UpDownDriver {
    /* Syntax of Upcasting      ->  Parent p = new Child(); Implicit
       Syntax of Downcasting    ->  Child c = (Child)p; Explicit
    */
    public static void main(String[] args) {
        UpDownCaste p = new Child();
        p.getName();
        p.getAge();
        Child c = (Child) p;
        c.getName();
    }
}
