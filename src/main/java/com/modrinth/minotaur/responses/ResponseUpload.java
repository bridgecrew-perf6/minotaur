package com.modrinth.minotaur.responses;

import com.google.gson.annotations.SerializedName;
import com.modrinth.minotaur.dependencies.Dependency;
import com.modrinth.minotaur.request.VersionType;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * This class defines a POJO that represents the API response for versions that have been successfully uploaded to
 * Modrinth.
 */
@Data
public class ResponseUpload {
    /**
     * The ID of the version, encoded as a base62 string.
     */
    private String id;

    /**
     * The ID of the mod this version is for.
     */
    @SerializedName("project_id")
    private String projectId;

    /**
     * The ID of the author who published this version
     */
    @SerializedName("author_id")
    private String authorId;

    /**
     * Whether the version is featured or not
     */
    private boolean featured;

    /**
     * The name of this version
     */
    private String name;

    /**
     * The version number. Ideally will follow semantic versioning
     */
    @SerializedName("version_number")
    private String versionNumber;

    /**
     * The changelog for this version of the mod.
     */
    private String changelog;

    /**
     * The date that this version was published.
     */
    @SerializedName("date_published")
    private Date datePublished;

    /**
     * The number of downloads this specific version has had.
     */
    private int downloads;

    /**
     * The type of the release - `Alpha`, `Beta`, or `Release`.
     */
    @SerializedName("version_type")
    private VersionType versionType;

    /**
     * A list of files available for download for this version.
     */
    private Collection<VersionFile> files = new ArrayList<>();

    /**
     * A list of versions of Minecraft that this version of the mod supports.
     */
    @SerializedName("game_versions")
    private Collection<String> gameVersions = new ArrayList<>();

    /**
     * The loaders that this version works on
     */
    private Collection<String> loaders = new ArrayList<>();

    /**
     * A list of mods that this version depends on.
     */
    private Collection<Dependency> dependencies = new ArrayList<>();

    /**
     * A single version file.
     */
    @Data
    public static class VersionFile {
        /**
         * A map of hashes of the file. The key is the hashing algorithm and the value is the string version of the
         * hash.
         */
        private Map<String, String> hashes;

        /**
         * A direct link to the file for downloading it.
         */
        private String url;

        /**
         * The name of the file.
         */
        private String filename;

        /**
         * Whether the file is the primary file of the version.
         */
        private boolean primary;

        /**
         * Size, in bytes, of the file.
         */
        private int size;
    }
}
