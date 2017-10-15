package cat.tecnocampus.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import cat.tecnocampus.domain.Classroom;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
@Aspect
@Component
public class LoggerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);


    @Pointcut("execution(* cat.tecnocampus.persintence.Controller.*(..))")
    public void pointcutClassroom() {logger.info("Going to get a classroom method");}

    @Before("pointcutClassroom()")
    public void beforeit(){logger.info("Before a class classroom");}






    @Pointcut("execution(* cat.tecnocampus.persintence.Controller.find*(..))")

    public void pointcutFind() {logger.info("Going to show a method with find word");}

    @After("pointcutFind()")
    public void afterIt(){logger.info("After a method with 'find' word");}





    @Pointcut("execution(* cat.tecnocampus.persintence.Controller.insertBatch(..))")
    public void pointcutBach() {logger.info("Insterting a batch");}

    @Around("pointcutBach()")
    public void pointBatch(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("before multiple insert " + joinPoint);
        if (true) {
            joinPoint.proceed(); System.out.println("insertBatch");
        }
        logger.info("after multiple insert " + joinPoint);
    }

}
