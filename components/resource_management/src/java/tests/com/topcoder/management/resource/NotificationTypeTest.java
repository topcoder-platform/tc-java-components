/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.management.resource;

import junit.framework.TestCase;

/**
 * Unit tests for the class: NotificationType.
 *
 * @author kinfkong
 * @version 1.0
 */
public class NotificationTypeTest extends TestCase {

    /**
     * Tests constructor: NotificationType().
     *
     * Checks if the instance can be created and the fields are properly set.
     */
    public void testNotificationType() {
        NotificationType type = new NotificationType();
        assertNotNull("The instance cannot be created.", type);
        // check the fields
        assertEquals("The id is not set properly.", NotificationType.UNSET_ID, type.getId());
        assertEquals("The name is not set properly.", null, type.getName());
        assertEquals("The description is not set properly.", null, type.getDescription());
    }

    /**
     * Tests constructor: NotificationType(long).
     *
     * Checks if the instance can be created and the fields are properly set.
     */
    public void testNotificationTypeLong() {
        NotificationType type = new NotificationType(123L);
        assertNotNull("The instance cannot be created.", type);
        // check the fields
        assertEquals("The id is not set properly.", 123L, type.getId());
        assertEquals("The name is not set properly.", null, type.getName());
        assertEquals("The description is not set properly.", null, type.getDescription());
    }

    /**
     * Tests constructor: NotificationType(long, String).
     *
     * Checks if the instance can be created and the fields are properly set.
     */
    public void testNotificationTypeLongString() {
        NotificationType type = new NotificationType(123L, "the name");
        assertNotNull("The instance cannot be created.", type);
        // check the fields
        assertEquals("The id is not set properly.", 123L, type.getId());
        assertEquals("The name is not set properly.", "the name", type.getName());
        assertEquals("The description is not set properly.", null, type.getDescription());
    }

    /**
     * Tests NotificationType.setId(long).
     *
     * With a non-positive value, IllegalArgumentException should be thrown.
     */
    public void testSetId_NonPositive() {
        NotificationType type = new NotificationType();
        try {
            type.setId(-1);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests NotificationType.setId(long).
     *
     * Sets the id that already set, IdAlreadySetException should be thrown.
     */
    public void testSetId_ResetId() {
        NotificationType type = new NotificationType(1);
        try {
            type.setId(2);
            fail("IdAlreadySetException should be thrown.");
        } catch (IdAlreadySetException e) {
            // success
        }
    }

    /**
     * Accuracy tests for the method: setId(long).
     */
    public void testSetId() {
        NotificationType type = new NotificationType();
        type.setId(123L);
        assertEquals("The method does not work properly.", 123L, type.getId());
    }

    /**
     * Accuracy tests for the method: getId(long).
     */
    public void testGetId() {
        NotificationType type = new NotificationType();
        type.setId(123L);
        assertEquals("The method does not work properly.", 123L, type.getId());
    }

    /**
     * Tests method setDescription(String).
     *
     * With parameter is null.
     */
    public void testSetDescription_Null() {
        NotificationType type = new NotificationType();
        type.setDescription(null);
        assertEquals("The method does not work properly when the parameter is null.", null, type.getDescription());
    }

    /**
     * Tests method setDescription(String).
     *
     * With parameter is not null.
     */
    public void testSetDescription_NotNull() {
        NotificationType type = new NotificationType();
        type.setDescription("Description");
        assertEquals("The method does not work properly when the parameter is null.",
                "Description", type.getDescription());
    }

    /**
     * Tests method getDescription(String).
     *
     * With parameter is null.
     */
    public void testGetDescription_Null() {
        NotificationType type = new NotificationType();
        type.setDescription(null);
        assertEquals("The method does not work properly when the parameter is null.", null, type.getDescription());
    }

    /**
     * Tests method getDescription(String).
     *
     * With parameter is not null.
     */
    public void testGetDescription_NotNull() {
        NotificationType type = new NotificationType();
        type.setDescription("Description");
        assertEquals("The method does not work properly when the parameter is null.",
                "Description", type.getDescription());
    }


    /**
     * Tests method setName(String).
     *
     * With parameter is null.
     */
    public void testSetName_Null() {
        NotificationType type = new NotificationType();
        type.setName(null);
        assertEquals("The method does not work properly when the parameter is null.", null, type.getName());
    }

    /**
     * Tests method setName(String).
     *
     * With parameter is not null.
     */
    public void testSetName_NotNull() {
        NotificationType type = new NotificationType();
        type.setName("Name");
        assertEquals("The method does not work properly when the parameter is null.", "Name", type.getName());
    }

    /**
     * Tests method getName(String).
     *
     * With parameter is null.
     */
    public void testGetName_Null() {
        NotificationType type = new NotificationType();
        type.setName(null);
        assertEquals("The method does not work properly when the parameter is null.", null, type.getName());
    }

    /**
     * Tests method getName(String).
     *
     * With parameter is not null.
     */
    public void testGetName_NotNull() {
        NotificationType type = new NotificationType();
        type.setName("Name");
        assertEquals("The method does not work properly when the parameter is null.", "Name", type.getName());
    }
}
