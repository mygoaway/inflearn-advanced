package hello.inflearnadvanced.trace.strategy;

import hello.inflearnadvanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    /**
     * 전략패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV2 contextV1 = new ContextV2();
        contextV1.execute(strategyLogic1);

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(strategyLogic2);
    }

    /**
     * 전략패턴 사용, 익명 내부 클래스 사용
     */
    @Test
    void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        ContextV2 contextV1 = new ContextV2();
        log.info("클래스 이름1={}", strategyLogic1.getClass());
        contextV1.execute(strategyLogic1);

        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        ContextV2 contextV2 = new ContextV2();
        log.info("클래스 이름1={}", strategyLogic2.getClass());
        contextV2.execute(strategyLogic2);
    }

    /**
     * 전략 패턴 익명 내부 클래스2
     */
    @Test
    void strategyV3() {
        ContextV2 contextV1 = new ContextV2();
        contextV1.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });

        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
    }

    /**
     * 전략 패턴, 람다
     */
    @Test
    void strategyV4() {
        ContextV2 contextV1 = new ContextV2();
        contextV1.execute(()->log.info("비즈니스 로직1 실행"));

        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(()->log.info("비즈니스 로직2 실행"));
    }
}
