# Collection of classes and test classes that demonstrate Mockito features

This projects contains working examples of the main Mockito features. Each feature is demonstrated in a corresponding JUnit test. There are also some simple Java classes defined which are used to be mocked in the tests.  For an overview of all Mockito features, check out the official Javadocs, which greatly describe all features. https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html

Before you start to use Mockito in your project, here are some (critical) thoughts about the framework:

- If you need a lot of Mockito code to write a JUnit test, you better think about refactoring your code first to make it simpler than writing the test. 
- Mockito is great to isolate the code you want to test or replace a layer of your application by mocks. 
- If you need to define complex stubings, you should better use different tools to generate your test data, like in memory DBs.