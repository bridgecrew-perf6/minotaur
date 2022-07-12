package com.modrinth.minotaur.responses;

import lombok.Data;

/**
 * The response given in an error from Modrinth.
 */
@Data
public class ResponseError {
    /**
     * The title of the error
     */
    private String error;

    /**
     * The description of the error
     */
    private String description;
}
