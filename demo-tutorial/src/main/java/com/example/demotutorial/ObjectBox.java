package com.example.demotutorial;

import io.objectbox.BoxStore;

public final class ObjectBox implements AutoCloseable {
    private final BoxStore boxStore;

    public ObjectBox() {
        this.boxStore = MyObjectBox.builder()
                .name("notes-db")
                .build();
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }

    @Override
    public void close() {
        boxStore.close();
    }
}
