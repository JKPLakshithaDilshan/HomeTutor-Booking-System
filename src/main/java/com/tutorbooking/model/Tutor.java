package com.tutorbooking.model;

public class Tutor extends User {
    private String phone;
    private String specialization;
    private int experience;
    private double hourlyRate;
    private double rating;

    public Tutor() {
        super();
        this.setRole("TUTOR");
        this.rating = 0.0;
    }

    public Tutor(String id, String name, String email, String password, String phone, String specialization, int experience, double hourlyRate, double rating) {
        super(id, name, email, password, "TUTOR");
        this.phone = phone;
        this.specialization = specialization;
        this.experience = experience;
        this.hourlyRate = hourlyRate;
        this.rating = rating;
    }

    // Compatibility constructor
    public Tutor(String id, String name, String email, String password, String specialization, double hourlyRate) {
        super(id, name, email, password, "TUTOR");
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
        this.rating = 0.0;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return getId() + "|" + getName() + "|" + getEmail() + "|" + getPassword() + "|" + phone + "|" + specialization + "|" + experience + "|" + hourlyRate + "|" + rating;
    }
}
