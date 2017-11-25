
import com.flexionmobile.codingchallenge.integration.IntegrationTestRunner;

public class Solution {
    public static void main(String[] args){
        IntegrationTestRunner testRunner = new IntegrationTestRunner();
        testRunner.runTests(new IntegrationImpl("Tudor"));
    }
}
