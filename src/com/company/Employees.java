package com.company;

public class Employees {
    private String name;
    private int salary;
    private String sex;

    public Employees(String name, int salary, String sex) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", sex='" + sex + '\'' +
                '}';
    }
}
