import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;

import java.util.function.BiFunction;

public class rxtest {
    public static void main(String[] args) {
//        int dan = 7;
//        Observable.range(1,9)
//                .flatMap(it -> Observable.just("" + it * dan))
//                .subscribe(it -> System.out.println(it));

        Observable.range(1,9)
                .flatMap(arg1 -> Observable
                        .range(1,9)
                        .flatMap(arg2 -> Observable.just(arg1 + " * " + arg2 + " = " + arg1 * arg2 ))
                ).subscribe(it -> System.out.println(it));


    }
}
