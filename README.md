# sping-function

本项目实现主jar包启动，副jar包注册function,方便动态改变function功能

lib包中存放Function<T,R>接口实现类以注册function供调用, 配置文件中配置spring.cloud.function.scan.packages 扫描function包

通过外部 -Dloader.path=lib 指令动态注册lib包中的function到环境中

注意：
1.pom文件打包springboot启动类必须是PropertiedLauncher否则不支持外部注入classpath
2.lib包中的结构满足spring.cloud.function.scan.packages 声明的包名即可注册到主包中
