package server.util;

public final class Constants {

    private Constants() {
        throw new AssertionError();
    }

    /**
     * UTF-8 encoding identifier.
     */
    public static final String UTF_8_ENCODING = "UTF-8";

    /**
     * Default location of the index.jsp file, relative to the application classpath.
     */
    public static final String INDEX_FILE_LOCATION = "../../index.jsp";

    // File upload

    /**
     * Temporary location where uploaded files will be stored
     */
    public static final String UPLOADED_FILE_LOCATION = "/tmp/";

    /**
     * Max uploaded file size. Currently 10MB.
     */
    public static final long MAX_UPLOADED_FILE_SIZE = 10 * 1024 * 1024;

    /**
     * Total request size containing Multi part. 20MB.
     */
    public static final long MAX_UPLOAD_REQUEST_SIZE = 20 * 1024 * 1024;

    /**
     * Size threshold after which files will be written to disk.
     */
    public static final int UPLOADED_FILE_SIZE_THRESHOLD = 0;

    // Query files

    /**
     * Folder containing query files for the application
     */
    public static final String QUERY_FILES_DIRECTORY = "query";

    /**
     * Folder containing options files for the application.
     *
     * Some options can be stored directly in the application.
     */
    public static final String OPTION_FILES_DIRECTORY = "option";
}
