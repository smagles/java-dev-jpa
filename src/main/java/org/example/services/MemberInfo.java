package org.example.services;

public class MemberInfo {
    private int id;
    private String name;
    private String email;
    private String buildingAddress;
    private int flatNumber;
    private float flatSquare;

    public MemberInfo() {

    }

    public MemberInfo(int id, String name, String email, String buildingAddress, int flatNumber, float flatSquare) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.buildingAddress = buildingAddress;
        this.flatNumber = flatNumber;
        this.flatSquare = flatSquare;
    }

    public int getId() {
        return id;
    }

    public MemberInfo setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MemberInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MemberInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public MemberInfo setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
        return this;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public MemberInfo setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
        return this;
    }

    public float getFlatSquare() {
        return flatSquare;
    }

    public MemberInfo setFlatSquare(float flatSquare) {
        this.flatSquare = flatSquare;
        return this;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", buildingAddress='" + buildingAddress + '\'' +
                ", flatNumber=" + flatNumber +
                ", flatSquare=" + flatSquare +
                '}';
    }
}
