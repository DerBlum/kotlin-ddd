package com.ddd.library.architecture

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.onionArchitecture
import com.tngtech.archunit.library.GeneralCodingRules.*

/** Created by sblum on 06.04.20 */
@AnalyzeClasses(packages = ["com.ddd.library.."], importOptions = [DoNotIncludeTests::class])
class ArchitectureTest {

    @ArchTest
    val onionArchitectureTest = onionArchitecture()
            .domainModels("..domain.model..")
            .domainServices("..domain.service..")
            .applicationServices("..application..")
            .adapter("rest", "..interfaces.rest..")
            .adapter("mongo", "..adapter.db.mongo..")

    @ArchTest
    val forbidJavaUtilLogging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING

    @ArchTest
    val forbidJodaTime = NO_CLASSES_SHOULD_USE_JODATIME

    @ArchTest
    val forbidGenericExceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS

}
