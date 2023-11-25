/*
 * Name : Madhan Balaji Rao
 * G# : G01374078
 * Email : mbalajir@gmu.edu
 */
//Validation, getters and setters for data from the form
package com.example.surveybackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    private String address;

    @NotBlank
    @Size(min = 2, max = 50)
    private String city;

    @NotBlank
    @Size(min = 2, max = 50)
    private String state;

    @NotBlank
    @Pattern(regexp = "^\\d{5}(-\\d{4})?$")
    private String zip;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfSurvey;

    @NotBlank
    @Size(min = 2, max = 100)
    private String major;

    @NotNull
    @Min(1900)
    private Integer yearOfStudy;

    // Campus likes as a JSON string
    private String campusLikes;

    private String interest;

    @NotBlank
    private String recommendation;

    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getCampusLikes() {
        return campusLikes;
    }

    public void setCampusLikes(String campusLikes) {
        this.campusLikes = campusLikes;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
