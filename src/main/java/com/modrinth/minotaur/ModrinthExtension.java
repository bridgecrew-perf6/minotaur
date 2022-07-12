package com.modrinth.minotaur;

import com.modrinth.minotaur.dependencies.Dependency;
import com.modrinth.minotaur.dependencies.container.DependencyDSL;
import com.modrinth.minotaur.request.VersionType;
import lombok.Getter;
import org.gradle.api.Project;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Property;

/**
 * Class defining the extension used for configuring {@link TaskModrinthUpload}. This is done via the {@code modrinth
 * {...}} block in the buildscript.
 */
public class ModrinthExtension extends DependencyDSL {
    /**
     * The URL used for communicating with Modrinth.
     *
     * This should not be changed unless you know what you're doing. Its main use case is for debug, development, or
     * advanced user configurations.
     */
    @Getter
    private final Property<String> apiUrl;

    /**
     * The API token used to communicate with Modrinth.
     *
     * Make sure you keep this private!
     */
    @Getter
    private final Property<String> token;

    /**
     * The ID of the project to upload the file to.
     */
    @Getter
    private final Property<String> projectId;

    /**
     * The version number of the project being uploaded. Ideally should follow semantic versioning.
     */
    @Getter
    private final Property<String> versionNumber;

    /**
     * The version name of the project being uploaded. Defaults to the version number.
     */
    @Getter
    private final Property<String> versionName;

    /**
     * The difference between this version and the previously uploaded version.
     */
    @Getter
    private final Property<String> changelog;

    /**
     * The version type for the project.
     *
     * @see VersionType
     */
    @Getter
    private final Property<String> versionType;

    /**
     * The upload artifact file. This can be any object type that is resolvable by {@link Util#resolveFile(Object)}.
     */
    @Getter
    private final Property<Object> uploadFile;

    /**
     * Any additional files to be uploaded to the new version.
     */
    @Getter
    private final ListProperty<Object> additionalFiles;

    /**
     * The game versions that the version supports.
     */
    @Getter
    private final ListProperty<String> gameVersions;

    /**
     * The mod loaders that the version supports.
     */
    @Getter
    private final ListProperty<String> loaders;

    /**
     * The dependencies of the version.
     */
    @Getter
    private final ListProperty<Dependency> dependencies;

    /**
     * Whether the build should continue even if the upload failed.
     */
    @Getter
    private final Property<Boolean> failSilently;

    /**
     * Whether the plugin will try to define loaders based on other plugins in the project environment.
     */
    @Getter
    private final Property<Boolean> detectLoaders;

    /**
     * Whether the plugin is in debug mode. Debug mode does not actually upload any files.
     */
    @Getter
    private final Property<Boolean> debugMode;

    /**
     * The text from which to set the project's body
     */
    @Getter
    private final Property<String> syncBodyFrom;

    /**
     * The default API URL in use for uploading. Exposed as a fallback utility.
     */
    public static final String DEFAULT_API_URL = "https://api.modrinth.com/v2";
    /**
     * The staging API URL if desired for testing.
     */
    public static final String STAGING_API_URL = "https://staging-api.modrinth.com/v2";
    /**
     * The default token in use for uploading. Exposed as a fallback utility.
     */
    public static final String DEFAULT_TOKEN = System.getenv("MODRINTH_TOKEN");
    /**
     * The default changelog if one was not provided. Exposed as a fallback utility.
     */
    public static final String DEFAULT_CHANGELOG = "No changelog was specified.";
    /**
     * The default release type if one was not provided. Exposed as a fallback utility.
     */
    public static final String DEFAULT_VERSION_TYPE = "release";

    /**
     * @param project The Gradle project that the extension is applied to
     */
    public ModrinthExtension(Project project) {
        super(project.getObjects());
        apiUrl = project.getObjects().property(String.class).convention(DEFAULT_API_URL);
        token = project.getObjects().property(String.class).convention(DEFAULT_TOKEN);
        projectId = project.getObjects().property(String.class);
        versionNumber = project.getObjects().property(String.class);
        versionName = project.getObjects().property(String.class);
        changelog = project.getObjects().property(String.class).convention(DEFAULT_CHANGELOG);
        uploadFile = project.getObjects().property(Object.class);
        additionalFiles = project.getObjects().listProperty(Object.class).empty();
        versionType = project.getObjects().property(String.class).convention(DEFAULT_VERSION_TYPE);
        gameVersions = project.getObjects().listProperty(String.class).empty();
        loaders = project.getObjects().listProperty(String.class).empty();
        dependencies = project.getObjects().listProperty(Dependency.class).empty();
        failSilently = project.getObjects().property(Boolean.class).convention(false);
        detectLoaders = project.getObjects().property(Boolean.class).convention(true);
        debugMode = project.getObjects().property(Boolean.class).convention(false);
        syncBodyFrom = project.getObjects().property(String.class);
    }
}
