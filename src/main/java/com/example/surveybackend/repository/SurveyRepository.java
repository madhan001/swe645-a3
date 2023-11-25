/*
 * Name : Madhan Balaji Rao
 * G# : G01374078
 * Email : mbalajir@gmu.edu
 */
package com.example.surveybackend.repository;


import com.example.surveybackend.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
