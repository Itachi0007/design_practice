package org.builder;

public class PersonBad {
    private int age;
    private String name;
    private String DOB;
    private String email;
    private Long phone;

    public PersonBad(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public PersonBad personBuilder(String DOB) {
        this.DOB = DOB;
        return this;
    }

    public PersonBad personBuilder(Long phone) {
        this.phone = phone;
        return this;
    }

    public PersonBad personBuilder(int age) {
        this.age = age;
        return this;
    }

    public PersonBad build() {
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", DOB='" + DOB + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
