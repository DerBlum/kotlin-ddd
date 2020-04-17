package test.container

import org.jetbrains.annotations.NotNull
import org.testcontainers.containers.GenericContainer

/** Created by sblum on 17.04.20 */
class MongoDbContainer : GenericContainer<MongoDbContainer> {

    val MONGODB_PORT = 27017

    constructor() : this("mongo:4.2.5")
    constructor(imageName: String) : super(imageName) {
        addExposedPort(MONGODB_PORT)
    }

    @NotNull
    fun getPort(): Int {
        return getMappedPort(MONGODB_PORT)
    }

}
