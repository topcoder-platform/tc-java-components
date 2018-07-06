/**
 *
 * Copyright (c) %{current_year}, TopCoder, Inc. All rights reserved
 */
package %{package.name}.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author TopCoder
 * @version %{version.major}.%{version.minor}
 */
public class StressTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        //suite.addTest(XXX.suite());
        return suite;
    }
}
