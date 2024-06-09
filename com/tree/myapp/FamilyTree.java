package com.tree.myapp;

import com.tree.myapp.entity.Human;
import com.tree.myapp.handler.FileHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human> {
    private List<Human> familyMembers;

    public FamilyTree() {
        this.familyMembers = new ArrayList<>();
    }

    public void addMember(Human human) {
        familyMembers.add(human);
    }

    public Human findMember(String name) {
        for (Human human : familyMembers) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void printFamilyTree() {
        for (Human human : familyMembers) {
            System.out.println(human);
        }
    }

    public List<Human> getFamilyMembers() {
        return familyMembers;
    }

    public void save(String filename) {
        FileHandler handler = new FileHandler();
        handler.save(this, filename);
    }

    public static FamilyTree load(String filename) {
        FileHandler handler = new FileHandler();
        return handler.load(filename);
    }

    @Override
    public Iterator<Human> iterator() {
        return familyMembers.iterator();
    }

    public void sortByName() {
        Collections.sort(familyMembers, Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(familyMembers, Comparator.comparing(Human::getDateOfBirth));
    }
}