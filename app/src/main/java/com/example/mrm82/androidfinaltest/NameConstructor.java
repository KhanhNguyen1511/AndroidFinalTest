package com.example.mrm82.androidfinaltest;

public class NameConstructor {
    String Name;
    String PersonClass;

    public NameConstructor(String name, String personClass) {
        Name = name;
        PersonClass = personClass;
    }

    public NameConstructor() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPersonClass() {
        return PersonClass;
    }

    public void setPersonClass(String personClass) {
        PersonClass = personClass;
    }
}
