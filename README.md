# Yet Another AIT Rewrite
#### (proposal)
 
1. Ditching gson: should improve the ability to create backwards compatible 
data structures
2. Decoupling data and logic: should allow to improve serialization code, 
as well as performance and open-ness of the API
3. Allow sparse components: it should be possible to apply only some components,
instead of all of them at the same time with no option to turn them off
4. Make the logic like ECS systems (smth like singletons)
5. Built-in events for system (logic/handlers) interaction: while the fabric
event api is awesome (it's simple, easy to use and quite performant), 
it requires to write quite a bit of repeating code, while the integrated event
api is intertwined with the handlers and its just 8-9 LoC of plain methods 
(unlike fabric api, which uses lambdas inside lambdas). The built-in events system
is quite fast btw. About 7ms on my laptop to invoke an empty (dummy) event with 1 
subscriber.
6. Performance. Shit should be fast, at least on par with the prior AIT builds
7. Systems should be able to interact with each other without events too:
in the current release of AIT we use `tardis.handler(SomeHandler.ID)`,
which relies on the fact that the `#handler` method will always return a non-null
value (which contradicts point 3). Since handlers are now singletons (see point 4),
there should be a way to get them, preferably, dynamically using the class instance
(since the handlers no longer have IDs of any kind).
8. events should have the control flow on how to invoke their recipients
9. TARDIS object is now solely for storing the sparse set of data components (see point 2 & 3)
10. ...