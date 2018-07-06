/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.search.builder.filter;

import com.topcoder.search.builder.ValidationResult;

import com.topcoder.util.datavalidator.IntegerValidator;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * Unit test cases for NullFilter.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.3
 */
public class NullFilterTests extends TestCase {

    /**
     * the map validators to check valid.
     */
    private Map validators = null;

    /**
     * the map alias to check valid.
     */
    private Map alias = null;

    /**
     * The instance of BetweenFilter for test.
     */
    private NullFilter nullFilter = null;

    /**
     * setUp.
     */
    protected void setUp() {
        //the value list in the inFliter
        nullFilter = new NullFilter("The age");
        validators = new HashMap();
        validators.put("age", IntegerValidator.inRange(0, 100));
        alias = new HashMap();
        alias.put("The age", "age");
    }

    /**
     * test the construct of BetweenFilter.
     *
     */
    public void testconstruct1() {
        assertNotNull("can not construct the instance of EqualToFilter",
                nullFilter);
    }

    /**
     * test fail for construct EqualToFilter with name is null.
     *
     */
    public void testconstruct2() {
        try {
            nullFilter = new NullFilter(null);
            fail("IllegalArgumentException should be throw");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * test fail for construct NullFilter with name is empty.
     *
     */
    public void testconstruct4() {
        try {
            nullFilter = new NullFilter("");
            fail("IllegalArgumentException should be throw");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * test fail for check valid with validators null.
     *
     */
    public void testisValid1() {
        try {
            nullFilter.isValid(null, alias);
            fail("IllegalArgumentException should be throw");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
         * test fail for check valid with alias null.
         *
         */
    public void testisValid2() {
        try {
            nullFilter.isValid(validators, null);
            fail("IllegalArgumentException should be throw");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * the valid check for the given validators and alias.
     *
     */
    public void testisValid3() {
        ValidationResult result = nullFilter.isValid(validators, alias);

        assertFalse("The check should be pass", result.isValid());
    }

    /**
     * the invalid check for the given validators and alias.
     *
     */
    public void testisValid4() {
        try {
            ValidationResult result = nullFilter.isValid(new HashMap(), alias);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            //success
        }

        // assertFalse("The check should not be pass", result.isValid());
    }

    /**
     * test the mothed clone.
     *
     */
    public void testclone() {
        NullFilter cl = null;

        try {
            cl = (NullFilter) nullFilter.clone();
        } catch (Exception e) {
            fail("no Exception should throw");
        }

        //value should be same
        assertTrue("The filter List  size should be the same with the clone",
            cl.value == nullFilter.value);

        //name should be same
        assertEquals("The filter List  size should be the same with the clone",
            cl.getName(), nullFilter.getName());
    }
}
