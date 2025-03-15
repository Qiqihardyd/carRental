# 需求
实现一个功能全面、操作简便、安全可靠的汽车租赁系统(毕业设计，不用于实际)。具体目标包括：
实现用户注册、登录、个人信息管理等基本功能，确保用户信息安全与便捷。支持汽车租赁流程全自动化，包括车辆选择、预定、支付、取车、还车等环节。

## 工具链
- 前端： HTML、CSS、JavaScript
- 后端： Java、Spring Boot 2.7.5
- 服务器： Tomcat（嵌入式在 Spring Boot 中）
- 数据库： MySQL
- JDK： 1.8
- 构建工具： Maven
- 依赖管理： Maven

## 已实现功能
[x] 用户注册、登录、登出
[x] 管理员登录、登出、添加 / 查询 车辆、租车点信息 
[x] 管理员修改 / 删除 车辆、租车点信息
[x] 用户选择车辆、租车点、换车点、租车起止时间生成订单
[] 支付系统
[] 用户归还车辆
[] 管理员查询订单信息
[] 延迟换车收取额外费用
[] 其他...

## 编译运行
* 运行前准备：
1. 添加 MySql 用户名密码，保证和src/main/resources/application.properties 同步
```
# 启动 mysql
mysql -u root

# 创建用户(修改为自己的名字)
CREATE USER 'dyd'@'localhost' IDENTIFIED BY '123';

# 授权
GRANT ALL PRIVILEGES ON carrental.* TO 'dyd'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

# 创建数据库
CREATE DATABASE carrental;
```

编译运行：
```
mvn clean package
java -jar target/carrental-0.0.1-SNAPSHOT.jar
```

## 功能演示：
1. 注册：访问 localhost:8080/register 
  - 正常注册
  - 注册已有账号错误提示
  - 注册成功后跳转到登录界面

2. 登录：注册成功跳转 或者访问 localhost:8080/login
  - 正常登录成功后跳转到订单界面
  - 密码错误提示
  - 管理员登录跳转到管理界面(用户名admin 密码admin123)

3. 管理员：
  - 添加车辆：正常添加、添加相同车牌报错
  - 添加租车点信息：正常添加、添加相同租车点报错
  - 查询车辆、租车点信息
4. 租车：
  - 登录后跳转到租车界面
  - 选择车辆、租车点、起止时间，生成订单信息并支付，跳转到支付成功界面
  - 选择租车时间大于归还时间报错
  - 租车后该段时间内其他用户无法使用该车