package com.example.sprinbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

public class MonoFluxTest {
    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("javatechie")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

    }
    @Test
    public void testFlux(){
        Flux<String> fluxstring = Flux.just("a","b","c","d")
                .concatWithValues("aws")
                .concatWith((Flux.error((new RuntimeException("Exception occured in Flux")))))
                .concatWithValues("e")
                .log();

        fluxstring.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
}
