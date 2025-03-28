import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LoginAppTest {
    private LoginApp loginApp;
    @BeforeEach
    public void setUp() {
        loginApp = new LoginApp();
    }
    @Test
    public void test_case_1() {
        String inputEmail = "johndoe@example.com"; // correct email
        String inputPassword = "password123"; //
        String expectedResult = "John Doe";
        String actualResult = loginApp.authenticateUser(inputEmail, inputPassword );
        assertEquals("John Doe", expectedResult, actualResult);
        System.out.println("Test Case 1 Passed");
    }

    @Test
    public void testFailedLoginUserNotFound() {
        String inputEmail = "notfound@example.com"; // email not in database
        String inputPassword = "password123"; // any password

        // Simulate entering invalid credentials
        loginApp.emailField.setText(inputEmail);
        loginApp.passwordField.setText(inputPassword);

        String actualResult = loginApp.authenticateUser(inputEmail, inputPassword );

        assertNull(actualResult, "Test Case 2 Failed: User should not be found.");
        System.out.println("Test Case 2 Passed");
    }

    @Test
    public void testFailedLoginIncorrectPassword() {
        String inputEmail = "johndoe@example.com"; // correct email
        String inputPassword = "wrongpassword"; // incorrect password

        // Simulate entering credentials
        loginApp.emailField.setText(inputEmail);
        loginApp.passwordField.setText(inputPassword);

        // Assuming your authenticateUser method checks for password validation as well
        String actualResult = loginApp.authenticateUser(inputEmail, inputPassword ); // Adjust if needed to include password

        assertNull(actualResult, "Test Case 3 Failed: User should not be found with incorrect password.");
        System.out.println("Test Case 3 Passed");
    }

    @Test
    public void testEmptyEmailField() {
        String inputPassword = "password123"; // any password

        // Simulate entering an empty email
        loginApp.emailField.setText("");
        loginApp.passwordField.setText(inputPassword);

        String actualResult = loginApp.authenticateUser("",""); // Call with empty email

        assertNull(actualResult, "Test Case 4 Failed: Email field should be empty.");
        System.out.println("Test Case 4 Passed");
    }

    @Test
    public void testEmptyPasswordField() {
        String inputEmail = "johndoe@example.com"; // correct email

        // Simulate entering an empty password
        loginApp.emailField.setText(inputEmail);
        loginApp.passwordField.setText("");

        String actualResult = loginApp.authenticateUser(inputEmail,""); // Call with empty password

        assertNull(actualResult, "Test Case 5 Failed: Password field should be empty.");
        System.out.println("Test Case 5 Passed");
    }

    @AfterEach
    public void tearDown() {
        // Clean up resources if necessary
        loginApp.dispose();
    }
}
