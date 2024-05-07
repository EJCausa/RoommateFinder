import com.sun.jdi.connect.Connector;
import junit.framework.Assert;
import org.junit.Test;

public class testclassNick {
@Test

    public void testEmptyInput(){
     ProfileHandler pfp = new ProfileHandler();

    Assert.assertEquals(null, pfp.login("", ""));
    }
    @Test
    public void testIncorrectPass(){
        ProfileHandler pfp = new ProfileHandler();

        Assert.assertEquals(null, pfp.login("WRONG", "WRONG"));
    }
    @Test
    public void testCorrectPass(){ //this test will only work on the first run thru as 2 accounts with the same username is NOT allowed and will cause the wrong accounts to be accsessed
        //ProfileHandler pfp = new ProfileHandler();
        boolean[] boolArr = new boolean[] {true,true,true,true,true,true,true,true,true,true};
        ProfileHandler.signUp("correct", "random","7085764305","correct",boolArr);
        Profile newpfp = ProfileHandler.login("correct","correct");
        Assert.assertEquals(newpfp, ProfileHandler.login("correct", "correct"));
    }
}
