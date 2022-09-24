package ru.smcsystem.api.dto;

import java.util.Optional;

/**
 * Interface for Source multipart
 *
 * @version 1.0.0
 */
public interface ISourceList {

    /**
     * get count sources
     *
     * @return int count
     */
    int countSource();

    /**
     * get source
     *
     * @param id serial number in the list of sources
     * @return optional ISource
     */
    Optional<ISource> getSource(int id);

}
