package org.example;

import java.util.*;

public class Pharmacy {
    Map<String, Object> medicines = new HashMap<>();

    public int getCount() {
        return this.medicines.size();
    }

    public void save(Medication medication) {
        this.medicines.put(medication.getName(), medication);
    }

    public Medication find(String name) {
        return this.medicines.containsKey(name) ? (Medication) this.medicines.get(name) : null;
    }

    public void delete(String name) {
        this.medicines.remove(name);
    }

    public void showAll() {
        System.out.println(this.medicines.entrySet());
    }
}
