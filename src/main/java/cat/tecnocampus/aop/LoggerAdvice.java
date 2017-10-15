package cat.tecnocampus.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);


    @Pointcut("execution(* cat.tecnocampus.Controllers.Controller.*(..))")
    public void pointcutClassroom() {logger.info("Going to get a classroom method");}

    @Before("pointcutClassroom()")
    public void beforeit(){logger.info("Working with a classroom");}






    @Pointcut("execution(* cat.tecnocampus.Controllers.Controller.find*(..))")

    public void pointcutFind() {logger.info("Going to show a method with find word");}

    @After("pointcutFind()")
    public void afterIt(){logger.info("Finding Classrooms...");}





    @Pointcut("execution(* cat.tecnocampus.Controllers.Controller.insertBatch(..))")
    public void pointcutBach() {logger.info("Insterting a batch");}

    @Around("pointcutBach()")
    public int[] dealRequestParam(ProceedingJoinPoint jp) {
        try {
            logger.info("Before showing insert");
            int[] res = (int[]) jp.proceed();
            logger.info("After showing insert");
            return res;
        } catch (Throwable throwable) {
            logger.info("Showing classrooms: Something went wrong");
            throwable.printStackTrace();
            return new int[]{};
        }
    }

}
