# MyBatis 
����[�°����ǵĲ���](http://www.cnblogs.com/xdp-gacl/p/4261895.html)ѧϰmybatis�ļ�ʹ�ù���       
## ����jar�� 
* ���ݿ������� mysql-connector-java-5.0.8-bin.jar     
* mybatis-3.4.5.jar        

## ������    
|id     |name        |
|-------|:----------:|
|1      |����                                 |
|2      |����                                 |

## ���Mybatis�������ļ�conf.xml

	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" 	"http://mybatis.org/dtd/mybatis-3-config.dtd">
	<configuration>
	    <environments default="development">
	        <environment id="development">
	            <transactionManager type="JDBC" />
	            <!-- �������ݿ�������Ϣ -->
	            <dataSource type="POOLED">
	                <property name="driver"value="com.mysql.jdbc.Driver"/>
	                <property name="url"value="jdbc:mysql://localhost:3306/mybatis"/>
	                <property name="username" value="root" />
	                <property name="password" value="XDP" />
	            </dataSource>
	        </environment>
	    </environments>
	</configuration>

## ���ݱ��дʵ����
	public class User {
		private int id;
		private String name;
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
	}

## ������sqlӳ���ļ�userMapper.xml

��select��ǩ�б�д��ѯ��SQL��䣬 ����select��ǩ��id����ΪgetUser��id����ֵ������Ψһ�ģ����ܹ��ظ�ʹ��parameterType����ָ����ѯʱʹ�õĲ������ͣ�resultType����ָ����ѯ���صĽ��������resultType="com.qys.entity.User"�ͱ�ʾ����ѯ�����װ��һ��User��Ķ���

	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	<mapper namespace="userMapper">
    	<!-- 
       	 ����id��ѯ�õ�һ��user����
    	 -->
   	 <select id="getUser" parameterType="int" 
    	    resultType="com.qys.entity.User">
    	    select * from users where id=#{id}
 	   </select>
	</mapper>

## ��conf.xml�ļ���ע��userMapper.xml�ļ�

	<mappers>
        <!-- ע��userMapper.xml�ļ��� 
        userMapper.xmlλ��me.gacl.mapping������£�����resourceд��me/gacl/mapping/userMapper.xml-->
        <mapper resource="userMapper.xml"/>
    </mappers>