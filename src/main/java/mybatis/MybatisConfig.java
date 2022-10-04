package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	//필드
	private static SqlSessionFactory sqlSessionFactory;
	
	//MybatisConfig.getInstance()로  SqlSessionFactory 객체
	public static SqlSessionFactory getInstance() {
		//if(sqlSessionFactory==null)
			//new MybatisConfig();//1번만 호출하도록 if문적용
		return sqlSessionFactory;
	}
	
	//생성자의 접근제한을 내부로 한다.private:외부생성불가
	private MybatisConfig() {
	}
	
	static {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
