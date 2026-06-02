# 多模块项目结构说明

## 模块划分

- **springboot3-jdk17-common**: 公共配置和工具类模块
    - Redis配置
    - Web配置
    - MyBatis配置
    - 拦截器等

- **springboot3-jdk17-domain**: 领域模型模块
    - 实体类(DO)
    - DTO、VO等数据对象

- **springboot3-jdk17-dao**: 数据访问层模块
    - Mapper接口
    - MyBatis XML映射文件

- **springboot3-jdk17-service**: 业务逻辑层模块
    - Service接口及实现

- **springboot3-jdk17-rpc**: RPC服务层模块
    - Dubbo服务接口及实现

- **springboot3-jdk17-api**: API接口层模块（启动模块）
    - REST控制器
    - 应用启动类
    - 配置文件

## 模块依赖关系

