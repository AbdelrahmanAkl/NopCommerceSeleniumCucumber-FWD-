package data;

import com.github.javafaker.Faker;

public class RegisterData {
	Faker fake = new Faker();
	   public String firstName = fake.name().firstName();
	   public String lastName = fake.name().lastName();
	   public String birthDay = "4";
	   public String birthMonth = "February";
	   public String birthYear = "1983";
	   public String email = fake.internet().emailAddress();
	   public String companyName = fake.company().name();
	   public String password = "123456789";
	   public String  RegEmail = "testwebsite3415@gmail.com";
}
