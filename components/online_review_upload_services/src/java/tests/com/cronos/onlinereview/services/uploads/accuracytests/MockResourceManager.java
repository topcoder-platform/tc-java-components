/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.cronos.onlinereview.services.uploads.accuracytests;

import com.topcoder.management.resource.Notification;
import com.topcoder.management.resource.NotificationType;
import com.topcoder.management.resource.Resource;
import com.topcoder.management.resource.ResourceManager;
import com.topcoder.management.resource.ResourceRole;
import com.topcoder.management.resource.persistence.ResourcePersistenceException;
import com.topcoder.search.builder.filter.Filter;

/**
 * Mock ResourceManager for testing.
 *
 * @author kshatriyan
 * @version 1.0
 */
public class MockResourceManager implements ResourceManager {

    /**
     * Used for testing.
     */
    private Resource updateResource = null;
    /**
     * Used for testing.
     */
    private String updateResourceUserId = null;

    /**
     * Not used.
     *
     * @param resource
     *            resource
     * @param operator
     *            operator
     */
    public void removeResource(Resource resource, String operator) {
    }

    /**
     * Not used.
     *
     * @param id
     *            id
     * @return always null.
     */
    public Resource getResource(long id) {
        return null;
    }

    /**
     * Mock implementation.
     *
     * @param filter
     *            filter
     * @return an resource array.
     */
    public Resource[] searchResources(Filter filter) {
        Resource[] resources = new Resource[1];
        resources[0] = new Resource();
        resources[0].setId(1);
        return resources;
    }

    /**
     * Not used.
     *
     * @param resourceRole
     *            resource role
     * @param operator
     *            operator
     */
    public void updateResourceRole(ResourceRole resourceRole, String operator) {
    }

    /**
     * Not used.
     *
     * @param resourceRole
     *            resource role
     * @param operator
     *            operator
     */
    public void removeResourceRole(ResourceRole resourceRole, String operator) {
    }

    /**
     * Returns a predefined set of roles.
     *
     * @return resource roles.
     */
    public ResourceRole[] getAllResourceRoles() {
        ResourceRole[] roles = new ResourceRole[5];
        for (int i = 0; i < roles.length; i++) {
            roles[i] = new ResourceRole(i + 1);
        }
        roles[0].setName("Submitter");
        roles[1].setName("Specification Submitter");
        roles[2].setName("Accuracy Reviewer");
        roles[3].setName("Failure Reviewer");
        roles[4].setName("Stress Reviewer");
        return roles;
    }

    /**
     * Not used.
     *
     * @param filter
     *            filter
     * @return always null.
     */
    public ResourceRole[] searchResourceRoles(Filter filter) {
        return null;
    }

    /**
     * Not used.
     *
     * @param users
     *            users
     * @param project
     *            project id
     * @param notificationType
     *            notification type
     * @param operator
     *            operator
     */
    public void addNotifications(long[] users, long project, long notificationType, String operator) {
    }

    /**
     * Not used.
     *
     * @param users
     *            users
     * @param project
     *            project id
     * @param notificationType
     *            notification type
     * @param operator
     *            operator
     */
    public void removeNotifications(long[] users, long project, long notificationType, String operator) {
    }

    /**
     * Not used.
     *
     * @param project
     *            project id
     * @param notificationType
     *            notification type
     * @return always null.
     */
    public long[] getNotifications(long project, long notificationType) {
        return null;
    }

    /**
     * Not used.
     *
     * @param filter
     *            filter
     * @return always null.
     */
    public Notification[] searchNotifications(Filter filter) {
        return null;
    }

    /**
     * Not used.
     *
     * @param notificationType
     *            notification type
     * @param operator
     *            operator
     */
    public void updateNotificationType(NotificationType notificationType, String operator) {
    }

    /**
     * Not used.
     *
     * @param notificationType
     *            notification type
     * @param operator
     *            operator
     */
    public void removeNotificationType(NotificationType notificationType, String operator) {
    }

    /**
     * Not used.
     *
     * @param filter
     *            filter
     * @return always null.
     */
    public NotificationType[] searchNotificationTypes(Filter filter) {
        return null;
    }

    /**
     * Not used.
     *
     * @return always null.
     */
    public NotificationType[] getAllNotificationTypes() {
        return null;
    }

    /**
     * @return the updateResource
     */
    public Resource getUpdateResource() {
        return updateResource;
    }

    /**
     * @return the updateResourceUserId
     */
    public String getUpdateResourceUserId() {
        return updateResourceUserId;
    }

	public void addNotifications(long arg0, long[] arg1, long arg2, String arg3)
			throws ResourcePersistenceException {
	}

	public long[] getNotificationsForUser(long arg0, long arg1)
			throws ResourcePersistenceException {
		return null;
	}

	public void removeNotifications(long arg0, long[] arg1, long arg2,
			String arg3) throws ResourcePersistenceException {
	}

	public Resource[] searchResources(long arg0, long arg1)
			throws ResourcePersistenceException {
		return null;
	}

	public Resource updateResource(Resource arg0, String arg1)
			throws ResourcePersistenceException {
		this.updateResource = arg0;
		this.updateResourceUserId = arg1;
		return null;
	}

	public Resource[] updateResources(Resource[] arg0, long arg1, String arg2)
			throws ResourcePersistenceException {
		return null;
	}
}
