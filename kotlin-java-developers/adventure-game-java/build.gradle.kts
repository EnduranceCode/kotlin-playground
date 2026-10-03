plugins {
    java
    application
}

application {
    mainClass.set("com.timbuchalka.Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
