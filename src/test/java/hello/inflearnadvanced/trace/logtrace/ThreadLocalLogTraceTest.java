package hello.inflearnadvanced.trace.logtrace;

import hello.inflearnadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_leve2() {
        TraceStatus status1 = trace.begin("HELLO1");
        TraceStatus status2 = trace.begin("HELLO2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_leve2() {
        TraceStatus status1 = trace.begin("HELLO1");
        TraceStatus status2 = trace.begin("HELLO2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}