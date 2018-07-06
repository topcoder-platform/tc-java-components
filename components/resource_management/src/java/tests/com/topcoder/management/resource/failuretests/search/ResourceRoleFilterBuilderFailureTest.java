/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.management.resource.failuretests.search;

import com.topcoder.management.resource.search.ResourceRoleFilterBuilder;

import junit.framework.TestCase;

/**
 * Failure tests for <code>ResourceRoleFilterBuilder</code>.
 *
 * @author mayi
 * @version 1.1
 * @since 1.0
 */
public class ResourceRoleFilterBuilderFailureTest extends TestCase {

    /**
     * Test <code>createNotificationTypeIdFilter(long)</code> with zero id.
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testCreateNotificationTypeIdFilter_ZeroId() {
        try {
            ResourceRoleFilterBuilder.createResourceRoleIdFilter(0);
            fail("Should throw IllegalArgumentException for zero id.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test <code>createNotificationTypeIdFilter(long)</code> with negative id.
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testCreateNotificationTypeIdFilter_NegativeId() {
        try {
            ResourceRoleFilterBuilder.createResourceRoleIdFilter(-2L);
            fail("Should throw IllegalArgumentException for negative id.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test <code>createNameFilter(String)</code> with null name.
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testCreateNameFilter_NullName() {
        try {
            ResourceRoleFilterBuilder.createNameFilter(null);
            fail("Should throw IllegalArgumentException for null name.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test <code>createPhaseTypeIdFilter(long)</code> with zero id.
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testCreatePhaseTypeIdFilter_ZeroId() {
        try {
            ResourceRoleFilterBuilder.createPhaseTypeIdFilter(0);
            fail("Should throw IllegalArgumentException for zero id.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test <code>createPhaseTypeIdFilter(long)</code> with negative id.
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testCreatePhaseTypeIdFilter_NegativeId() {
        try {
            ResourceRoleFilterBuilder.createPhaseTypeIdFilter(-2L);
            fail("Should throw IllegalArgumentException for negative id.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }
}
