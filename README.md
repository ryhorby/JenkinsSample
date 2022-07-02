# JenkinsSample

###### Command for tests

- Add package for logging test result into xml:

```dotnet add package JUnitTestLogger --version 1.1.0```

- Will create xml files with logs into "WebApi.Tests" folder

```dotnet test --logger "junit;LogFilePath=..\WebApi.Tests\results.xml"```
