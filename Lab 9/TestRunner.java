import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.linkedlist.DoublyLinkedListTest;
import com.linkedlist.DoublyLinkedList;

// To compile: javac -cp ".:./JUnit/*" TestRunner.java
// To run tests: java -cp ".:./JUnit/*" TestRunner

public class TestRunner
{

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DoublyLinkedListTest.class);
        System.out.println();
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            if(!(failure.getException() instanceof AssertionError))
            {
                System.out.println("\tException Thrown: " + failure.getException());
            }
            // Uncomment the next line if you need more information on on the failures.
            System.out.println(failure.getTrace());

        }
    }
}
