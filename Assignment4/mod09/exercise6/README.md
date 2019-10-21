Some thing went wrong: 

1. The command `jar cvf banking.jar banking/domain/*.class banking/reports/*.class` in exercise tutorial doesn't contain the `TestBanking` class.
2. When following every step in the tutorial, an error occurs, "错误: 找不到或无法加载主类 TestBanking"

Here I tried another way: I created the jar file containing the `TestBanking.class` and changed the `MANIFEST.MF`, adding the main class as above. Using the command `java -jar banking.jar`, it runs correctly.

**Solved: The exercise requires you to pack the library into a jar, but not the whole project.**

