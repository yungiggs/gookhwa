package sqlmap;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapConfig {
	
	private static final SqlMapClient sqlMap;
	
	 static{
		  try {
			  String resource ="./sqlmap/SqlMapConfig.xml";
			  Reader reader = Resources.getResourceAsReader(resource); 
			  sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		  
		   } catch (IOException e) {
		    
			   e.printStackTrace();
			   throw new RuntimeException("초기화 에러: "+ e);
		 
		   }
	}	
	 
	 public static SqlMapClient getSqlMapInstance(){
		 
		    return sqlMap;
	}	 
}
