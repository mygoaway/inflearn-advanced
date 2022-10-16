package hello.inflearnadvanced.trace.tracelocal.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {
    private ThreadLocalService fieldService = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");

        Runnable userA = () -> fieldService.logic("userA");
        Runnable userB = () -> fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        // sleep(2000); // 동시성 문제 발생 X
        sleep(100); // 동시성 문제 발생 O
        threadB.start();

        sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
