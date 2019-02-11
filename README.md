# Modern Android Development Kata Roadmap

- [X] Introduce Navigation Architecture Component and orchestrate the in-app navigation by using it
- [ ]  Introduce Kotlin Coroutine Channels and expose the API response via LiveData
- [ ]  Introduce Paging library and use it for pagination
- [ ]  Introduce MotionLayout and apply some nice animations on DetailPage
- [ ]  Use Room DB for the FavouriteScreen and persist the data
- [ ]  Write unit tests for the existing classes
- [ ]  Write espresso tests for the existing classes
- [ ]  Introduce the latest UI elements from Android Material Design library and do some cosmetic on existing screens
- [ ]  Apply some meaningful animations and share the best practice knowledge
- [ ]  Try to find the best practices for tracking
- [ ]  Use Firebase for Machine Learning
- [ ]  Try to extract business logic to Kotlin Native classes


### Navigation Architecture Component

#### Multi-backstack
Each tab has a separate NavHost with own backstack.

#### Multi-module
- Each gradle feature module holds its nav subgraph that is included into the main navgraph located the `app` module
- Feature modules send navigation commands via an interface
- The `app` module implements this interface, maps navigation commands to global actions in the nav graph and executes them using `NavController`
- Module's fragments are `internal` and not exposed
- Feature modules do not depend on each other, only on the `core` module
- Module's fragments can use generated SafeArgs, because they own their nav subgraphs
