# MyBatis 
根据[孤傲苍狼的博客](http://www.cnblogs.com/xdp-gacl/p/4261895.html)学习mybatis的简单使用过程       
## 导入jar包 
* 数据库驱动包 mysql-connector-java-5.0.8-bin.jar     
* mybatis-3.4.5.jar        

## 创建表    
|id     |name        |
|-------|:----------:|
|1      |刘飞                                 |
|2      |刘国                                 |

## 添加Mybatis的配置文件conf.xml

	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" 	"http://mybatis.org/dtd/mybatis-3-config.dtd">
	<configuration>
	    <environments default="development">
	        <environment id="development">
	            <transactionManager type="JDBC" />
	            <!-- 配置数据库连接信息 -->
	            <dataSource type="POOLED">
	                <property name="driver"value="com.mysql.jdbc.Driver"/>
	                <property name="url"value="jdbc:mysql://localhost:3306/mybatis"/>
	                <property name="username" value="root" />
	                <property name="password" value="XDP" />
	            </dataSource>
	        </environment>
	    </environments>
	</configuration>

## 根据表编写实体类
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

## 定义表格sql映射文件userMapper.xml

在select标签中编写查询的SQL语句， 设置select标签的id属性为getUser，id属性值必须是唯一的，不能够重复使用parameterType属性指明查询时使用的参数类型，resultType属性指明查询返回的结果集类型resultType="com.qys.entity.User"就表示将查询结果封装成一个User类的对象

	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	<mapper namespace="userMapper">
    	<!-- 
       	 根据id查询得到一个user对象
    	 -->
   	 <select id="getUser" parameterType="int" 
    	    resultType="com.qys.entity.User">
    	    select * from users where id=#{id}
 	   </select>
	</mapper>

## 在conf.xml文件中注册userMapper.xml文件

	<mappers>
        <!-- 注册userMapper.xml文件， 
        userMapper.xml位于me.gacl.mapping这个包下，所以resource写成me/gacl/mapping/userMapper.xml-->
        <mapper resource="userMapper.xml"/>
    </mappers>