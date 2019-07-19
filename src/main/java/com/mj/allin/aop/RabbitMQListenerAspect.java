package com.mj.allin.aop;

import com.mj.allin.util.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * aop
 */
@Aspect
@Component
public class RabbitMQListenerAspect {
    private final static Logger logger = LoggerFactory.getLogger(RabbitMQListenerAspect.class);
    private final static String TIME_FORMAT = "%s方法执行了：%ds";

    @Pointcut("execution(* com.mj.allin.message.*.*(..))")
    public void point() {
    }

    @Around("point()")
    public Object doAround(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
//        if(sendFlag && obj!=null && obj instanceof Message){
//            Message message = (Message)obj;
//            senderService.send(message);
//        }
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getDeclaringTypeName() + "."
                + signature.getName();
        LogUtil.info(logger, String.format(TIME_FORMAT, methodName, (endTime - startTime) / 1000));
        return obj;
    }
}
