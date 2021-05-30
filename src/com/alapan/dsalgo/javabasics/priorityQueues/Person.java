package com.alapan.dsalgo.javabasics.priorityQueues;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                '}';
    }

    @Override
    public int compareTo(Person otherPerson) {
//        return Integer.compare(this.age,otherPerson.getAge());
//        return this.name.compareTo(otherPerson.getName());
        return -this.name.compareTo(otherPerson.getName());
    }
}
