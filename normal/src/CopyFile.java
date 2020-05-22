import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Pario
 * @description
 * @date 2020/5/19 18:19
 */
public class CopyFile {
    static void copy(String srcPathStr, String desPathStr) {
        //获取源文件的名称
        String newFileName = srcPathStr.substring(srcPathStr.lastIndexOf("\\") + 1); //目标文件地址
        System.out.println("源文件:" + newFileName);
        desPathStr = desPathStr + File.separator + newFileName; //目标文件地址
        System.out.println("目标文件地址:" + desPathStr);
        try {
            FileInputStream fis = new FileInputStream(srcPathStr);//创建输入流对象
            FileOutputStream fos = new FileOutputStream(desPathStr); //创建输出流对象
            byte datas[] = new byte[1024 * 8];//创建搬运工具
            int len = 0;//创建长度
            while ((len = fis.read(datas)) != -1)//循环读取数据
            {
                fos.write(datas, 0, len);
            }
            fis.close();//释放资源
            fis.close();//释放资源
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String srcPathStr = "D:\\idea-workspace\\notice\\notice-service\\target\\classes;D:\\idea-workspace\\notice\\notice-api\\target\\classes;D:\\mvnrepo\\com\\fqfin\\risk\\risk-ares-logback-kafka\\1.0.0-SNAPSHOT\\risk-ares-logback-kafka-1.0.0-20190812.073824-24.jar;D:\\mvnrepo\\ch\\qos\\logback\\logback-classic\\1.2.3\\logback-classic-1.2.3.jar;D:\\mvnrepo\\ch\\qos\\logback\\logback-core\\1.2.3\\logback-core-1.2.3.jar;D:\\mvnrepo\\org\\apache\\kafka\\kafka-clients\\2.0.1\\kafka-clients-2.0.1.jar;D:\\mvnrepo\\org\\lz4\\lz4-java\\1.4.1\\lz4-java-1.4.1.jar;D:\\mvnrepo\\org\\xerial\\snappy\\snappy-java\\1.1.7.1\\snappy-java-1.1.7.1.jar;D:\\mvnrepo\\com\\fqfin\\risk\\risk-ares-common\\1.0.0-SNAPSHOT\\risk-ares-common-1.0.0-20190909.063307-32.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot-starter-mail\\2.1.4.RELEASE\\spring-boot-starter-mail-2.1.4.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot-starter\\2.1.4.RELEASE\\spring-boot-starter-2.1.4.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot\\2.1.4.RELEASE\\spring-boot-2.1.4.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot-starter-logging\\2.1.4.RELEASE\\spring-boot-starter-logging-2.1.4.RELEASE.jar;D:\\mvnrepo\\org\\apache\\logging\\log4j\\log4j-to-slf4j\\2.11.2\\log4j-to-slf4j-2.11.2.jar;D:\\mvnrepo\\org\\apache\\logging\\log4j\\log4j-api\\2.11.2\\log4j-api-2.11.2.jar;D:\\mvnrepo\\org\\slf4j\\jul-to-slf4j\\1.7.26\\jul-to-slf4j-1.7.26.jar;D:\\mvnrepo\\javax\\annotation\\javax.annotation-api\\1.3.2\\javax.annotation-api-1.3.2.jar;D:\\mvnrepo\\org\\springframework\\spring-context-support\\5.1.6.RELEASE\\spring-context-support-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\spring-beans\\5.1.6.RELEASE\\spring-beans-5.1.6.RELEASE.jar;D:\\mvnrepo\\com\\sun\\mail\\javax.mail\\1.6.2\\javax.mail-1.6.2.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot-starter-web\\2.1.4.RELEASE\\spring-boot-starter-web-2.1.4.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot-starter-json\\2.1.4.RELEASE\\spring-boot-starter-json-2.1.4.RELEASE.jar;D:\\mvnrepo\\com\\fasterxml\\jackson\\core\\jackson-databind\\2.9.8\\jackson-databind-2.9.8.jar;D:\\mvnrepo\\com\\fasterxml\\jackson\\core\\jackson-annotations\\2.9.0\\jackson-annotations-2.9.0.jar;D:\\mvnrepo\\com\\fasterxml\\jackson\\core\\jackson-core\\2.9.8\\jackson-core-2.9.8.jar;D:\\mvnrepo\\com\\fasterxml\\jackson\\datatype\\jackson-datatype-jdk8\\2.9.8\\jackson-datatype-jdk8-2.9.8.jar;D:\\mvnrepo\\com\\fasterxml\\jackson\\datatype\\jackson-datatype-jsr310\\2.9.8\\jackson-datatype-jsr310-2.9.8.jar;D:\\mvnrepo\\com\\fasterxml\\jackson\\module\\jackson-module-parameter-names\\2.9.8\\jackson-module-parameter-names-2.9.8.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot-starter-tomcat\\2.1.4.RELEASE\\spring-boot-starter-tomcat-2.1.4.RELEASE.jar;D:\\mvnrepo\\org\\apache\\tomcat\\embed\\tomcat-embed-core\\9.0.17\\tomcat-embed-core-9.0.17.jar;D:\\mvnrepo\\org\\apache\\tomcat\\embed\\tomcat-embed-el\\9.0.17\\tomcat-embed-el-9.0.17.jar;D:\\mvnrepo\\org\\apache\\tomcat\\embed\\tomcat-embed-websocket\\9.0.17\\tomcat-embed-websocket-9.0.17.jar;D:\\mvnrepo\\org\\hibernate\\validator\\hibernate-validator\\6.0.16.Final\\hibernate-validator-6.0.16.Final.jar;D:\\mvnrepo\\javax\\validation\\validation-api\\2.0.1.Final\\validation-api-2.0.1.Final.jar;D:\\mvnrepo\\org\\jboss\\logging\\jboss-logging\\3.3.2.Final\\jboss-logging-3.3.2.Final.jar;D:\\mvnrepo\\com\\fasterxml\\classmate\\1.4.0\\classmate-1.4.0.jar;D:\\mvnrepo\\org\\springframework\\spring-web\\5.1.6.RELEASE\\spring-web-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\spring-webmvc\\5.1.6.RELEASE\\spring-webmvc-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\spring-aop\\5.1.6.RELEASE\\spring-aop-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\spring-expression\\5.1.6.RELEASE\\spring-expression-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot-starter-jdbc\\2.1.4.RELEASE\\spring-boot-starter-jdbc-2.1.4.RELEASE.jar;D:\\mvnrepo\\com\\zaxxer\\HikariCP\\3.2.0\\HikariCP-3.2.0.jar;D:\\mvnrepo\\org\\springframework\\spring-jdbc\\5.1.6.RELEASE\\spring-jdbc-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\spring-tx\\5.1.6.RELEASE\\spring-tx-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\mybatis\\spring\\boot\\mybatis-spring-boot-starter\\2.0.0\\mybatis-spring-boot-starter-2.0.0.jar;D:\\mvnrepo\\org\\mybatis\\spring\\boot\\mybatis-spring-boot-autoconfigure\\2.0.0\\mybatis-spring-boot-autoconfigure-2.0.0.jar;D:\\mvnrepo\\org\\mybatis\\mybatis\\3.5.0\\mybatis-3.5.0.jar;D:\\mvnrepo\\org\\mybatis\\mybatis-spring\\2.0.0\\mybatis-spring-2.0.0.jar;D:\\mvnrepo\\tk\\mybatis\\mapper-spring-boot-starter\\2.1.5\\mapper-spring-boot-starter-2.1.5.jar;D:\\mvnrepo\\tk\\mybatis\\mapper-core\\1.1.5\\mapper-core-1.1.5.jar;D:\\mvnrepo\\javax\\persistence\\persistence-api\\1.0\\persistence-api-1.0.jar;D:\\mvnrepo\\tk\\mybatis\\mapper-base\\1.1.5\\mapper-base-1.1.5.jar;D:\\mvnrepo\\tk\\mybatis\\mapper-weekend\\1.1.5\\mapper-weekend-1.1.5.jar;D:\\mvnrepo\\tk\\mybatis\\mapper-spring\\1.1.5\\mapper-spring-1.1.5.jar;D:\\mvnrepo\\tk\\mybatis\\mapper-extra\\1.1.5\\mapper-extra-1.1.5.jar;D:\\mvnrepo\\tk\\mybatis\\mapper-spring-boot-autoconfigure\\2.1.5\\mapper-spring-boot-autoconfigure-2.1.5.jar;D:\\mvnrepo\\com\\alibaba\\druid-spring-boot-starter\\1.1.10\\druid-spring-boot-starter-1.1.10.jar;D:\\mvnrepo\\com\\alibaba\\druid\\1.1.10\\druid-1.1.10.jar;D:\\mvnrepo\\org\\slf4j\\slf4j-api\\1.7.26\\slf4j-api-1.7.26.jar;D:\\mvnrepo\\org\\springframework\\boot\\spring-boot-autoconfigure\\2.1.4.RELEASE\\spring-boot-autoconfigure-2.1.4.RELEASE.jar;D:\\mvnrepo\\mysql\\mysql-connector-java\\8.0.15\\mysql-connector-java-8.0.15.jar;D:\\mvnrepo\\com\\github\\pagehelper\\pagehelper-spring-boot-starter\\1.2.5\\pagehelper-spring-boot-starter-1.2.5.jar;D:\\mvnrepo\\com\\github\\pagehelper\\pagehelper-spring-boot-autoconfigure\\1.2.5\\pagehelper-spring-boot-autoconfigure-1.2.5.jar;D:\\mvnrepo\\com\\github\\pagehelper\\pagehelper\\5.1.4\\pagehelper-5.1.4.jar;D:\\mvnrepo\\com\\github\\jsqlparser\\jsqlparser\\1.0\\jsqlparser-1.0.jar;D:\\mvnrepo\\org\\apache\\dubbo\\dubbo-spring-boot-starter\\2.7.1\\dubbo-spring-boot-starter-2.7.1.jar;D:\\mvnrepo\\org\\apache\\dubbo\\dubbo-spring-boot-autoconfigure\\2.7.1\\dubbo-spring-boot-autoconfigure-2.7.1.jar;D:\\mvnrepo\\org\\apache\\dubbo\\dubbo-spring-boot-autoconfigure-compatible\\2.7.1\\dubbo-spring-boot-autoconfigure-compatible-2.7.1.jar;D:\\mvnrepo\\org\\apache\\dubbo\\dubbo\\2.7.2\\dubbo-2.7.2.jar;D:\\mvnrepo\\org\\springframework\\spring-context\\5.1.6.RELEASE\\spring-context-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\javassist\\javassist\\3.20.0-GA\\javassist-3.20.0-GA.jar;D:\\mvnrepo\\io\\netty\\netty-all\\4.1.34.Final\\netty-all-4.1.34.Final.jar;D:\\mvnrepo\\com\\google\\code\\gson\\gson\\2.8.5\\gson-2.8.5.jar;D:\\mvnrepo\\org\\yaml\\snakeyaml\\1.23\\snakeyaml-1.23.jar;D:\\mvnrepo\\org\\apache\\curator\\curator-recipes\\4.0.1\\curator-recipes-4.0.1.jar;D:\\mvnrepo\\org\\apache\\curator\\curator-framework\\4.0.1\\curator-framework-4.0.1.jar;D:\\mvnrepo\\org\\apache\\curator\\curator-client\\4.0.1\\curator-client-4.0.1.jar;D:\\mvnrepo\\org\\apache\\zookeeper\\zookeeper\\3.4.13\\zookeeper-3.4.13.jar;D:\\mvnrepo\\log4j\\log4j\\1.2.16\\log4j-1.2.16.jar;D:\\mvnrepo\\jline\\jline\\0.9.94\\jline-0.9.94.jar;D:\\mvnrepo\\org\\apache\\yetus\\audience-annotations\\0.5.0\\audience-annotations-0.5.0.jar;D:\\mvnrepo\\redis\\clients\\jedis\\3.0.1\\jedis-3.0.1.jar;D:\\mvnrepo\\org\\apache\\commons\\commons-pool2\\2.6.1\\commons-pool2-2.6.1.jar;D:\\mvnrepo\\com\\google\\guava\\guava\\18.0\\guava-18.0.jar;D:\\mvnrepo\\joda-time\\joda-time\\2.10.1\\joda-time-2.10.1.jar;D:\\mvnrepo\\commons-io\\commons-io\\2.6\\commons-io-2.6.jar;D:\\mvnrepo\\commons-beanutils\\commons-beanutils\\1.9.3\\commons-beanutils-1.9.3.jar;D:\\mvnrepo\\commons-logging\\commons-logging\\1.2\\commons-logging-1.2.jar;D:\\mvnrepo\\commons-collections\\commons-collections\\3.2.2\\commons-collections-3.2.2.jar;D:\\mvnrepo\\org\\springframework\\spring-core\\5.1.6.RELEASE\\spring-core-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\springframework\\spring-jcl\\5.1.6.RELEASE\\spring-jcl-5.1.6.RELEASE.jar;D:\\mvnrepo\\org\\apache\\httpcomponents\\httpclient\\4.5.8\\httpclient-4.5.8.jar;D:\\mvnrepo\\org\\apache\\httpcomponents\\httpcore\\4.4.11\\httpcore-4.4.11.jar;D:\\mvnrepo\\commons-codec\\commons-codec\\1.11\\commons-codec-1.11.jar;D:\\mvnrepo\\commons-net\\commons-net\\3.5\\commons-net-3.5.jar;D:\\mvnrepo\\javax\\mail\\mail\\1.4.7\\mail-1.4.7.jar;D:\\mvnrepo\\javax\\activation\\activation\\1.1\\activation-1.1.jar;D:\\mvnrepo\\javax\\servlet\\javax.servlet-api\\4.0.1\\javax.servlet-api-4.0.1.jar;D:\\mvnrepo\\org\\apache\\commons\\commons-lang3\\3.8.1\\commons-lang3-3.8.1.jar;D:\\mvnrepo\\com\\alibaba\\fastjson\\1.2.58\\fastjson-1.2.58.jar"; //源文件地址
        String desPathStr = "D:\\idea-workspace\\notice\\lib"; //目标文件地址
        String[] strings = srcPathStr.split(";");

        for (String string : strings) {
            System.out.println(string);
        }

        for (String string : strings) {
            copy(string, desPathStr);//将E:\\java task\\zhl.txt文件拷贝到E:\\java task\\zhlll
        }

    }

    public static void main1(String[] args) {
        String srcPathStr = "D:\\mvnrepo\\com\\alibaba\\fastjson\\1.2.58\\fastjson-1.2.58.jar";
        String desPathStr = "D:\\idea-workspace\\notice\\lib";
        copy(srcPathStr, desPathStr);
    }
}
