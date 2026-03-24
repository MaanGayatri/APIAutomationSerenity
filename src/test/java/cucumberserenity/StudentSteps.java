package cucumberserenity;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.studentclass;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.rest.SerenityRest;
import testbase.TestBase;
import utils.ReusableSpecification;

import java.util.ArrayList;
import java.util.List;

public class StudentSteps extends TestBase {

    @Step("Create a student  name:{0},location:{1},phoneNo:{2},courses:{3}")
    public ValidatableResponse createStudent(String name , String location , String phoneNo, List<String> courses)
    {
        studentclass student = new studentclass();
        student.setName(name);
        student.setLocation(location);
        student.setPhone(phoneNo);
      //  ArrayList<String> courses = new ArrayList<String>();
     //   courses.add("Java");
     //   courses.add("Typescript");
        student.setCourses(courses);



        return SerenityRest.given().spec(ReusableSpecification.getGenericRequestSpec()).log().all()
               .when()
                .body(student)
                .post()
                .then();


    }

    @Step("Update student name:{1},location:{2},phoneNo: {3},courses:{4}")
    public ValidatableResponse updateStudent(String studentId,String name ,String location , String phoneNo, List<String> courses)
    {
        System.out.println("Student ID: " + studentId);
        studentclass student = new studentclass();
        student.setName(name);
        student.setLocation(location);
        student.setPhone(phoneNo);
        student.setCourses(courses);
        return  SerenityRest.given().log().all()
                .spec(ReusableSpecification.getGenericRequestSpec())

                .body(student) .when()
                .put("/"+studentId)
                .then().statusCode(200);
    }

@Step("Geting the  Updated name of studentid: {0} ")
    public ValidatableResponse getStudent(String studentId)
{
    return SerenityRest.rest().given()
            .when()
            .get("/"+studentId).then().statusCode(200);

}

}
