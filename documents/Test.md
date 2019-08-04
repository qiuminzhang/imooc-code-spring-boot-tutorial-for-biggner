## Test

#### Where are test files?
/scr -> /test

In scr directory, there are two directories, one is main, the other is test which we store the test files

#### Shortcut to create test class
1. Go to a function you want to test
2. Right click function name 
3. Click Goto
4. Hit Test
5. A new class named classNameTest would be created in the test folder
6. When finish the test case, right click the test function name and you'll find the Run methodNameTest, then the IDE will 
run the test case

#### What if I have multiple test method? Do I have to run them one by one for testing?

No. When packing the project in the terminal, it will automatically run the test methods and return the number of pass cases and number
of fail cases on the terminal.

The command is ```mvn clean package```, but you need to go to the project or something else, pleas find details by keywords like execute spring boot in 
terminal. Or go to 2小时学习spring boot的第一课看看如何用command line 执行程序。


If you want to skip the test when packing the project, run ```mvn clean package -Dmaven.test.skip=true```