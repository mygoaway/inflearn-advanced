package hello.inflearnadvanced.app.v4;

import hello.inflearnadvanced.trace.logtrace.LogTrace;
import hello.inflearnadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if(itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생");
                }
                sleep(1000); // 1초간
                return null;
            }
        };
        template.execute("orderRepository.request()");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
