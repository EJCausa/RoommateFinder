import com.sun.jdi.connect.Connector;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class testclassErik {
    @Test
    public void updateUsername()
    {
        ProfileHandler obj = new ProfileHandler();

        boolean[] testAnswers = {true, true, true, true, true, true, true, true, true, true};
        ProfileHandler.signUp("Tester1", "Tester1", "Tester1", "Tester1", testAnswers);
        Profile testProfile = ProfileHandler.login("Tester1", "Tester1");
        ProfileHandler.updateUsername(testProfile, "UpdatedTester");
        assertEquals("UpdatedTester", ProfileHandler.getUsername(testProfile));
    }

    @Test
    public void updateEmail()
    {
        ProfileHandler obj = new ProfileHandler();

        boolean[] testAnswers = {true, true, true, true, true, true, true, true, true, true};
        ProfileHandler.signUp("Tester1", "Tester1", "Tester1", "Tester1", testAnswers);
        Profile testProfile = ProfileHandler.login("Tester1", "Tester1");
        ProfileHandler.updateEmail(testProfile, "UpdatedTester");
        assertEquals("UpdatedTester", ProfileHandler.getEmail(testProfile));
    }

    @Test
    public void updatePhone()
    {
        ProfileHandler obj = new ProfileHandler();

        boolean[] testAnswers = {true, true, true, true, true, true, true, true, true, true};
        ProfileHandler.signUp("Tester1", "Tester1", "Tester1", "Tester1", testAnswers);
        Profile testProfile = ProfileHandler.login("Tester1", "Tester1");
        ProfileHandler.updatePhone(testProfile, "UpdatedTester");
        assertEquals("UpdatedTester", ProfileHandler.getPhone(testProfile));
    }

    @Test
    public void retakeQuiz()
    {
        ProfileHandler obj = new ProfileHandler();

        boolean[] testAnswers = {true, true, true, true, true, true, true, true, true, true};
        ProfileHandler.signUp("Tester1", "Tester1", "Tester1", "Tester1", testAnswers);
        Profile testProfile = ProfileHandler.login("Tester1", "Tester1");
        boolean[] updatedAnswers = {false, false, false, false, false, false, false, false, false, false};
        ProfileHandler.retakeQuiz(testProfile, updatedAnswers);
        assertArrayEquals(updatedAnswers, testProfile.getQuizAnswers());
    }
}
