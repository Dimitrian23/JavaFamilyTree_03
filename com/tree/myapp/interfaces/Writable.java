package com.tree.myapp.interfaces;

import com.tree.myapp.FamilyTree;

public interface Writable  {
    void save(FamilyTree tree, String filename);

    FamilyTree load(String filename);
}