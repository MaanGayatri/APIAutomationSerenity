package com.studentapp.junit.studentInfo;

import cucumberserenity.StudentSteps;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.studentclass;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import testbase.TestBase;
import utils.ReusableSpecification;
import utils.testUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SerenityJUnit5Extension.class)
public class StudentsCRUDTest extends TestBase {
    studentclass student = new studentclass();
String name = "Kelly" + testUtils.getRandomValue();
String location = "Italy";
String phoneNo = "8798989909";
String nameadded ;
String studentid ;
    String updatedname;
@Steps
    StudentSteps steps;

    @Test
    @Order(1)
    public void test001() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("Typescript");
        student.setCourses(courses);
       ValidatableResponse postresponse =  steps.createStudent(name, location, phoneNo, courses).statusCode(201)
               .spec(ReusableSpecification.getGenericResponse());

        studentid= postresponse.extract().path("id");
        nameadded = postresponse.extract().path("name");
        System.out.println(nameadded);

        //Serenity.setSessionVariable("studentid").to(studentid);
        System.out.println(studentid);

    }

@Test
@Order(2)
    public void UpdateStudent()
{
    System.out.println("session called "+studentid);
    Assertions.assertNotNull(studentid, "studentid is null!");
    ArrayList<String> courses = new ArrayList<String>();
    courses.add("Java");
    courses.add("Typescript");
    student.setCourses(courses);
    updatedname = name + "updated";
studentclass student = new studentclass();
    student.setName(updatedname);
    ValidatableResponse updated_response  = steps.updateStudent(studentid,updatedname,location,phoneNo,courses).spec(ReusableSpecification.getGenericResponse());
    updated_response.statusCode(200);
this.updatedname = updatedname;


}

@Test
   @Order(3)

    public void getUpdatedstudentName()
{
    ValidatableResponse getresponse  = steps.getStudent(studentid);


    String Actualname = getresponse.extract().path("name");
    System.out.println(Actualname);
    Assertions.assertEquals(updatedname,Actualname);

}


}
