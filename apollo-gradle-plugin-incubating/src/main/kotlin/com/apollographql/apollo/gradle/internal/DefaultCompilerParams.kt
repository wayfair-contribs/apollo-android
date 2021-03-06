package com.apollographql.apollo.gradle.internal

import com.apollographql.apollo.gradle.api.CompilerParams
import org.gradle.api.file.ProjectLayout
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import javax.inject.Inject

abstract class DefaultCompilerParams @Inject constructor(objects: ObjectFactory) : CompilerParams {
  override val graphqlSourceDirectorySet = objects.sourceDirectorySet("graphql", "graphql")

  abstract override val schemaFile: RegularFileProperty

  abstract override val generateKotlinModels : Property<Boolean>

  abstract override val generateTransformedQueries : Property<Boolean>

  abstract override val customTypeMapping: MapProperty<String, String>

  init {
    // see https://github.com/gradle/gradle/issues/7485
    customTypeMapping.set(null as Map<String, String>?)
  }

  abstract override val suppressRawTypesWarning : Property<Boolean>

  abstract override val useSemanticNaming : Property<Boolean>

  abstract override val nullableValueType : Property<String>

  abstract override val generateModelBuilder : Property<Boolean>

  abstract override val useJavaBeansSemanticNaming : Property<Boolean>

  abstract override val generateVisitorForPolymorphicDatatypes : Property<Boolean>

  abstract override val rootPackageName : Property<String>

  abstract override val generateAsInternal: Property<Boolean>
}
