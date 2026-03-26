package com.studentapp.junit.studentInfo;


import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testbase.TestBase;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class TagsTest extends TestBase {

@Tag("NEGATIVE")
@Test
    public void inValidMethod()

{
    SerenityRest.rest().given().when().post().then().statusCode(201).log().all();
}
@Tag("POSITIVE")
@Test
    public void VerifyStatuscodeIs200()
{
    System.out.println("Running POSITIVE test only");
    SerenityRest.rest().given().when().get() .then().statusCode(201);
}

@Tag("NEGATIVE")
@Tag("SMOKE")
@Test

    public void IncorrectResource()
{
    SerenityRest.rest().given().when().get("/898").then().statusCode(400).log().all();
}



}
