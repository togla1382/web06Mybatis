# 마이바티스 JSP 웹 프로젝트에 적용방법
## [Mybatis Docs Page](https://mybatis.org/mybatis-3/getting-started.html)
## 1. mybatis-x.x.x.jar 파일을 다운로드하고  webapp-WEB-INF-lib 폴더에 저장
## 2. mybatis-config.xml 파일 생성 <p>
   **mybatis** package에 생성한경우<br>
  >**1. mybatis/mybatis-config.xml 파일<br>**
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <properties resource="mybatis/dataSource.properties"/>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```
  >**2. mybatis/dataSource.properties 파일<br>**
```
driver=oracle.jdbc.OracleDriver
url=jdbc:oracle:thin:@127.0.0.1:1521:xe
username=nowon
password=1234   
```
   >**3. mybatis/MybatisConfig.java 파일<br>**
```
package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	
	private static SqlSessionFactory sqlSessionFactory;
	//SqlSessionFactory 싱글톤으로 구성하였습니다.
	public static SqlSessionFactory getInstance() {
		if(sqlSessionFactory==null)new MybatisConfig();
		return sqlSessionFactory;
	}
	
	private MybatisConfig() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory =
				  new SqlSessionFactoryBuilder().build(inputStream);
	}

}  
```
> mapper 파일 샘플
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.mybatis.example.BlogMapper">
  <select id="selectBlog" resultType="Blog">
    select * from Blog where id = #{id}
  </select>
</mapper>
```

**SqlSessionFactoryBuilder**<br>
```
This class can be instantiated, used and thrown away. There is no need to keep it around once you've created your SqlSessionFactory. Therefore the best scope for
instances of SqlSessionFactoryBuilder is method scope (i.e. a local method variable). You can reuse the SqlSessionFactoryBuilder to build multiple SqlSessionFactory instances, 
but it's still best not to keep it around to ensure that all of the XML parsing resources are freed up for more important things.
```	
**SqlSessionFactory**<br>
```	
Once created, the SqlSessionFactory should exist for the duration of your application execution. There should be little or no reason to ever dispose of it or recreate
it. It's a best practice to not rebuild the SqlSessionFactory multiple times in an application run. Doing so should be considered a “bad smell”. Therefore the best
scope of SqlSessionFactory is application scope. This can be achieved a number of ways. The simplest is to use a Singleton pattern or Static Singleton pattern.

```
**SqlSession**<br>
```
Each thread should have its own instance of SqlSession. Instances of SqlSession are not to be shared and are not thread safe. Therefore the best scope is request
or method scope. Never keep references to a SqlSession instance in a static field or even an instance field of a class. Never keep references to a SqlSession in any
sort of managed scope, such as HttpSession of the Servlet framework. If you're using a web framework of any sort, consider the SqlSession to follow a similar scope
to that of an HTTP request. In other words, upon receiving an HTTP request, you can open a SqlSession, then upon returning the response, you can close it. <br>Closing the session is very important. You should always ensure that it's closed within a finally block. The following is the standard pattern for ensuring that 
SqlSessions are closed:
```
