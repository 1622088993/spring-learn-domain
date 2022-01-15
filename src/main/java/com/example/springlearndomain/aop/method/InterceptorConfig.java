package com.example.springlearndomain.aop.method;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/5 12:19
 * @Version: 1.0
 * @Description:
 */
@Configuration
public class InterceptorConfig {

    private static final String point="execution(* com.example.springlearndomain..*.save*(..))";


    /**
     * 1、声明出代理工厂。
     * 2、设置切点
     * 3、设置通知
     * 4、为工厂添加切面
     * 请记住：切面=切点+通知
     * @return
     */
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        QueryMethodInterceptor queryMethodInterceptor = new QueryMethodInterceptor();
        //声明一个aspectj切点
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(point);
        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(aspectJExpressionPointcut);
        advisor.setAdvice(queryMethodInterceptor);
        return advisor;
    }

}
