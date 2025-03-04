plugins {
  id("com.diffplug.spotless")
}

spotless {
  plugins.withId("java") {
    java {
      importOrder("java", "javax", "")
      removeUnusedImports()
      eclipse().configFile(project.rootProject.file("gradle/eclipse-java-formatter.xml"))
    }
  }
  plugins.withId("groovy") {
    format("groovy") {
      target("src/**/*.groovy")
      trimTrailingWhitespace()
      indentWithSpaces(2)
      endWithNewline()
    }
  }
  format("gradle") {
    target("**/*.gradle")
    trimTrailingWhitespace()
    indentWithSpaces(2)
    endWithNewline()
  }
}
