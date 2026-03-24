package com.studentapp.junit.studentInfo;


import cucumberserenity.StudentSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import testbase.TestBase;

import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
public class CreateStudentDataDriventest extends TestBase {


    @Steps

    StudentSteps steps;

    @ParameterizedTest()
    @CsvFileSource(resources = "/testdata/studentInfo.csv", numLinesToSkip = 1)
    public void createStudentfromcsv(String name, String location, String phone, String coursesStr) {

        List<String> courses = List.of(coursesStr.split("\\|"));
        steps.createStudent(name,location,phone,courses).statusCode(201);
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}