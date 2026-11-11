package com.tianji.liaicodemother.generator;

import cn.hutool.core.lang.Dict;
import cn.hutool.setting.yaml.YamlUtil;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Map;

public class MybatisCodeGenerator {
//    要生成的表名
    public static final String[] TABLE_NAME ={"user"};

    public static void main(String[] args) {
//        从配置文件获取元数据
        Dict dict = YamlUtil.loadByPath("application.yml");
        Map<String,Object> dataSourceConfig = dict.getByPath("spring.datasource");
        String url = String.valueOf(dataSourceConfig.get("url"));
        String username = String.valueOf(dataSourceConfig.get("username"));
        String password = String.valueOf(dataSourceConfig.get("password"));
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfig();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfig() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包,建议生成到临时目录下，再挪到对应包下
        globalConfig.getPackageConfig()
                .setBasePackage("com.tianji.liaicodemother.genresult");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setGenerateTable(TABLE_NAME)
//        要设置逻辑删除字段
                .setLogicDeleteColumn("isDelete");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setJdkVersion(21);

        //设置生成 mapper
        globalConfig.enableMapper();
//        还要生成xml文件
        globalConfig.enableMapperXml();

//        还要生成service
        globalConfig.enableService();
//        还要生成service实现类
        globalConfig.enableServiceImpl();
//        还要生成controller
        globalConfig.enableController();

//        设置生成的注释,比如作者,时间
        globalConfig.getJavadocConfig().setAuthor("li").setSince("");

        return globalConfig;
    }
}
