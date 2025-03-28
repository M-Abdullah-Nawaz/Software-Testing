import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginAppTest {

    @Test
    void test_case_1() {
        // Arrange
        LoginApp loginApp = new LoginApp();
        String inputEmail = "johndoe@example.com";
        String inputPassword = "password123";
        String expectedResult = "John Doe";

        // Act
        String actualResult = loginApp.authenticateUser(inputEmail, inputPassword);

        // Assert
        assertEquals(expectedResult, actualResult, "Test Case 1 Failed: Valid credentials should return the correct username.");
    }

    @Test
    void test_case_2() {
        // Arrange
        LoginApp loginApp = new LoginApp();
        String inputEmail = "notexist@example.com";
        String inputPassword = "password123";
        String expectedResult = null;

        // Act
        String actualResult = loginApp.authenticateUser(inputEmail, inputPassword);

        // Assert
        assertEquals(expectedResult, actualResult, "Test Case 2 Failed: Non-existent email should return null.");
    }

    @Test
    void test_case_3() {
        // Arrange
        LoginApp loginApp = new LoginApp();
        String inputEmail = "johndoe@example.com";
        String inputPassword = "wrongpassword";
        String expectedResult = null;

        // Act
        String actualResult = loginApp.authenticateUser(inputEmail, inputPassword);

        // Assert
        assertEquals(expectedResult, actualResult, "Test Case 3 Failed: Incorrect password should return null.");
    }

    @Test
    void test_case_4() {
        // Arrange
        LoginApp loginApp = new LoginApp();
        String inputEmail = "johndoe@example.com";
        String inputPassword = "";
        String expectedResult = null;

        // Act
        String actualResult = loginApp.authenticateUser(inputEmail, inputPassword);

        // Assert
        assertEquals(expectedResult, actualResult, "Test Case 4 Failed: Empty password should return null.");
    }

    @Test
    void test_case_5() {
        // Arrange
        LoginApp loginApp = new LoginApp();
        String inputEmail = "";
        String inputPassword = "password123";
        String expectedResult = null;

        // Act
        String actualResult = loginApp.authenticateUser(inputEmail, inputPassword);

        // Assert
        assertEquals(expectedResult, actualResult, "Test Case 5 Failed: Empty email should return null.");
    }
}
