package com.itheima.pojo;

public class Account {

    private int id;
    private String name;
    private double sal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }

    public Account(){

    }
    public Account(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }


}
