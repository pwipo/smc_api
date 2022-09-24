package ru.smcsystem.api.tools;

import java.io.InputStream;

/**
 * tool for work with unmodifiable files
 *
 * @version 1.0.0
 */
public interface FileTool {

    /**
     * get name
     *
     * @return name
     */
    String getName();

    /**
     * is file exist
     *
     * @return true if exist
     */
    boolean exists();

    /**
     * is directory
     *
     * @return true if directory
     */
    boolean isDirectory();

    /**
     * get files in folder
     *
     * @return files if it folder
     */
    FileTool[] getChildrens();

    /**
     * reed all file
     *
     * @return InputStream
     */
    InputStream getInputStream();

    /**
     * file size
     *
     * @return size
     */
    long length();

}
