/*
 * Name : Madhan Balaji Rao
 * G# : G01374078
 * Email : mbalajir@gmu.edu
 */
//Create (POST) /Retrieve (GET) /Update(PUT) /Delete (DELETE) endpoints on /api/surveys
package com.example.surveybackend.controller;

import com.example.surveybackend.model.Survey;
import com.example.surveybackend.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // Angular CORS
@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @PostMapping
    public Survey submitSurvey(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Update a survey
    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found with id: " + id));

        // update survey fields
        survey.setFirstName(surveyDetails.getFirstName());
        survey.setLastName(surveyDetails.getLastName());
        survey.setAddress(surveyDetails.getAddress());
        survey.setCity(surveyDetails.getCity());
        survey.setState(surveyDetails.getState());
        survey.setZip(surveyDetails.getZip());
        survey.setPhone(surveyDetails.getPhone());
        survey.setEmail(surveyDetails.getEmail());
        survey.setDateOfSurvey(surveyDetails.getDateOfSurvey());
        survey.setMajor(surveyDetails.getMajor());
        survey.setYearOfStudy(surveyDetails.getYearOfStudy());
        survey.setCampusLikes(surveyDetails.getCampusLikes());
        survey.setInterest(surveyDetails.getInterest());
        survey.setRecommendation(surveyDetails.getRecommendation());
        survey.setComments(surveyDetails.getComments());

        final Survey updatedSurvey = surveyRepository.save(survey);
        return ResponseEntity.ok(updatedSurvey);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable(value = "id") Long id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found with id: " + id));
        return ResponseEntity.ok(survey);
    }


    // Delete a survey
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSurvey(@PathVariable(value = "id") Long id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found with id: " + id));

        surveyRepository.delete(survey);
        return ResponseEntity.ok().build();
    }
}
