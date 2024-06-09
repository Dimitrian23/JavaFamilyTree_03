package com.tree.myapp.handler;

import com.tree.myapp.FamilyTree;
import com.tree.myapp.entity.Human;
import com.tree.myapp.interfaces.Writable;

import java.io.*;
import java.util.List;

public class FileHandler implements Writable {
    @Override
    public void save(FamilyTree tree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tree.getFamilyMembers());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree load(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Human> familyMembers = (List<Human>) ois.readObject();
            FamilyTree tree = new FamilyTree();
            for (Human human : familyMembers) {
                tree.addMember(human);
            }
            return tree;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
