package cn.syk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author syk
 * @date 2021/12/29 7:35
 **/
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * cn.syk.controller..*.*(..))")
    public void controllerLog() {
    }

    /*
     * @Before @After 组合相当于@Arround(需要执行嵌入的切入点方法proceedingJoinPoint.proceed()并返回对象)
     * */
    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        // 记录下请求内容
        /*logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());*/
    }

    @After("controllerLog()")
    public void logAfterController(JoinPoint joinPoint) {

    }

    /*Around可以替代一切*/
    @Around("controllerLog()")
    public Object logAroundController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //new Thread().sleep(5000);
        return proceedingJoinPoint.proceed() + "";//在环绕中修改切入点的返回值是可行的
    }

    /*AfterReturning不能修改返回值，因为返回值在*/
    @AfterReturning(value = "controllerLog()", returning = "joinPoint")
    public String logAfterReturningController(String joinPoint) {
        joinPoint = joinPoint + "优惠优惠！！";
        System.out.println("切面获取到的返回信息:" + joinPoint);
        return joinPoint;
    }

    @AfterThrowing(pointcut = "controllerLog()", throwing = "exception")
    public void logAfterThrowingController(Exception exception) {
        System.out.println("切面获取到的错误信息:" + exception.getMessage());
    }
}
