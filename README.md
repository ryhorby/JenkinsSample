# JenkinsSample

###### Command for tests

// Add packege for logging test result into xml
dotnet add package JUnitTestLogger --version 1.1.0

//Wil be located into sln folder
dotnet test --logger "junit;LogFilePath=..\WebApi.Tests\results.xml"