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
`<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC" />
            <!-- �������ݿ�������Ϣ -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver" />
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
                <property name="username" value="root" />
                <property name="password" value="XDP" />
            </dataSource>
        </environment>
    </environments>
</configuration>`



