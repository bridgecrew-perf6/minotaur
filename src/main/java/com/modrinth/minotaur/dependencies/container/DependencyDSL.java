package com.modrinth.minotaur.dependencies.container;

import com.modrinth.minotaur.dependencies.Dependency;
import lombok.Getter;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * the Nested Dependencies configuration
 */
public class DependencyDSL {
    private final NamedDomainObjectContainer<NamedDependency> dependencies;
    /**
     * The reference to an {@link NamedDependencyContainer.Incompatible} instance.
     */
    @Getter
    private final NamedDependencyContainer.Incompatible incompatible;
    /**
     * The reference to an {@link NamedDependencyContainer.Optional} instance.
     */
    @Getter
    private final NamedDependencyContainer.Optional optional;
    /**
     * The reference to a {@link NamedDependencyContainer.Required} instance.
     */
    @Getter
    private final NamedDependencyContainer.Required required;
    /**
     * The reference to an {@link NamedDependencyContainer.Embedded} instance.
     */
    @Getter
    private final NamedDependencyContainer.Embedded embedded;

    /**
     * Instantiates a new dependencies configuration.
     *
     * @param objects ObjectFactory
     */
    @Inject
    protected DependencyDSL(final ObjectFactory objects) {
        this.dependencies = objects.domainObjectContainer(NamedDependency.class);
        this.incompatible = objects.newInstance(NamedDependencyContainer.Incompatible.class, dependencies);
        this.optional = objects.newInstance(NamedDependencyContainer.Optional.class, dependencies);
        this.required = objects.newInstance(NamedDependencyContainer.Required.class, dependencies);
        this.embedded = objects.newInstance(NamedDependencyContainer.Embedded.class, dependencies);
    }

    /**
     * Returns the complete NamedDependency container set mapped and collected as a {@literal List<Dependency>}
     *
     * @return {@literal List<Dependency>}
     */
    public List<Dependency> getNamedDependenciesAsList() {
        return this.dependencies.stream().map(NamedDependency::getDependency).collect(Collectors.toList());
    }
}
