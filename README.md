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
`<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC" />
            <!-- 配置数据库连接信息 -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver" />
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
                <property name="username" value="root" />
                <property name="password" value="XDP" />
            </dataSource>
        </environment>
    </environments>
</configuration>`



