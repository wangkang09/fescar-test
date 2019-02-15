### 什么是fescar
- fast & easy commit and rollback（快速简单的提交和回退）
- 分布式强一致性事务中间件

### 解决的问题
- 分布式事务一致性问题

### 优点
- 传统的2PC实现强一致性事务，是在第二阶段才正式提交事务的。即，资源（数据库连接等）是在第二阶段才释放。
- fescar 在第一阶段就提交了事务，这样提高了资源利用率。但其他服务事务失败时，通过undo_log来将提交的事务回退到之前状态
- 关键：fescar对数据库加了两把锁，本地锁、全局锁。在第一阶段commit时，释放本地锁。关键在于全局锁还没释放。所以，别的事务仍然不能修改此事务已提交的数据库资源
- 这样，就可以很方便快速的通过undo_log来进行资源的回退！

### 目前的局限
- fescar-server仍是单点的
- 目前不支持对非事务类型资源做 无业务入侵式 的强一致性事务（通过TM做业务入侵式事务）（未来会用TX代替TM做到完全无业务入侵式的一致性事务）

### fescar 集成
- 首先集成dubbo中间件，实现RPC功能
- 在dubbo的基础上，集成fescar（分布式强一致性事务）中间件

### 集成dubbo中间件配置
- 添加依赖
- 添加dubbo.xml，配置dubbo属性，再将.xml注入spring（DubboConfig）
- 也可以使用Spring注解，配置dubbo属性
- [启动zookeeper（作为dubbo注册中心）](启动zookeeper.md)

### 集成fescar中间件配置
- 添加依赖
- 添加application.conf——fescar客户端配置
- 注入 GlobalTransactionScanner 类（FescarConfig）
- 在每个微服务对应的数据库中，添加一个undo_log表。当此服务提交了事务，但是其他服务发生异常，使用此undo_log进行此服务的事务回退！
- [启动 fescar-server（作为fescar服务端）](启动fescar-server.md)


### 项目说明
- api-service：提供接口
- account-service：账户服务，扣款
- order-service：订单服务，调用账户服务，并生成订单
- storage-service：库存服务，扣减库存
- business-service：客户购买商品，调用库存和订单服务

*步骤* 
1. 客户端调用 business-service 的 purchase 接口，购买商品 
2. 扣减库存 
3. 扣减账户余额
4. 生成订单

#### 测试1
- 在 purchase 接口 使用 @GlobalTransaction 和 @Transaction 注解
- 在扣款服务抛错（步骤3）
- 客户端返回错误，库存服务成功回退
- 最终状态一致

#### 测试2
- 在测试1的基础上，去掉 @Transaction注解
- 结果一样

#### 测试3 
- 在测试2的基础上，在步骤1中的purchase方法中，增加一个数据库事务