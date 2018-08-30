/*
 * Copyright (C) 2018 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.servlet.request;

import javax.servlet.ServletRequest;
import java.io.File;

/**
 * <p>
 * This class represents the persistent storage of the uploaded files in the local file system for studio project. This class works by
 * saving the uploaded files into a default or specified directory with format
 * {default_dir}/project_id/{handle}_{user_id}
 * </p>
 *
 * <p>
 * This class should be initialized from a configuration namespace which should be preloaded. In addition to the base
 * class, this class supports extra properties:
 *
 * <ul>
 * <li>
 * default_dir (optional) - the default directory to write uploaded files under. It is required if the directory is not
 * specified in the constructor.
 * </li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Thread Safety: </b> This class is thread-safe by being immutable.
 * </p>
 *
 * @author TCSCODER
 * @version 1.0
 */
public class LocalStudioFileUpload extends FileUpload {
    /**
     * <p>
     * The property key specifying the default directory to write uploaded files under. It is required if the directory
     * is not specified in the constructor.
     * </p>
     */
    public static final String DEFAULT_DIR_PROPERTY = "default_dir";

    /**
     * <p>
     * Represents the directory to write uploaded files under. It cannot be null or empty string.
     * </p>
     */
    private String dir;

    /**
     * <p>
     * Represent the actual uploaded directory
     * </p>
     */
    private String submissionPath;

    /**
     * <p>
     * Creates a new instance of <code>LocalStudioFileUpload</code> class to load configuration from the specified namespace.
     * The namespace should be preloaded.
     * </p>
     *
     * @param namespace the configuration namespace to use.
     *
     * @throws IllegalArgumentException if namespace is null or empty string.
     * @throws ConfigurationException if any configuration error occurs.
     * @throws DisallowedDirectoryException if the directory is not one of the allowed directories.
     */
    public LocalStudioFileUpload(String namespace) throws ConfigurationException {
        super(namespace);
        this.dir = FileUploadHelper.getStringPropertyValue(namespace, DEFAULT_DIR_PROPERTY, true);
        this.submissionPath = dir;
    }

    /**
     * <p>
     * Creates a new instance of <code>LocalFileUpload</code> class to load configuration from the specified namespace.
     * The namespace should be preloaded.
     * </p>
     *
     * @param namespace the configuration namespace to use.
     * @param dir the default_dir to be used.
     *
     * @throws IllegalArgumentException if namespace is null or empty string.
     * @throws ConfigurationException if any configuration error occurs.
     * @throws DisallowedDirectoryException if the directory is not one of the allowed directories.
     */
    public LocalStudioFileUpload(String namespace, String dir) throws ConfigurationException {
        super(namespace);
        this.dir = dir;
        this.submissionPath = dir;
    }

    /**
     * <p>
     * Creates a new instance of <code>LocalFileUpload</code> class to load configuration from the specified namespace.
     * The namespace should be preloaded.
     * </p>
     *
     * @param namespace the configuration namespace to use.
     * @param projectId project id
     * @param userId user id the owner of file
     * @param userHandle user handle of owner of file
     *
     * @throws IllegalArgumentException if namespace is null or empty string.
     * @throws ConfigurationException if any configuration error occurs.
     * @throws DisallowedDirectoryException if the directory is not one of the allowed directories.
     */
    public LocalStudioFileUpload(String namespace, long projectId, long userId, String userHandle) throws ConfigurationException {
        this(namespace);
        StringBuffer buf = new StringBuffer(80);
        buf.append(dir);
        buf.append(System.getProperty("file.separator"));
        buf.append(projectId);
        buf.append(System.getProperty("file.separator"));
        buf.append(userHandle.toLowerCase());
        buf.append("_");
        buf.append(userId);
        buf.append(System.getProperty("file.separator"));
        this.submissionPath = buf.toString();
    }

    @Override
    public FileUploadResult uploadFiles(ServletRequest request, RequestParser parser) throws RequestParsingException, PersistenceException {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Retrieves the uploaded file from the persistence with the specified file id. In this case, retrieve the file
     * from the local file system. The file id should act the name of the saved file.
     * </p>
     *
     * <p>
     * Note that content type information is not stored permanently in the persistence. When retrieving the uploaded
     * file with the file id, the content type will not be available.
     * </p>
     *
     * @param fileId the id of the file to retrieve.
     * @param refresh whether to refresh the cached file copy, ignored here.
     *
     * @return the uploaded file.
     *
     * @throws IllegalArgumentException if fileId is null or empty string.
     * @throws FileDoesNotExistException if the file does not exist in persistence.
     */
    @Override
    public UploadedFile getUploadedFile(String fileId, boolean refresh) throws PersistenceException, FileDoesNotExistException {
        FileUploadHelper.validateString(fileId, "fileId");

        File file = new File(submissionPath, fileId);

        if (!file.exists()) {
            throw new FileDoesNotExistException(fileId);
        }

        return new LocalUploadedFile(file, null);
    }

    @Override
    public FileUploadResult uploadFiles(ServletRequest request) throws RequestParsingException, PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeUploadedFile(String fileId) throws PersistenceException, FileDoesNotExistException {
        throw new UnsupportedOperationException();
    }
}
