# Dbcp
Using Dbcp[DB connection pool]


使用Tomcat实现的DBCP,数据库连接池

1、在META-INF下创建context.xml，记录要连接的数据库的各类信息。本例已写好。
2、写一个监听器AppListener，在初始化容器时，读取context.xml，启动数据库连接池。