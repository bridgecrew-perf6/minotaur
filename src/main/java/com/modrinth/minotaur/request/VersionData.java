package com.modrinth.minotaur.request;

import com.google.gson.annotations.SerializedName;
import com.modrinth.minotaur.dependencies.Dependency;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * Class for the data sent when creating a new version.
 */
@Data
@AllArgsConstructor
public class VersionData {
    /**
     * Base62 ID of the project to add the version to
     */
    @SerializedName("project_id")
    private String projectId;

    /**
     * Number of the version to be created
     */
    @SerializedName("version_number")
    private String versionNumber;

    /**
     * Title of the version to be created
     */
    @SerializedName("version_title")
    private String versionTitle;

    /**
     * Changelog of the version to be created. Supports Markdown formatting.
     */
    private String changelog;

    /**
     * The release channel of the version to be created. Is one of {@link VersionType}.
     */
    @SerializedName("version_type")
    private String versionType;

    /**
     * List of game versions of the version to be created
     */
    @SerializedName("game_versions")
    private Collection<String> gameVersions;

    /**
     * List of loaders of the version to be created
     */
    private Collection<String> loaders;

    /**
     * {@link Dependency} list of the version to be created
     */
    private Collection<Dependency> dependencies;

    /**
     * The files for the version to be created
     */
    @SerializedName("file_parts")
    private List<String> fileParts;

    /**
     * Whether the version to be created will be featured on the sidebar
     */
    private boolean featured;

    @SerializedName("primary_file")
    private String primaryFile;
}
