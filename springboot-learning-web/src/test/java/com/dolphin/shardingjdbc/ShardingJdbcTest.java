package com.dolphin.shardingjdbc;

/**
 * @author jichuan.wang
 * @since 2018/11/10 16:06
 * <p>
 * </p>
 */
public class ShardingJdbcTest {

   /* @Test
    public void test() throws Exception{
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        BasicDataSource dataSource1 = new BasicDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://127.0.0.1:3307/mydata?useSSL=true&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
        dataSource1.setUsername("root");
        dataSource1.setPassword("wwww");
        dataSourceMap.put("ds0",dataSource1);

        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://127.0.0.1:3307/mydata2?useSSL=true&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
        dataSource2.setUsername("root");
        dataSource2.setPassword("wwww");
        dataSourceMap.put("ds1",dataSource2);

        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        orderTableRuleConfig.setLogicTable("t_order");
        orderTableRuleConfig.setActualDataNodes("ds${0..1}.t_order${0..1}");

        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id","ds${user_id%2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id","t_order${order_id%2}"));

        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        shardingRuleConfiguration.getTableRuleConfigs().add(orderTableRuleConfig);

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap,shardingRuleConfiguration,new ConcurrentHashMap<>(),new Properties());

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_order where user_id=10");

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getInt(2));
        }


    }*/
}
