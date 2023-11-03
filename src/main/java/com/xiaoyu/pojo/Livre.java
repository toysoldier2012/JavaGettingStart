package com.xiaoyu.pojo;

import java.util.Objects;

public class Livre {
    private int id;
    private String name;

    public Livre() {
    }

    public Livre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
//        return id == livre.id && Objects.equals(name, livre.name);
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name + id);
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
