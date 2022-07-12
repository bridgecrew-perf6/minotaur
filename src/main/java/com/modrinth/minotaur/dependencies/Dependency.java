package com.modrinth.minotaur.dependencies;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

import java.util.Locale;

/**
 * Represents the superclass for {@link ModDependency} and {@link VersionDependency}.
 */
@SuppressWarnings("unused")
public class Dependency {

    /**
     * The {@link DependencyType} of the dependency.
     */
    @Getter
    @SerializedName("dependency_type")
    private final String dependencyType;

    /**
     * Creates a new dependency relationship.
     *
     * @param type The type of dependency being created.
     */
    @ApiStatus.Internal
    Dependency(DependencyType type) {
        this.dependencyType = type.toString().toLowerCase(Locale.ROOT);
    }

    /**
     * Creates a new dependency relationship.
     *
     * @param type The type of dependency being created.
     */
    @ApiStatus.Internal
    Dependency(String type) {
        this.dependencyType = type;
    }
}
