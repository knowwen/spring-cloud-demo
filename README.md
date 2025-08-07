

# Spring Cloud Demo 项目

这是一个基于 Spring Cloud 的微服务示例项目，包含多个服务模块，适用于学习和演示微服务架构的基本概念和实现方式。

## 项目结构

- **gateway**: 网关服务，用于路由请求到各个微服务。
- **services**: 存放业务服务模块。
  - **service-order**: 订单服务，提供订单相关的功能。
  - **service-product**: 产品服务，提供产品相关的功能。

## 技术栈

- Spring Boot
- Spring Cloud Gateway
- 微服务架构

## 快速启动

### 环境要求

- Java 8 或更高版本
- Maven
- Git

### 启动步骤

1. 克隆仓库：

   ```bash
   git clone https://gitee.com/knowwen/spring-cloud-demo
   cd spring-cloud-demo
   ```

2. 构建项目：

   ```bash
   mvn clean install
   ```

3. 启动各个服务：

   - 启动网关服务：
     ```bash
     java -jar gateway/target/*.jar
     ```

   - 启动订单服务：
     ```bash
     java -jar services/service-order/target/*.jar
     ```

   - 启动产品服务：
     ```bash
     java -jar services/service-product/target/*.jar
     ```

4. 访问服务：
   - 订单服务：访问 `http://localhost:8080/order` 查看订单服务主页。
   - 产品服务：访问 `http://localhost:8080/product` 查看产品服务主页。

## 服务介绍

### 网关服务 (gateway)

网关服务作为整个系统的入口，负责将请求路由到对应的微服务模块。

### 订单服务 (service-order)

订单服务演示了一个简单的 REST 接口，访问根路径 `/` 会返回欢迎信息。

### 产品服务 (service-product)

产品服务同样提供了一个 REST 接口，访问根路径 `/` 会返回欢迎信息。

## 贡献指南

欢迎贡献代码和改进！请按照以下步骤提交 Pull Request：

1. Fork 本仓库。
2. 创建新分支。
3. 提交代码更改。
4. 创建 Pull Request。

## 许可证

本项目采用 MIT 许可证，请查看仓库中的 LICENSE 文件了解详细信息。