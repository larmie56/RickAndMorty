# RickAndMorty
Android app for viewing Rick and Morty characters and some info about the characters

### Prerequiste 
To build this project, you need;
- Gradle 6.7.1

### Screenshots
<img src="https://user-images.githubusercontent.com/43486366/127545003-a195dab9-1cb8-42e8-b239-7753384be1c6.jpg" width="200" height="400" />
<img src="https://user-images.githubusercontent.com/43486366/127545015-3ed3cd85-518a-4b5b-8538-a73bd6ffc793.jpg" width="200" height="400" />
<img src="https://user-images.githubusercontent.com/43486366/127545012-a60714c8-3542-41e2-bc00-98df9958e890.jpg" width="200" height="400" />

### Description of the problem
Fetch a large dataset of Rick and Morty characters using the [Rick and Morty API](https://rickandmortyapi.com/). Display the list of characters on a screen and details of characters on a second screen.

### Libraries 
[Retrofit](https://square.github.io/retrofit/): Type safe http client and supports coroutines out of the box.
- [Moshi](https://github.com/square/moshi): JSON Parser, used to parse requests on the data layer for entities and understands Kotlin non-nullable and default parameters
- [Okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md): Logs HTTP request and response data.
- [Kotlin Gradle DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html): Gradle’s Kotlin DSL provides an alternative syntax to the traditional Groovy DSL with an enhanced editing experience
- [Navigation component](https://developer.android.com/guide/navigation): Implements navigation
- [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview): Load and display pages of data from a larger dataset
- [Kotlin Flow](https://developer.android.com/kotlin/flow): Emit multiple values sequentially, as opposed to suspend functions that return only a single value
- [Dagger](https://dagger.dev/): Fully static, compile-time dependency injection framework for Java, Kotlin, and Android
- [Truth](https://truth.dev/): Write JVM Unit Test


